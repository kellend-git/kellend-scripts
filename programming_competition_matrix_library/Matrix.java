/**
 * Kellen Donohue
 * Nov 1, 2011
 * Matrix.java
 */
import java.util.Arrays;

/**
 * @author Kellen Don't implement this all, just the necessary parts.
 */
public class Matrix {
  // Dimensions
  final int rows, cols;
  double[][] matrix;

  // Returns the zero matrix
  public Matrix(int m, int n) {
    this.rows = m;
    this.cols = n;
    this.matrix = new double[m][n];
  }

  // Copy constructor
  public Matrix(Matrix mat) {
    this.rows = mat.rows;
    this.cols = mat.cols;
    matrix = new double[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = mat.matrix[i][j];
      }
    }
  }

  // k-by-k Identity matrix
  public static Matrix eye(int k) {
    Matrix m = new Matrix(k, k);
    for (int i = 0; i < k; i++) {
      m.matrix[i][i] = 1;
    }
    return m;
  }

  public Matrix add(Matrix other) {
    if (other.rows != this.rows || other.cols != this.cols) {
      throw new RuntimeException("Incompatible size");
    }
    Matrix result = new Matrix(rows, cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
      }
    }
    return result;
  }

  public Matrix sub(Matrix other) {
    if (other.rows != this.rows || other.cols != this.cols) {
      throw new RuntimeException("Incompatible size");
    }
    Matrix result = new Matrix(rows, cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
      }
    }
    return result;
  }

  public Matrix mult(int scalar) {
    Matrix result = new Matrix(this.rows, this.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        result.matrix[i][j] = this.matrix[i][j] * scalar;
      }
    }
    return result;
  }

  public Matrix mult(Matrix other) {
    if (other.rows != this.cols) {
      throw new RuntimeException("Incompatible size");
    }
    Matrix result = new Matrix(this.rows, other.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < other.cols; j++) {
        int total = 0;
        for (int k = 0; k < this.cols; k++) {
          total += this.matrix[i][k] * other.matrix[k][j];
        }
        result.matrix[i][j] = total;
      }
    }
    return result;
  }

  // Component-wise multiplication
  public Matrix compMult(Matrix other) {
    if (other.rows != this.rows || other.cols != this.cols) {
      throw new RuntimeException("Incompatible size");
    }
    Matrix result = new Matrix(rows, cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        result.matrix[i][j] = this.matrix[i][j] * other.matrix[i][j];
      }
    }
    return result;
  }

  public Matrix transpose() {
    Matrix result = new Matrix(this.cols, this.rows);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        result.matrix[j][i] = this.matrix[i][j];
      }
    }
    return result;
  }

  // Return a matrix that is this in rref form
  public Matrix rref() {
    Matrix result = new Matrix(this);
    int i = 0;
    int j = 0;

    // Row-Ech Form
    while (i < result.rows && j < result.cols) {
      int maxi = i;
      for (int k = i + 1; k < result.rows; k++) {
        if (Math.abs(result.matrix[k][j]) > Math.abs(result.matrix[maxi][j])) {
          maxi = k;
        }
      }
      if (result.matrix[maxi][j] != 0) {
        result.swapRow(i, maxi);
        result.divideRow(i, result.matrix[i][j]);
        for (int u = i + 1; u < result.rows; u++) {
          result.subRow(u, result.rowFactor(i, result.matrix[u][j]));
        }
        i++;
      }
      j++;
    }

    // Back substitute
    for (int row = result.rows - 2; row >= 0; row--) {
      for (int col = result.rows - 1; col > row; col--) {
        if (col < result.cols) {
          result.subRow(row, result.rowFactor(col, result.matrix[row][col]));
        }
      }
    }

    return result;
  }

  public double determinant() throws Exception {
    if (this.rows != this.cols) {
      throw new Exception("Can't get the det of a not-square matrix.");
    }
    return determinant(this.matrix);
  }

  private double determinant(double[][] mat) {
    double result = 0;

    if (mat.length == 1) {
      result = mat[0][0];
      return result;
    }

    if (mat.length == 2) {
      result = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
      return result;
    }

    for (int i = 0; i < mat[0].length; i++) {
      double temp[][] = new double[mat.length - 1][mat[0].length - 1];

      for (int j = 1; j < mat.length; j++) {
        System.arraycopy(mat[j], 0, temp[j - 1], 0, i);
        System.arraycopy(mat[j], i + 1, temp[j - 1], i, mat[0].length - i - 1);
      }

      result += mat[0][i] * Math.pow(-1, i) * determinant(temp);
    }
    return result;
  }

  public Matrix invert() throws Exception {
    if (this.rows != this.cols) {
      throw new Exception("Can't invert a non-square matrix. Try rref instead.");
    }
    if (this.determinant() == 0) {
      return null;
    }
    // build [A | I]
    Matrix m = new Matrix(this.rows, this.cols * 2);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        m.matrix[i][j] = this.matrix[i][j];
        if (i == j) {
          m.matrix[i][j + this.cols] = 1;
        }
      }
    }

    // rref gives us [I | A^-1]
    m = m.rref();

    // copy result back -- from the right side
    Matrix result = new Matrix(this.rows, this.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        result.matrix[i][j] = m.matrix[i][j + result.cols];
      }
    }
    return result;
  }

  // Mutator methods -- private

  // Subtract the given values from a row of this matrix, mutating its state
  private void subRow(int fromRow, double[] otherRow) {
    for (int c = 0; c < this.cols; c++) {
      this.matrix[fromRow][c] -= otherRow[c];
    }
  }

  // Multiply row i by scalar d without changing the actual matrix value
  private double[] rowFactor(int row, double factor) {
    double[] resultRow = new double[this.cols];
    for (int c = 0; c < this.cols; c++) {
      resultRow[c] = this.matrix[row][c] * factor;
    }
    return resultRow;
  }

  // Divide row i by a scalar d
  private void divideRow(int i, double d) {
    for (int c = 0; c < this.cols; c++) {
      this.matrix[i][c] /= d;
    }
  }

  private void swapRow(int r, int i) {
    double[] tempRow = this.matrix[r];
    this.matrix[r] = this.matrix[i];
    this.matrix[i] = tempRow;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(matrix);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result += this.matrix[i][j];
      }
    }
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Matrix other = (Matrix) obj;
    if (this.rows != other.rows || this.cols != other.cols) {
      return false;
    } else {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (this.matrix[i][j] - other.matrix[i][j] > 0.0000001) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      result.append(Arrays.toString(this.matrix[i]));
      result.append("\n");
    }
    return result.toString();
  }
}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Kellen Donohue
 * Nov 1, 2011
 * MatrixTest.java
 */

/**
 * @author Kellen
 * 
 */
public class MatrixTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void simpleAdd() {
    Matrix a = new Matrix(2, 2);
    a.matrix[0][0] = 1;
    a.matrix[0][1] = 2;
    a.matrix[1][0] = 3;
    a.matrix[1][1] = 4;

    Matrix b = new Matrix(2, 2);
    b.matrix[0][0] = 5;
    b.matrix[0][1] = 6;
    b.matrix[1][0] = 7;
    b.matrix[1][1] = 8;

    Matrix c = new Matrix(2, 2);
    c.matrix[0][0] = 6;
    c.matrix[0][1] = 8;
    c.matrix[1][0] = 10;
    c.matrix[1][1] = 12;
    Assert.assertEquals(a.add(b), c);
    Assert.assertEquals(b.add(a), c);
  }

  @Test
  public void simpleSub() {
    Matrix a = new Matrix(2, 2);
    a.matrix[0][0] = 9;
    a.matrix[0][1] = 8;
    a.matrix[1][0] = 7;
    a.matrix[1][1] = 6;

    Matrix b = new Matrix(2, 2);
    b.matrix[0][0] = 5;
    b.matrix[0][1] = 6;
    b.matrix[1][0] = 7;
    b.matrix[1][1] = 8;

    Matrix c = new Matrix(2, 2);
    c.matrix[0][0] = 4;
    c.matrix[0][1] = 2;
    c.matrix[1][0] = 0;
    c.matrix[1][1] = -2;
    Assert.assertEquals(a.sub(b), c);
  }

  @Test
  public void scalarMult() {
    Matrix a = new Matrix(2, 2);
    a.matrix[0][0] = 9;
    a.matrix[0][1] = 8;
    a.matrix[1][0] = 7;
    a.matrix[1][1] = 6;
    Matrix b = new Matrix(2, 2);
    b.matrix[0][0] = 18;
    b.matrix[0][1] = 16;
    b.matrix[1][0] = 14;
    b.matrix[1][1] = 12;
    Assert.assertEquals(a.mult(2), b);
  }

  @Test
  public void simpleMatMul() {
    Matrix a = new Matrix(2, 2);
    a.matrix[0][0] = 1;
    a.matrix[0][1] = 2;
    a.matrix[1][0] = 3;
    a.matrix[1][1] = 4;
    Matrix b = new Matrix(2, 2);
    b.matrix[0][0] = 5;
    b.matrix[0][1] = 6;
    b.matrix[1][0] = 7;
    b.matrix[1][1] = 8;
    Matrix c = new Matrix(2, 2);
    c.matrix[0][0] = 19;
    c.matrix[0][1] = 22;
    c.matrix[1][0] = 43;
    c.matrix[1][1] = 50;
    Assert.assertEquals(a.mult(b), c);
  }

  @Test
  public void complexMatMul() {
    Matrix a = new Matrix(2, 1);
    a.matrix[0][0] = 1;
    a.matrix[1][0] = 3;
    Matrix b = new Matrix(1, 2);
    b.matrix[0][0] = 5;
    b.matrix[0][1] = 6;
    Matrix c = new Matrix(2, 2);
    c.matrix[0][0] = 5;
    c.matrix[0][1] = 6;
    c.matrix[1][0] = 15;
    c.matrix[1][1] = 18;
    Assert.assertEquals(a.mult(b), c);
  }

  @Test
  public void componentMatMul() {
    Matrix a = new Matrix(2, 2);
    a.matrix[0][0] = 1;
    a.matrix[0][1] = 2;
    a.matrix[1][0] = 3;
    a.matrix[1][1] = 4;
    Matrix b = new Matrix(2, 2);
    b.matrix[0][0] = 5;
    b.matrix[0][1] = 6;
    b.matrix[1][0] = 7;
    b.matrix[1][1] = 8;
    Matrix c = new Matrix(2, 2);
    c.matrix[0][0] = 5;
    c.matrix[0][1] = 12;
    c.matrix[1][0] = 21;
    c.matrix[1][1] = 32;
    Assert.assertEquals(a.compMult(b), c);
    Assert.assertEquals(b.compMult(a), c);
  }

  @Test
  public void eyeMul() {
    Matrix a = new Matrix(2, 2);
    a.matrix[0][0] = 1;
    a.matrix[0][1] = 2;
    a.matrix[1][0] = 3;
    a.matrix[1][1] = 4;
    Assert.assertEquals(a.mult(Matrix.eye(2)), a);
    Assert.assertEquals(Matrix.eye(2).mult(a), a);
    Assert.assertEquals(Matrix.eye(2).mult(Matrix.eye(2)), Matrix.eye(2));
  }

  @Test
  public void rref() {
    Matrix a = new Matrix(3, 4);
    a.matrix[0][0] = 2;
    a.matrix[0][1] = 1;
    a.matrix[0][2] = -1;
    a.matrix[0][3] = 8;
    a.matrix[1][0] = -3;
    a.matrix[1][1] = -1;
    a.matrix[1][2] = 2;
    a.matrix[1][3] = -11;
    a.matrix[2][0] = -2;
    a.matrix[2][1] = 1;
    a.matrix[2][2] = 2;
    a.matrix[2][3] = -3;

    Matrix b = new Matrix(3, 4);
    b.matrix[0][0] = 1;
    b.matrix[0][1] = 0;
    b.matrix[0][2] = 0;
    b.matrix[0][3] = 2;
    b.matrix[1][0] = 0;
    b.matrix[1][1] = 1;
    b.matrix[1][2] = 0;
    b.matrix[1][3] = 3;
    b.matrix[2][0] = 0;
    b.matrix[2][1] = 0;
    b.matrix[2][2] = 1;
    b.matrix[2][3] = -1;
    Assert.assertEquals(a.rref(), b);
  }

  @Test
  public void biggerrref() {
    Matrix a = new Matrix(4, 5);
    a.matrix[0] = new double[] { 1, 2, 3, 4, 5 };
    a.matrix[1] = new double[] { 10, 9, 8, 7, 6 };
    a.matrix[2] = new double[] { -1, 0, -1, 1, 0 };
    a.matrix[3] = new double[] { 2, 4, 6, 8, 10 };

    Matrix b = new Matrix(4, 5);
    b.matrix[0] = new double[] { 1, 0, 0, -3.0 / 2, -3.0 / 2 };
    b.matrix[1] = new double[] { 0, 1, 0, 2, 1 };
    b.matrix[2] = new double[] { 0, 0, 1, 1.0 / 2, 3.0 / 2 };
    b.matrix[3] = new double[] { 0, 0, 0, 0, 0 };
    Assert.assertEquals(a.rref(), b);
  }

  @Test
  public void moreColsRref() {
    Matrix a = new Matrix(2, 3);
    a.matrix[0] = new double[] { 1, 9, 8 };
    a.matrix[1] = new double[] { 1, 5, 0 };

    Matrix b = new Matrix(2, 3);
    b.matrix[0] = new double[] { 1, 10, -10 };
    b.matrix[1] = new double[] { 0, 1, 2 };
    Assert.assertEquals(a.rref(), b);
  }

  @Test
  public void moreRowsRref() {
    Matrix a = new Matrix(3, 2);
    a.matrix[0] = new double[] { 7, 5 };
    a.matrix[1] = new double[] { 1, 7 };
    a.matrix[2] = new double[] { 2, 4 };

    Matrix b = new Matrix(3, 2);
    b.matrix[0] = new double[] { 1, 0 };
    b.matrix[1] = new double[] { 0, 1 };
    b.matrix[2] = new double[] { 0, 0 };
    Assert.assertEquals(a.rref(), b);
  }

  @Test
  public void testInvert() throws Exception {
    Matrix a = new Matrix(3, 3);
    a.matrix[0] = new double[] { 1, 3, 1 };
    a.matrix[1] = new double[] { 1, 1, 2 };
    a.matrix[2] = new double[] { 2, 3, 4 };

    Matrix b = new Matrix(3, 3);
    b.matrix[0] = new double[] { 2, 9, -5 };
    b.matrix[1] = new double[] { 0, -2, 1 };
    b.matrix[2] = new double[] { -1, -3, 2 };

    Assert.assertEquals(a.invert(), b);
  }

  @Test
  public void smallInvertTest() throws Exception {
    Matrix a = new Matrix(2, 2);
    a.matrix[0] = new double[] { 2, 3 };
    a.matrix[1] = new double[] { 3, 4 };

    Matrix b = new Matrix(2, 2);
    b.matrix[0] = new double[] { -4, 3 };
    b.matrix[1] = new double[] { 3, -2 };

    Assert.assertEquals(a.invert(), b);
  }

  @Test
  public void inverNotInvertible() throws Exception {
    Matrix a = new Matrix(2, 2);
    a.matrix[0] = new double[] { 1, 2 };
    a.matrix[1] = new double[] { 1, 2 };

    Assert.assertEquals(a.invert(), null);
  }

  @Test
  public void testDet2x2() throws Exception {
    Matrix a = new Matrix(2, 2);
    a.matrix[0] = new double[] { 2, 3 };
    a.matrix[1] = new double[] { 1, 4 };

    Assert.assertEquals(a.determinant(), 5.0, 0.001);
  }

  @Test
  public void testDet3x3() throws Exception {
    Matrix a = new Matrix(3, 3);
    a.matrix[0] = new double[] { 6, 5, 1 };
    a.matrix[1] = new double[] { 2, 0, 7 };
    a.matrix[2] = new double[] { 8, 9, 3 };

    Assert.assertEquals(a.determinant(), -110, 0.001);
  }

  @Test
  public void testDet4x4() throws Exception {
    Matrix a = new Matrix(4, 4);
    a.matrix[0] = new double[] { 6, 5, 1, 0 };
    a.matrix[1] = new double[] { 2, 0, 7, 4 };
    a.matrix[2] = new double[] { 8, 9, 3, -1 };
    a.matrix[3] = new double[] { -2, 3, -4, 5 };

    Assert.assertEquals(a.determinant(), -1092, 0.001);
  }

  @Test
  public void testTransposeSquare() throws Exception {
    Matrix a = new Matrix(4, 4);
    a.matrix[0] = new double[] { 6, 5, 1, 0 };
    a.matrix[1] = new double[] { 2, 0, 7, 4 };
    a.matrix[2] = new double[] { 8, 9, 3, -1 };
    a.matrix[3] = new double[] { -2, 3, -4, 5 };

    Matrix b = new Matrix(4, 4);
    b.matrix[0] = new double[] { 6, 2, 8, -2 };
    b.matrix[1] = new double[] { 5, 0, 9, 3 };
    b.matrix[2] = new double[] { 1, 7, 3, -4 };
    b.matrix[3] = new double[] { 0, 4, -1, 5 };

    Assert.assertEquals(a.transpose(), b);
  }

  @Test
  public void testTransposeNonSquare() throws Exception {
    Matrix a = new Matrix(3, 4);
    a.matrix[0] = new double[] { 6, 5, 1, 0 };
    a.matrix[1] = new double[] { 2, 0, 7, 4 };
    a.matrix[2] = new double[] { 8, 9, 3, -1 };

    Matrix b = new Matrix(4, 3);
    b.matrix[0] = new double[] { 6, 2, 8 };
    b.matrix[1] = new double[] { 5, 0, 9 };
    b.matrix[2] = new double[] { 1, 7, 3 };
    b.matrix[3] = new double[] { 0, 4, -1 };

    Assert.assertEquals(a.transpose(), b);
  }
}

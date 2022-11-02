package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

public class TwoDNodeTest {
  /*
   * Test getX and getY of TwoDNode
   */
  @Test
  public void testGetXAndGetYTwoDNodeClass() {
    System.out.println("getXAndGetYTwoDNodeClass");
    TwoDNode<Double> node = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(3, 9));
    assertEquals(3, node.getX());
    assertEquals(9, node.getY());
  }

  /*
   * Test getPoint of TwoDNode
   */
  @Test
  public void testGetPointTwoDNodeClass() {
    System.out.println("getPointTwoDNodeClass");
    TwoDNode<Double> node = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(3, 9));
    assertEquals(new Point2D.Double(3, 9), node.getCoords());
  }

  /*
   * Test clone of TwoDNode
   */
  @Test
  public void testCloneTwoDNodeClass() {
    System.out.println("cloneTwoDNodeClass");
    TwoDNode<Double> node = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(3, 9));
    TwoDNode<Double> nodeClone = node.clone();
    assertEquals(node.getElement(), nodeClone.getElement());
    assertEquals(node.getLeft(), nodeClone.getLeft());
    assertEquals(node.getRight(), nodeClone.getRight());
    assertEquals(node.getCoords(), nodeClone.getCoords());
  }

  /*
   * Test getLeft and getRight of TwoDNode
   */
  @Test
  public void testGetLeftAndRightTwoDNodeClass() {
    System.out.println("getLeftAndRightTwoDNodeClass");
    TwoDNode<Double> node = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(3, 9));
    assertEquals(null, node.getLeft());
    assertEquals(null, node.getRight());
  }

  /*
   * Test setLeft and setRight of TwoDNode
   */
  @Test
  public void testSetLeftAndRightTwoDNodeClass() {
    System.out.println("setLeftAndRightTwoDNodeClass");
    TwoDNode<Double> node = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(3, 9));
    TwoDNode<Double> nodeLeft = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(4, 5));
    TwoDNode<Double> nodeRight = new TwoDNode<Double>(3.9, null, null, new Point2D.Double(2, 3));
    node.setLeft(nodeLeft);
    node.setRight(nodeRight);
    assertEquals(nodeLeft, node.getLeft());
    assertEquals(nodeRight, node.getRight());
  }
}

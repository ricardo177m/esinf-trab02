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
}

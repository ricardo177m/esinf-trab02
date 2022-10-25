package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Point2D;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoDTreeTest {
  Point2D.Double[] arr = new Point2D.Double[6];
  {
    arr[0] = new Point2D.Double(30, 40);
    arr[1] = new Point2D.Double(5, 25);
    arr[2] = new Point2D.Double(10, 12);
    arr[3] = new Point2D.Double(70, 70);
    arr[4] = new Point2D.Double(50, 30);
    arr[5] = new Point2D.Double(35, 45);
  }

  private static TwoDTree<Double> tree;

  @BeforeEach
  public void setUp() {
    tree = new TwoDTree<>();

    tree.insert(30.40, arr[0].getX(), arr[0].getY());
    tree.insert(5.25, arr[1].getX(), arr[1].getY());
    tree.insert(10.12, arr[2].getX(), arr[2].getY());
    tree.insert(70.70, arr[3].getX(), arr[3].getY());
    tree.insert(50.30, arr[4].getX(), arr[4].getY());
    tree.insert(35.45, arr[5].getX(), arr[5].getY());
  }

  @Test
  public void testInsertionTwoDTree() {
    Iterable<Double> expected = List.of(10.12, 5.25, 30.40, 35.45, 50.30, 70.70);
    Iterable<Double> actual = tree.inOrder();

    assertEquals(expected, actual);
  }
}

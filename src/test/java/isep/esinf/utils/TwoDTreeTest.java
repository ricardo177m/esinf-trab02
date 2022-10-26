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

  @Test
  public void testFindTwoDTree() {
    assertEquals(tree.find(tree.root, 30.40).getElement(), 30.40);
    assertEquals(tree.find(tree.root, 30.40).getLeft().getElement(), 5.25);
    assertEquals(tree.find(tree.root, 30.40).getRight().getElement(), 70.70);
  }

  @Test
  public void testRemoveTwoDTree() {
    tree.remove(30.40);
    Iterable<Double> expected = List.of(10.12, 5.25, 35.45, 50.30, 70.70);
    Iterable<Double> actual = tree.inOrder();

    assertEquals(expected, actual);
  }

  // remove test
  @Test
  public void testRemoveTwoDTree2() {
    tree.remove(30.40);
    tree.remove(5.25);
    tree.remove(10.12);
    tree.remove(70.70);
    tree.remove(35.45);
    Iterable<Double> expected = List.of(50.30);
    Iterable<Double> actual = tree.inOrder();

    assertEquals(expected, actual);
  }

  @Test
  public void testSizeTwoDTree() {
    assertEquals(tree.size(), 6);
  }

  @Test
  public void testHeightTwoDTree() {
    assertEquals(tree.height(), 3);
  }

  @Test
  public void testSmallestElementTwoDTree() {
    assertEquals(tree.smallestElement(), 10.12);
  }

  @Test
  public void testNearestNeighbour() {
    tree = new TwoDTree<>();
    tree.insert(3.9, 3, 9);
    tree.insert(1.7, 1, 7);
    tree.insert(7.9, 7, 9);
    tree.insert(2.1, 2, 1);
    tree.insert(9.6, 9, 6);
    tree.insert(5.9, 5, 9);
    tree.insert(1.4, 1, 4);
    tree.insert(7.3, 7, 3);
    tree.insert(11.6, 11, 6);
    tree.insert(6.1, 6, 1);
    tree.insert(8.2, 8, 2);

    assertEquals(1.4, tree.findNearestNeighbor(4, 5));
  }
}

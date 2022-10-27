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
    System.out.println("insertionTwoDTree");
    Iterable<Double> expected = List.of(10.12, 5.25, 30.40, 35.45, 50.30, 70.70);
    Iterable<Double> actual = tree.inOrder();

    assertEquals(expected, actual);
  }

  /*
   * Test the search method of the TwoDTree class
   */
  @Test
  public void testFindTwoDTree() {
    System.out.println("findTwoDTree");
    assertEquals(tree.find(tree.root, 30.40).getElement(), 30.40);
    assertEquals(tree.find(tree.root, 30.40).getLeft().getElement(), 5.25);
    assertEquals(tree.find(tree.root, 30.40).getRight().getElement(), 70.70);
    assertEquals(tree.find(tree.root, 80.80), null);
  }

  /*
   * Test the remove method of the TwoDtTree class (remove the root)
   */
  @Test
  public void testRemoveTwoDTree() {
    System.out.println("removeTwoDTree");
    tree.remove(30.40);
    Iterable<Double> expected = List.of(10.12, 5.25, 35.45, 50.30, 70.70);
    Iterable<Double> actual = tree.inOrder();

    assertEquals(expected, actual);
  }

  /*
   * Test the remove method of the TwoDtTree class (remove several leafs)
   */
  public void testRemoveTwoDTree2() {
    System.out.println("removeTwoDTree2");
    tree.remove(30.40);
    tree.remove(5.25);
    tree.remove(10.12);
    tree.remove(70.70);
    tree.remove(35.45);
    Iterable<Double> expected = List.of(50.30);
    Iterable<Double> actual = tree.inOrder();

    assertEquals(expected, actual);
  }

  /*
   * Test the size method
   */
  @Test
  public void testSizeTwoDTree() {
    System.out.println("sizeTwoDTree");
    assertEquals(tree.size(), 6);
  }

  /*
   * Test the height method
   */
  @Test
  public void testHeightTwoDTree() {
    System.out.println("heightTwoDTree");
    assertEquals(tree.height(), 3);
  }

  /*
   * Test the smallest element method
   */
  @Test
  public void testSmallestElementTwoDTree() {
    System.out.println("smallestElementTwoDTree");
    assertEquals(tree.smallestElement(), 10.12);
  }

  /*
   * Test the nearest element method
   */
  @Test
  public void testNearestNeighbour() {
    System.out.println("nearestNeighbour");
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
    assertEquals(1.4, tree.findNearestNeighbor(2, 3));
    assertEquals(1.7, tree.findNearestNeighbor(1, 8));
    assertEquals(2.1, tree.findNearestNeighbor(2, 2));
    assertEquals(11.6, tree.findNearestNeighbor(15, 6.5));
    assertEquals(2.1, tree.findNearestNeighbor(3.5, 1));
  }

  /*
   * Test the search range area with two points
   */
  @Test
  public void testSearchRangeAreaWithTwoPoints() {
    System.out.println("searchRangeAreaWithTwoPoints");
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

    List<Double> expected = List.of(3.9, 7.9, 5.9, 9.6, 7.3, 6.1, 8.2);
    List<Double> actual = tree.searchRangeArea(3, 0, 9, 9);

    assertEquals(expected, actual);

  }

  /*
   * Test search range area with two points that makes it a horizontal line
   */
  @Test
  public void testSearchRangeAreaWithTwoPointsMakingAHorizontalLine() {
    System.out.println("searchRangeAreaWithTwoPointsMakingAHorizontalLine");
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

    List<Double> expected = List.of(3.9, 7.9, 5.9);
    List<Double> actual = tree.searchRangeArea(3, 9, 9, 9);

    assertEquals(expected, actual);

  }

  /*
   * Test search range area with two points where x1>x2 & y1>y2
   */
  @Test
  public void testSearchRangeAreaWithTwoPointsWhereFirstCoordsAreHigherThanTheSecond() {
    System.out.println("searchRangeAreaWithTwoPointsWhereFirstCoordsAreHigherThanTheSecond");
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

    List<Double> expected = List.of(3.9, 7.9, 5.9, 9.6, 7.3);
    List<Double> actual = tree.searchRangeArea(9, 9, 3, 3);

    assertEquals(expected, actual);

  }

  /*
   * Test search range area with two points where x1=x2 & y1<y2 making it a
   * vertical line
   */
  @Test
  public void testSearchRangeAreaWithTwoPointsMakingAVerticalLine() {
    System.out.println("searchRangeAreaWithTwoPointsMakingAVerticalLine");
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

    List<Double> expected = List.of(3.9);
    List<Double> actual = tree.searchRangeArea(3, 3, 3, 9);

    assertEquals(expected, actual);

  }

  /*
   * Test search range area with two points where x1=x2 & y1=y2
   */
  @Test
  public void testSearchRangeAreaWithTwoPointsMakingItASinglePoint() {
    System.out.println("searchRangeAreaWithTwoPointsMakingItASinglePoint");
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

    List<Double> expected = List.of();
    List<Double> actual = tree.searchRangeArea(3, 3, 3, 3);

    assertEquals(expected, actual);

  }

  /*
   * Test search range area with two points out of range
   */
  @Test
  public void testSearchRangeAreaWithTwoPointsOutOfRange() {
    System.out.println("searchRangeAreaWithTwoPointsOutOfRange");
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

    List<Double> expected = List.of();
    List<Double> actual = tree.searchRangeArea(-1000, -2000, -500, -300);

    assertEquals(expected, actual);

  }

  /*
   * Test search range area with two points inside the tree area but do not
   * contains any points
   */
  @Test
  public void testSearchRangeAreaWithTwoPointsOutOfRangeInsideTreeArea() {
    System.out.println("searchRangeAreaWithTwoPointsOutOfRangeInsideTreeArea");
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

    List<Double> expected = List.of();
    List<Double> actual = tree.searchRangeArea(5, 5, 7, 7);

    assertEquals(expected, actual);

  }

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

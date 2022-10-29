package isep.esinf.utils;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @author: André Barros
 * @author: Tomás Lopes
 *
 * TwoDTree Class
 */

public class TwoDTree<E extends Comparable<E>> extends BST<E> {

  /*
   * Comparator to compare two points by their x coordinate
   */
  private final Comparator<Point2D.Double> cmpX = new Comparator<Point2D.Double>() {
    @Override
    public int compare(Point2D.Double p1, Point2D.Double p2) {
      return Double.compare(p1.getX(), p2.getX());
    }
  };

  /*
   * Comparator to compare two points by their y coordinate
   */
  private final Comparator<Point2D.Double> cmpY = new Comparator<Point2D.Double>() {
    @Override
    public int compare(Point2D.Double p1, Point2D.Double p2) {
      return Double.compare(p1.getY(), p2.getY());
    }
  };

  /*
   * Insert a new element in the tree
   */
  public void insert(E element, double x, double y) {
    Point2D.Double point = new Point2D.Double(x, y);

    if (root == null)
      root = new TwoDNode<E>(element, null, null, point);
    else
      insert((TwoDNode<E>) root, element, point, true);
  }

  private TwoDNode<E> insert(TwoDNode<E> node, E element, Point2D.Double coords, boolean divX) {
    if (node != null && node.getCoords().equals(coords))
      return null;
    if (node == null)
      return new TwoDNode<E>(element, null, null, coords);

    int cmpResult = (divX ? cmpX : cmpY).compare(coords, node.getCoords());

    if (cmpResult < 0)
      node.setLeft(insert(node.getLeft(), element, coords, !divX));
    else
      node.setRight(insert(node.getRight(), element, coords, !divX));

    return node;
  }

  /*
   * Gets the distance of a point to the axis
   */
  private double distanceToAxis(TwoDNode<E> node, double x, double y, int depth) {
    boolean isXAxis = depth % 2 == 0;
    if (isXAxis)
      return x - node.getCoords().getX();
    else
      return y - node.getCoords().getY();
  }

  private TwoDNode<E> closest; // needs to be global to make the reference changing easier

  /*
   * Gets the closest element to a point
   */
  public E findNearestNeighbor(double x, double y) {
    closest = ((TwoDNode<E>) root).clone();
    return findNearestNeighbor((TwoDNode<E>) root, x, y, 0);
  }

  public E findNearestNeighbor(TwoDNode<E> node, double x, double y, int depth) {
    if (node == null)
      return null;

    double d = Point2D.distanceSq(node.getCoords().x, node.getCoords().y, x, y);
    double closestDist = Point2D.distanceSq(closest.getCoords().x, closest.getCoords().y, x, y);

    if (d < closestDist)
      closest = node;

    double delta = distanceToAxis(node, x, y, depth);
    double deltaSq = delta * delta;

    TwoDNode<E> node1 = delta < 0 ? node.getLeft() : node.getRight();
    TwoDNode<E> node2 = delta < 0 ? node.getRight() : node.getLeft();

    findNearestNeighbor(node1, x, y, depth + 1);
    if (deltaSq < closestDist)
      findNearestNeighbor(node2, x, y, depth + 1);

    return closest.getElement();
  }

  private List<E> contained = new ArrayList<>();

  /*
   * Gets all the elements contained in a rectangle
   */
  public List<E> searchRangeArea(double x1, double y1, double x2, double y2) {

    Point2D.Double lowCoords = generateLowCoords(x1, y1, x2, y2);
    Point2D.Double maxCoords = generateHighCoords(x1, y1, x2, y2);

    searchRangeArea((TwoDNode<E>) root, lowCoords, maxCoords, 0);

    return contained;
  }

  private Point2D.Double generateLowCoords(double x1, double y1, double x2, double y2) {
    return new Point2D.Double(Math.min(x1, x2), Math.min(y1, y2));
  }

  private Point2D.Double generateHighCoords(double x1, double y1, double x2, double y2) {
    return new Point2D.Double(Math.max(x1, x2), Math.max(y1, y2));
  }

  /*
   * Checks if a point is contained in a rectangle
   */
  private boolean isInRange(TwoDNode<E> node, Point2D.Double lowCoords, Point2D.Double highCoords) {
    return node.getCoords().getX() >= lowCoords.x && node.getCoords().getX() <= highCoords.x
        && node.getCoords().getY() >= lowCoords.y && node.getCoords().getY() <= highCoords.y;
  }

  public void searchRangeArea(TwoDNode<E> node, Point2D.Double lowCoords, Point2D.Double highCoords, int depth) {
    if (node == null)
      return;

    boolean isXAxis = depth % 2 == 0;

    int cmpLowResult = (isXAxis ? cmpX : cmpY).compare(lowCoords, node.getCoords());
    int cmpHighResult = (isXAxis ? cmpX : cmpY).compare(highCoords, node.getCoords());

    if (isInRange(node, lowCoords, highCoords)) {
      contained.add(node.getElement());
      searchRangeArea(node.getRight(), lowCoords, highCoords, depth + 1);
      searchRangeArea(node.getLeft(), lowCoords, highCoords, depth + 1);
    } else {
      if (cmpLowResult < 0)
        searchRangeArea(node.getRight(), lowCoords, highCoords, depth + 1);
      if (cmpHighResult > 0)
        searchRangeArea(node.getLeft(), lowCoords, highCoords, depth + 1);
    }

  }
}

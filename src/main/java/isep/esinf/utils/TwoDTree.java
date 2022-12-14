package isep.esinf.utils;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: André Barros
 * @author: Tomás Lopes
 *
 * TwoDTree Class
 */

public class TwoDTree<E extends Comparable<E>> extends BST<E> {

  private final Comparator<TwoDNode<E>> cmpX = new Comparator<TwoDNode<E>>() {
    @Override
    public int compare(TwoDNode<E> o1, TwoDNode<E> o2) {
      return Double.compare(o1.getX(), o2.getX());
    }
  };

  private final Comparator<TwoDNode<E>> cmpY = new Comparator<TwoDNode<E>>() {
    @Override
    public int compare(TwoDNode<E> o1, TwoDNode<E> o2) {
      return Double.compare(o1.getY(), o2.getY());
    }
  };

  /*
   * Build twoDTree balanced
   */
  public void buildTree(List<TwoDNode<E>> nodes) {
    if (nodes == null || nodes.contains(null))
      return;

    // start comparing by X axis
    root = buildTree(nodes, true);
  }

  private TwoDNode<E> buildTree(List<TwoDNode<E>> nodes, boolean divX) {
    if (nodes == null || nodes.isEmpty())
      return null;

    // sort list with merge sort
    List<TwoDNode<E>> sortedNodesList = (new MergeSort<TwoDNode<E>>()).sort(nodes, divX ? cmpX : cmpY);

    int mid = sortedNodesList.size() / 2;

    TwoDNode<E> node = new TwoDNode<E>(
        sortedNodesList.get(mid).getElement(),
        buildTree(sortedNodesList.subList(0, mid), !divX),
        null,
        sortedNodesList.get(mid).getCoords());

    if (mid + 1 <= sortedNodesList.size() - 1)
      node.setRight(buildTree(sortedNodesList.subList(mid + 1, sortedNodesList.size()), !divX));

    return node;
  }

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

    int cmpResult = (divX ? cmpX : cmpY).compare(new TwoDNode<E>(element, null, null, coords), node);

    if (cmpResult < 0)
      node.setLeft(insert(node.getLeft(), element, coords, !divX));
    else
      node.setRight(insert(node.getRight(), element, coords, !divX));

    return node;
  }

  public TwoDNode<E> findMin() {
    TwoDNode<E> node = findMin((TwoDNode<E>) root, true);
    if (node != null)
      return node;
    return null;
  }

  private TwoDNode<E> findMin(TwoDNode<E> node, boolean divX) {
    if (node == null)
      return null;
    if (divX) {
      if (node.getLeft() == null)
        return node;
      else
        return findMin(node.getLeft(), false);
    } else {
      List<TwoDNode<E>> list = new LinkedList<>();
      list.add(findMin(node, true));

      if (node.getLeft() != null)
        list.add(findMin(node.getLeft(), true));

      if (node.getRight() != null)
        list.add(findMin(node.getRight(), true));

      Collections.sort(list, cmpY);

      return list.get(0);

    }
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

  private E findNearestNeighbor(TwoDNode<E> node, double x, double y, int depth) {
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

  private void searchRangeArea(TwoDNode<E> node, Point2D.Double lowCoords, Point2D.Double highCoords, int depth) {
    if (node == null)
      return;

    boolean isXAxis = depth % 2 == 0;

    int cmpLowResult = (isXAxis ? cmpX : cmpY).compare(node, new TwoDNode<E>(null, null, null, lowCoords));
    int cmpHighResult = (isXAxis ? cmpX : cmpY).compare(node, new TwoDNode<E>(null, null, null, highCoords));

    if (isInRange(node, lowCoords, highCoords)) {
      contained.add(node.getElement());
      searchRangeArea(node.getRight(), lowCoords, highCoords, depth + 1);
      searchRangeArea(node.getLeft(), lowCoords, highCoords, depth + 1);
    } else {
      if (cmpLowResult <= 0)
        searchRangeArea(node.getRight(), lowCoords, highCoords, depth + 1);
      if (cmpHighResult >= 0)
        searchRangeArea(node.getLeft(), lowCoords, highCoords, depth + 1);
    }

  }
}

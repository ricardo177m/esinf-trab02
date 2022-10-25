package isep.esinf.utils;

import java.awt.geom.Point2D;
import java.util.Comparator;

public class TwoDTree<E extends Comparable<E>> extends BST<E> {
  private final Comparator<Point2D.Double> cmpX = new Comparator<Point2D.Double>() {
    @Override
    public int compare(Point2D.Double p1, Point2D.Double p2) {
      return Double.compare(p1.getX(), p2.getX());
    }
  };

  private final Comparator<Point2D.Double> cmpY = new Comparator<Point2D.Double>() {
    @Override
    public int compare(Point2D.Double p1, Point2D.Double p2) {
      return Double.compare(p1.getY(), p2.getY());
    }
  };

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

  public E findNearestNeighbor(TwoDNode<E> node, double x, double y, TwoDNode<E> closestNode, boolean divX) {
    if (node == null)
      return null;

    double d = Point2D.distanceSq(node.getCoords().getX(), node.getCoords().getY(), x, y);
    double closestDist = Point2D.distanceSq(closestNode.getCoords().getX(), closestNode.getCoords().getY(), x, y);

    if (closestDist > d) {
      closestNode = node;

      double delta = divX ? x - node.getCoords().getX() : y - node.getCoords().getY();
      double delta2 = delta * delta;

      TwoDNode<E> node1 = delta < 0 ? node.getLeft() : node.getRight();
      TwoDNode<E> node2 = delta < 0 ? node.getRight() : node.getLeft();

      findNearestNeighbor(node1, x, y, closestNode, !divX);
      if (delta2 < closestDist)
        findNearestNeighbor(node2, x, y, closestNode, !divX);
    }

    return closestNode.getElement();
  }
}

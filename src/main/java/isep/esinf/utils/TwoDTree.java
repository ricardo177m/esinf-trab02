package isep.esinf.utils;

import java.awt.geom.Point2D;
import java.util.Comparator;

public class TwoDTree<E extends Comparable<E>> extends BST<E> {
  TwoDNode<E> root;

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
    if (root == null)
      root = new TwoDNode<>(element, null, null, new Point2D.Double(x, y));
    else
      insert(root, element, new Point2D.Double(x, y), true);
  }

  private TwoDNode<E> insert(TwoDNode<E> node, E element, Point2D.Double coords, boolean divX) {
    if (node == null)
      return new TwoDNode<E>(element, null, null, coords);

    if (node.getCoords().equals(coords)) // Don't allow duplicates
      return null;

    int cmpResult = (divX ? cmpX : cmpY).compare(node.getCoords(), coords);

    if (cmpResult == -1)
      node.setLeft(insert(node.getLeft(), element, coords, !divX));
    else
      node.setRight(insert(node.getRight(), element, coords, !divX));

    return node;
  }
}

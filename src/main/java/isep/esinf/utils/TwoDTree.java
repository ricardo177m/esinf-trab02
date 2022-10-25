package isep.esinf.utils;

import java.awt.geom.Point2D;

public class TwoDTree<E extends Comparable<E>> extends BST<E> {
  TwoDNode<E> root;

  public void insert(E element, double x, double y) {
    if (root == null)
      root = new TwoDNode<>(element, null, null, new Point2D.Double(x, y));
    else
      insert(root, element, new Point2D.Double(x, y));
  }

  private TwoDNode<E> insert(TwoDNode<E> node, E element, Point2D.Double coords) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}

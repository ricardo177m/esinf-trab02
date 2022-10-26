package isep.esinf.utils;

import java.awt.geom.Point2D;

public class TwoDNode<E> extends Node<E> {
  private Point2D.Double coords;

  public TwoDNode(E element, TwoDNode<E> left, TwoDNode<E> right, Point2D.Double coords) {
    super(element, left, right);
    this.coords = coords;
  }

  @Override
  public TwoDNode<E> getLeft() {
    return (TwoDNode<E>) super.getLeft();
  }

  @Override
  public TwoDNode<E> getRight() {
    return (TwoDNode<E>) super.getRight();
  }

  public Point2D.Double getCoords() {
    return coords;
  }

  public Double getX() {
    return coords.x;
  }

  public Double getY() {
    return coords.y;
  }

  public TwoDNode<E> clone() {
    return new TwoDNode<E>(getElement(), getLeft(), getRight(), new Point2D.Double(coords.x, coords.y));
  }
}

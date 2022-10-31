package isep.esinf.utils;

public class Node<E> {
  private E element; // an element stored at this node
  private Node<E> left; // a reference to the left child (if any)
  private Node<E> right; // a reference to the right child (if any)

  /**
   * Constructs a node with the given element and neighbors.
   *
   * @param e          the element to be stored
   * @param leftChild  reference to a left child node
   * @param rightChild reference to a right child node
   */
  public Node(E e, Node<E> leftChild, Node<E> rightChild) {
    element = e;
    left = leftChild;
    right = rightChild;
  }

  // accessor methods
  public E getElement() {
    return element;
  }

  public Node<E> getLeft() {
    return left;
  }

  public Node<E> getRight() {
    return right;
  }

  // update methods
  public void setElement(E e) {
    element = e;
  }

  public void setLeft(Node<E> leftChild) {
    left = leftChild;
  }

  public void setRight(Node<E> rightChild) {
    right = rightChild;
  }

  @Override
  public String toString() {
    return String.format(element.toString());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof Node))
      return false;

    Node<E> node = (Node<E>) obj;
    // check own element
    if (!element.equals(node.getElement()))
      return false;

    // check children
    // this left null xor node left null -> false
    if ((left == null) ^ (node.getLeft() == null))
      return false;
    if (left != null && !left.equals(node.getLeft()))
      return false;
    // this right null xor node right null -> false
    if ((right == null) ^ (node.getRight() == null))
      return false;
    if (right != null && !right.equals(node.getRight()))
      return false;

    return true;
  }
}

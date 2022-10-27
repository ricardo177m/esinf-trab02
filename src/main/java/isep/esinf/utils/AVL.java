package isep.esinf.utils;

/**
 * AVL class.
 *
 * @author Carlos Lopes <XX@isep.ipp.pt>
 * @author Ricardo Moreira <XX@isep.ipp.pt>
 * @author Tomás Russo <1211288@isep.ipp.pt>
 * @param <E>
 */
public class AVL<E extends Comparable<E>> extends BST<E> implements AVLInterface<E> {
  /**
   * Returns the balance factor of the given node.
   *
   * @param node a valid Node within the tree
   *
   * @return balance factor of the given node
   */
  public int balanceFactor(Node<E> node) {
    if (node == null)
      return 0;

    return height(node.getRight()) - height(node.getLeft());
  }

  private Node<E> rightRotation(Node<E> node) {
    Node<E> leftChild = node.getLeft();
    node.setLeft(leftChild.getRight());
    leftChild.setRight(node);
    return leftChild; // left child is now the root of this subtree
  }

  private Node<E> leftRotation(Node<E> node) {
    Node<E> rightChild = node.getRight();
    node.setRight(rightChild.getLeft());
    rightChild.setLeft(node);
    return rightChild; // right child is now the root of this subtree
  }

  private Node<E> twoRotations(Node<E> node) {
    if (balanceFactor(node) < 0) {
      node.setLeft(leftRotation(node.getLeft()));
      node = rightRotation(node);
    } else {
      node.setRight(rightRotation(node.getRight()));
      node = leftRotation(node);
    }
    return node;
  }

  public Node<E> balanceNode(Node<E> node) {
    return null;
  }

  public void insert(E element) {

  }

  public void remove(E element) {

  }
}

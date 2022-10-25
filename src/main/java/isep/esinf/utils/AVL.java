package isep.esinf.utils;

/**
 * AVL class.
 * 
 * @author Carlos Lopes <1211277@isep.ipp.pt>
 * @author Ricardo Moreira <1211285@isep.ipp.pt>
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

  public Node<E> rightRotation(Node<E> node) {
    return null;
  }

  public Node<E> leftRotation(Node<E> node) {
    return null;
  }

  public Node<E> twoRotations(Node<E> node) {
    return null;
  }

  public Node<E> balanceNode(Node<E> node) {
    return null;
  }

  public void insert(E element) {

  }

  public void remove(E element) {

  }
}

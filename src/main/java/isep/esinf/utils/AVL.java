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
  public int balanceFactor(Node<E> node) {
    return 0;
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

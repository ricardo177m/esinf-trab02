package isep.esinf.utils;

import isep.esinf.utils.BST.Node;

/**
 * AVL interface.
 * 
 * @author Carlos Lopes <XX@isep.ipp.pt>
 * @author Ricardo Moreira <XX@isep.ipp.pt>
 * @author Tomás Russo <1211288@isep.ipp.pt>
 * @param <E>
 */
public interface AVLInterface<E extends Comparable<E>> extends BSTInterface<E> {
  public int balanceFactor(Node<E> node);

  public Node<E> rightRotation(Node<E> node);

  public Node<E> leftRotation(Node<E> node);

  public Node<E> twoRotations(Node<E> node);

  public Node<E> balanceNode(Node<E> node);

  public void insert(E element);

  public void remove(E element);
}

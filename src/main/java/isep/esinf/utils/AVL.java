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
    if (balanceFactor(node) < -1) { // left subtree is higher
      if (balanceFactor(node.getLeft()) > 0) // signals differ -> double rotation
        node = twoRotations(node);
      else // same signal -> single rotation
        node = rightRotation(node);
    } else if (balanceFactor(node) > 1) { // right subtree is higher
      if (balanceFactor(node.getRight()) < 0) // signals differ -> double rotation
        node = twoRotations(node);
      else // same signal -> single rotation
        node = leftRotation(node);
    }
    return node;
  }

  public void insert(E element) {
    root = insert(element, root);
  }

  private Node<E> insert(E element, Node<E> node) {
    if (node == null)
      return new Node<>(element, null, null);

    int cmp = element.compareTo(node.getElement());
    if (cmp < 0)
      node.setLeft(insert(element, node.getLeft()));
    else if (cmp > 0)
      node.setRight(insert(element, node.getRight()));
    else
      return node;

    // after setting the nodes, balance the tree
    return balanceNode(node);
  }

  public void remove(E element) {
    root = remove(element, root());
  }

  private Node<E> remove(E element, Node<E> node) {
    if (node == null)
      return null;

    int cmp = element.compareTo(node.getElement());
    if (cmp < 0)
      node.setLeft(remove(element, node.getLeft()));
    else if (cmp > 0)
      node.setRight(remove(element, node.getRight()));
    else {
      // this is the node to be removed
      // check if the node is a leaf
      if (node.getLeft() == null && node.getRight() == null)
        return null;
      // check if the node has only one child
      else if (node.getLeft() == null)
        return node.getRight();
      else if (node.getRight() == null)
        return node.getLeft();
      // the node has two children
      else {
        // choose the greatest element in the left subtree or the smallest in the right to replace
        // the node
        E min = super.smallestElement(node.getRight());
        node.setElement(min);
        node.setRight(remove(min, node.getRight()));
      }
    }
    // after removing the node, balance the tree
    return balanceNode(node);
  }

  public boolean equals(Object otherObj) {
    if (this == otherObj)
      return true;

    if (otherObj == null || this.getClass() != otherObj.getClass())
      return false;

    AVL<E> second = (AVL<E>) otherObj;
    return equals(root, second.root);
  }

  public boolean equals(Node<E> root1, Node<E> root2) {
    if (root1 == null && root2 == null)
      return true;
    else if (root1 != null && root2 != null) {
      if (root1.getElement().compareTo(root2.getElement()) == 0)
        return equals(root1.getLeft(), root2.getLeft())
            && equals(root1.getRight(), root2.getRight());
      else
        return false;
    } else
      return false;
  }
}

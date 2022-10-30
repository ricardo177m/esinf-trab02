package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeTest {

  /*
   * Test create Node null
   */
  @Test
  public void testCreateNode() {
    Node<Integer> node = new Node<Integer>(null, null, null);
    assertEquals(null, node.getElement());
  }

  /*
   * Test create Node with element
   */
  @Test
  public void testCreateNodeWithElement() {
    Node<Integer> node = new Node<Integer>(3, null, null);
    assertEquals(3, node.getElement());
  }

  /*
   * Test create Node with element
   */
  @Test
  public void testCreateNodeWithElementAndChilds() {
    Node<Integer> node = new Node<Integer>(3, new Node<>(2, null, null), new Node<>(4, null, null));
    assertEquals(3, node.getElement());
    assertEquals(2, node.getLeft().getElement());
    assertEquals(4, node.getRight().getElement());
  }

  /*
   * Test setElement of Node
   */
  @Test
  public void testSetElementNodeClass() {
    Node<Integer> node = new Node<Integer>(3, null, null);
    node.setElement(4);
    assertEquals(4, node.getElement());
  }

  /*
   * Test setLeft of Node
   */
  @Test
  public void testSetLeftNodeClass() {
    Node<Integer> node = new Node<Integer>(3, null, null);
    node.setLeft(new Node<>(2, null, null));
    assertEquals(2, node.getLeft().getElement());
  }

  /*
   * Test setRight of Node
   */
  @Test
  public void testSetRightNodeClass() {
    Node<Integer> node = new Node<Integer>(3, null, null);
    node.setRight(new Node<>(4, null, null));
    assertEquals(4, node.getRight().getElement());
  }

  /*
   * Test getLeft and getRight of Node
   */
  @Test
  public void testGetLeftAndRightNodeClass() {
    Node<Integer> node = new Node<Integer>(3, null, null);
    assertEquals(null, node.getLeft());
    assertEquals(null, node.getRight());
  }

  /*
   * Test toString of Node
   */
  @Test
  public void testToStringNode() {
    Node<Integer> node = new Node<Integer>(3, new Node<>(2, null, null), new Node<>(5, null, null));

    assertEquals("3", node.toString());
    assertEquals("2", node.getLeft().toString());
    assertEquals("5", node.getRight().toString());
  }
}

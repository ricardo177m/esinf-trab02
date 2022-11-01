
package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DEI-ESINF
 */
public class BSTTest {
  Integer[] arr = { 20, 15, 10, 13, 8, 17, 40, 50, 30, 7 };
  int[] height = { 0, 1, 2, 3, 3, 3, 3, 3, 3, 4 };
  Integer[] inOrderT = { 7, 8, 10, 13, 15, 17, 20, 30, 40, 50 };
  Integer[] preOrderT = { 20, 15, 10, 8, 7, 13, 17, 40, 30, 50 };
  Integer[] posOrderT = { 7, 8, 13, 10, 17, 15, 30, 50, 40, 20 };

  BST<Integer> instance;

  public BSTTest() {
  }

  @BeforeEach
  public void setUp() {
    instance = new BST<>();
    for (int i : arr)
      instance.insert(i);
  }

  /**
   * Test of size method, of class BST.
   */
  @Test
  public void testSize() {
    System.out.println("size");
    assertEquals(instance.size(), arr.length);

    BST<String> sInstance = new BST<>();
    assertEquals(sInstance.size(), 0);
    sInstance.insert("A");
    assertEquals(sInstance.size(), 1);
    sInstance.insert("B");
    assertEquals(sInstance.size(), 2);
    sInstance.insert("A");
    assertEquals(sInstance.size(), 2);
  }

  @Test
  public void testFind() {
    BST<String> s = new BST<>();
    s.insert("A");
    s.insert("B");
    s.insert("C");

    Node<String> n = s.find(s.root, "A");

    assertNotNull(n);
  }

  @Test
  public void testFindWithNull() {
    BST<String> s = new BST<>();
    s.insert("A");
    s.insert("B");
    s.insert("C");

    Node<String> n = s.find(s.root, "D");

    assertNull(n);
  }

  /**
   * Test of insert method, of class BST.
   */
  @Test
  public void testInsert() {
    System.out.println("insert");
    int arr[] = { 20, 15, 10, 13, 8, 17, 40, 50, 30, 20, 15, 10 };
    BST<Integer> instance = new BST<>();
    for (int i = 0; i < 9; i++) { // new elements
      instance.insert(arr[i]);
      assertEquals((i + 1), instance.size(), i + 1);
    }
    for (int i = 9; i < arr.length; i++) { // duplicated elements => same size
      instance.insert(arr[i]);
      assertEquals(instance.size(), 9);
    }
  }

  /**
   * Test of remove method, of class BST.
   */
  @Test
  public void testRemove() {
    System.out.println("remove");

    int qtd = arr.length;
    instance.remove(999);

    assertEquals(qtd, instance.size(), qtd);
    for (int i = 0; i < arr.length; i++) {
      instance.remove(arr[i]);
      qtd--;
      assertEquals(qtd, qtd, instance.size());
    }

    instance.remove(999);
    assertEquals(0, instance.size());
  }

  /**
   * Test of isEmpty method, of class BST.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isempty");

    assertFalse(instance.isEmpty());
    instance = new BST<>();
    assertTrue(instance.isEmpty());

    instance.insert(11);
    assertFalse(instance.isEmpty());

    instance.remove(11);
    assertTrue(instance.isEmpty());
  }

  /**
   * Test of height method, of class BST.
   */
  @Test
  public void testHeight() {
    System.out.println("height");

    instance = new BST<>();
    assertEquals(instance.height(), -1);
    for (int idx = 0; idx < arr.length; idx++) {
      instance.insert(arr[idx]);
      assertEquals(instance.height(), height[idx]);
    }
    instance = new BST<>();
    assertEquals(instance.height(), -1);
  }

  /**
   * Test of smallest element method, of class TREE.
   */
  @Test
  public void testSmallestElement() {
    System.out.println("smallestElement");
    assertEquals(7, instance.smallestElement());
    instance.remove(7);
    assertEquals(8, instance.smallestElement());
    instance.remove(8);
    assertEquals(10, instance.smallestElement());
  }

  /**
   * Test of biggest element method, of class TREE.
   */
  @Test
  public void testBiggestElement() {
    System.out.println("biggestElement");
    assertEquals(50, instance.biggestElement());
    instance.remove(50);
    assertEquals(40, instance.biggestElement());
    instance.remove(40);
    assertEquals(30, instance.biggestElement());
  }

  /**
   * Test of inOrder method, of class BST.
   */
  @Test
  public void testInOrder() {
    System.out.println("inOrder");
    List<Integer> lExpected = Arrays.asList(inOrderT);
    assertEquals(lExpected, instance.inOrder());
  }

  /**
   * Test of inOrder method, of class BST.
   */
  @Test
  public void testInOrderWithNullTree() {
    System.out.println("inOrder");
    List<Integer> lExpected = new ArrayList<>();
    assertEquals(lExpected, new BST<>().inOrder());
  }

  /**
   * Test of preOrder method, of class BST.
   */
  @Test
  public void testPreOrder() {
    System.out.println("preOrder");
    List<Integer> lExpected = Arrays.asList(preOrderT);
    assertEquals(lExpected, instance.preOrder());
  }

  /**
   * Test of preOrder method, of class BST.
   */
  @Test
  public void testPreOrderWithNullTree() {
    System.out.println("preOrder");
    List<Integer> lExpected = new ArrayList<>();
    assertEquals(lExpected, new BST<>().preOrder());
  }

  /**
   * Test of posOrder method, of class BST.
   */
  @Test
  public void testPosOrder() {
    System.out.println("posOrder");
    List<Integer> lExpected = Arrays.asList(posOrderT);
    assertEquals(lExpected, instance.posOrder());
  }

  /**
   * Test of posOrder method, of class BST.
   */
  @Test
  public void testPosOrderWithNullTree() {
    System.out.println("posOrder");
    List<Integer> lExpected = new ArrayList<>();
    assertEquals(lExpected, new BST<>().posOrder());
  }

  /**
   * Test of isLeaf method, of class TREE.
   */
  @Test
  public void testIsLeaf() {
    System.out.println("isLeaf");
    assertFalse(instance.isLeaf(instance.root));
    assertFalse(instance.isLeaf(instance.root.getLeft()));
    assertFalse(instance.isLeaf(instance.root.getRight()));
    assertTrue(instance.isLeaf(instance.root.getLeft().getLeft().getLeft().getLeft()));
  }

  /**
   * Test of isLeaf method, of class TREE.
   */
  @Test
  public void testIsLeafWithNullNode() {
    System.out.println("isLeaf");
    assertFalse(instance.isLeaf(null));
  }

  /**
   * Test of isLeaf method, of class TREE.
   */
  @Test
  public void testIsLeafWithOnlyOneChild() {
    System.out.println("isLeaf");
    Node<Integer> n = new Node<>(2, new Node<>(1, null, null), null);
    assertFalse(instance.isLeaf(n));
    n = new Node<>(2, null, new Node<>(1, null, null));
  }

  /*
   * Test toString method, of class BST.
   */
  @Test
  public void testToStringBST() {
    System.out.println("toStringBST");
    String expected = ("|	|-------50\n" +
        "|-------40\n" +
        "|	|-------30\n" +
        "20\n" +
        "|	|-------17\n" +
        "|-------15\n" +
        "|	|	|-------13\n" +
        "|	|-------10\n" +
        "|	|	|-------8\n" +
        "|	|	|	|-------7\n");

    assertEquals(expected, instance.toString());
  }

  /*
   * Test toString method, of class Node
   */
  @Test
  public void testToStringNode() {
    Node<Integer> n = new Node<>(2, new Node<>(1, null, null), new Node<>(3, null, null));
    String expected = ("2");
    assertEquals(expected, n.toString());
  }

  /*
   * Test smallestElement method, of class BST, returning null.
   */
  @Test
  public void testSmallestElementEmpty() {
    System.out.println("smallestElementEmpty");
    BST<Integer> instance = new BST<>();
    assertNull(instance.smallestElement());
  }

  /**
   * Test equals.
   */
  @Test
  public void testEquals() {
    // System.out.println(instance.toString());
    BST<Integer> instance2 = new BST<>();
    for (int i : arr)
      instance2.insert(i);
    assertTrue(instance.equals(instance2));
    instance2.insert(1);
    assertFalse(instance.equals(instance2));
  }
}

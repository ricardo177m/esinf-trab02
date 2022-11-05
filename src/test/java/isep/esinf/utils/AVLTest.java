package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DEI-ESINF
 */
public class AVLTest {

  public AVLTest() {
  }

  /**
   * Test of insert method, of class AVL.
   */
  @Test
  public void testInsert() {
    System.out.println("insertAVL");
    // test Simple right rotation
    AVL<Integer> instance = new AVL();
    int arr[] = { 8, 4, 10, 2, 6, 3 };
    Integer[] inorder1 = { 2, 3, 4, 6, 8, 10 };
    for (int i = 0; i < arr.length; i++) // new elements
      instance.insert(arr[i]);

    List<Integer> lExpected = Arrays.asList(inorder1);
    assertEquals(lExpected, instance.inOrder());

    // test Simple left rotation
    AVL<Integer> instance2 = new AVL();
    int arr2[] = { 8, 4, 10, 9, 15, 12 };
    Integer[] inorder2 = { 4, 8, 9, 10, 12, 15 };
    for (int i = 0; i < arr2.length; i++)
      instance2.insert(arr2[i]);

    lExpected = Arrays.asList(inorder2);
    assertEquals(lExpected, instance2.inOrder());
    assertEquals(instance2.height(), 2);

    // test double rotation
    AVL<Integer> instance3 = new AVL();
    int arr3[] = { 8, 4, 10, 2, 6, 5 };
    Integer[] inorder3 = { 2, 4, 5, 6, 8, 10 };
    for (int i = 0; i < arr3.length; i++)
      instance3.insert(arr3[i]);

    lExpected = Arrays.asList(inorder3);
    assertEquals(lExpected, instance3.inOrder());
    assertEquals(instance3.height(), 2);
  }

  /**
   * Test of remove method, of class AVL.
   */
  @Test
  public void testRemove() {
    System.out.println("removeAVL");
    List<Integer> lExpected;
    AVL<Integer> instance;

    instance = new AVL();
    int arr[] = { 8, 4, 10, 2, 6, 3 };
    for (int i = 0; i < arr.length; i++)
      instance.insert(arr[i]);

    // no rotations needed
    instance.remove(3);
    lExpected = Arrays.asList(2, 4, 6, 8, 10);
    assertEquals(lExpected, instance.inOrder());
    assertEquals(instance.height(), 2);

    // test Simple left rotation
    instance.remove(2);
    lExpected = Arrays.asList(4, 6, 8, 10);
    assertEquals(lExpected, instance.inOrder());
    assertEquals(instance.height(), 2);

    instance.remove(10);
    lExpected = Arrays.asList(4, 6, 8);
    assertEquals(lExpected, instance.inOrder());
    assertEquals(instance.height(), 1);

    instance.remove(6);
    lExpected = Arrays.asList(4, 8);
    assertEquals(lExpected, instance.inOrder());
    assertEquals(1, instance.height());

    instance.remove(4);
    lExpected = Arrays.asList(8);
    assertEquals(lExpected, instance.inOrder());
    assertEquals(0, instance.height());

    instance.remove(8);
    lExpected = Arrays.asList();
    assertEquals(lExpected, instance.inOrder());
    assertEquals(-1, instance.height());
  }

  @Test
  public void testEquals() {
    System.out.println("equalsAVL");
    AVL<Integer> instance = new AVL<>();
    int arr[] = { 1, 8 };
    for (int i = 0; i < arr.length; i++) {
      instance.insert(arr[i]);
    }
    AVL<Integer> instance2 = new AVL<>();
    int arr2[] = { 1, 8 };
    for (int i = 0; i < arr2.length; i++) {
      instance2.insert(arr2[i]);
    }
    assertTrue(instance.equals(instance2));
    instance2.remove(8);
    assertFalse(instance.equals(instance2));
  }

  @Test
  public void testBalanceFactorWithRootNull() {
    System.out.println("balanceFactorWithRootNull");
    AVL<Integer> instance = new AVL<>();
    assertEquals(0, instance.balanceFactor(null));

  }

  @Test
  public void testRemoveElementNodeNull() {
    System.out.println("removeElementNodeNull");
    AVL<Integer> instance = new AVL<>();
    instance.remove(1);
    assertEquals(0, instance.size());

  }

  @Test
  public void testRemoveElementAndNodeIsLeaf() {
    System.out.println("removeElementAndNodeIsLeaf");
    AVL<Integer> instance = new AVL<>();
    instance.insert(1);
    instance.remove(1);
    assertEquals(0, instance.size());

  }
}

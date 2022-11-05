package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Item;

public class ItemByCPCTest {

  /*
   * Test item by cpc
   */
  @Test
  public void testItemByCPC() {
    System.out.println("testItemByCPC");
    ItemByCPC item = new ItemByCPC(1, "1", "Item");
    assertEquals("Item", item.getItem());
    assertEquals(1, item.getCode());
    assertEquals("1", item.getCpc());
  }

  /*
   * Test item by cpc compare not equal
   */
  @Test
  public void testItemByCPCCompareNotEqualLess() {
    System.out.println("testItemByCPCCompareNotEqualLess");
    ItemByCPC item = new ItemByCPC(1, "1", "Item");
    ItemByCPC item2 = new ItemByCPC(2, "2", "Item");
    assertTrue(item.compareTo(item2) < 0);
  }

  /*
   * Test item by cpc compare equal
   */
  @Test
  public void testItemByCPCCompareEqual() {
    System.out.println("testItemByCPCCompareEqual");
    ItemByCPC item = new ItemByCPC(1, "1", "Item");
    ItemByCPC item2 = new ItemByCPC(1, "1", "Item");
    assertEquals(0, item.compareTo(item2));
  }

  /*
   * Test item by cpc compare not equal greater
   */
  @Test
  public void testItemByCPCCompareNotEqualGreater() {
    System.out.println("testItemByCPCCompareNotEqualGreater");
    ItemByCPC item = new ItemByCPC(2, "2", "Item");
    ItemByCPC item2 = new ItemByCPC(1, "1", "Item");
    assertTrue(item.compareTo(item2) > 0);
  }

  /*
   * Test item by cpc to String
   */
  @Test
  public void testItemByCPCToString() {
    System.out.println("testItemByCPCToString");
    ItemByCPC item = new ItemByCPC(1, "1", "Item");
    assertEquals("Item{" + "code=" + item.getCode() + ", cpc=" + item.getCpc() + ", item=" + item.getItem() + '}',
        item.toString());
  }

  /*
   * Test item by cpc clone
   */
  @Test
  public void testItemByCPCClone() {
    System.out.println("testItemByCPCClone");
    ItemByCPC item = new ItemByCPC(1, "1", "Item");
    ItemByCPC item2 = (ItemByCPC) item.clone();
    assertEquals(item, item2);
  }
}

package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemByCPCTest {

  /*
   * Test itemByCPC class
   */
  @Test
  public void testItemByCPC() {
    System.out.println("testItemByCPC");
    ItemByCPC item = new ItemByCPC(1, 1, "Portugal");
    assertEquals("Portugal", item.getItem());
    assertEquals(1, item.getCode());
    assertEquals(1, item.getCpc());
  }

  /*
   * Test itemByCPC compare not equal
   */
  @Test
  public void testItemByCPCCompareNotEqualLess() {
    System.out.println("testItemByCPCCompareNotEqualLess");
    ItemByCPC item = new ItemByCPC(1, 1, "Portugal");
    ItemByCPC item2 = new ItemByCPC(2, 2, "Spain");
    assertEquals(-1, item.compareTo(item2));
  }

  /*
   * Test itemByCPC compare equal
   */
  @Test
  public void testItemByCPCCompareEqual() {
    System.out.println("testItemByCPCCompareEqual");
    ItemByCPC item = new ItemByCPC(1, 1, "Portugal");
    ItemByCPC item2 = new ItemByCPC(1, 1, "Portugal");
    assertEquals(0, item.compareTo(item2));
  }

  /*
   * Test itemByCPC compare not equal greater
   */
  @Test
  public void testItemByCPCCompareNotEqualGreater() {
    System.out.println("testItemByCPCCompareNotEqualGreater");
    ItemByCPC item = new ItemByCPC(2, 2, "Spain");
    ItemByCPC item2 = new ItemByCPC(1, 1, "Portugal");
    assertEquals(1, item.compareTo(item2));
  }

  /*
   * Test itemByCPC toString
   */
  @Test
  public void testItemByCPCToString() {
    System.out.println("testItemByCPCToString");
    ItemByCPC item = new ItemByCPC(1, 1, "Portugal");
    assertEquals("Item{code=1, cpc=1, item=Portugal}", item.toString());
  }

}

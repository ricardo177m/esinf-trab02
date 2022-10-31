package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemByCodeTest {

  /*
   * Test itemByCode class
   */
  @Test
  public void testItemByCode() {
    System.out.println("testItemByCode");
    ItemByCode itemByCode = new ItemByCode(1, 1, "item");
    assertEquals("item", itemByCode.getItem());
    assertEquals(1, itemByCode.getCode());
  }

  /*
   * Test itemByCode compare not equal
   */
  @Test
  public void testItemByCodeCompareNotEqualLess() {
    System.out.println("testItemByCodeCompareNotEqualLess");
    ItemByCode itemByCode = new ItemByCode(1, 1, "item");
    ItemByCode itemByCode2 = new ItemByCode(2, 2, "item2");
    assertEquals(-1, itemByCode.compareTo(itemByCode2));
  }

  /*
   * Test itemByCode compare equal
   */
  @Test
  public void testItemByCodeCompareEqual() {
    System.out.println("testItemByCodeCompareEqual");
    ItemByCode itemByCode = new ItemByCode(1, 1, "item");
    ItemByCode itemByCode2 = new ItemByCode(1, 1, "item");
    assertEquals(0, itemByCode.compareTo(itemByCode2));
  }

  /*
   * Test itemByCode compare not equal greater
   */
  @Test
  public void testItemByCodeCompareNotEqualGreater() {
    System.out.println("testItemByCodeCompareNotEqualGreater");
    ItemByCode itemByCode = new ItemByCode(2, 2, "item2");
    ItemByCode itemByCode2 = new ItemByCode(1, 1, "item");
    assertEquals(1, itemByCode.compareTo(itemByCode2));
  }

  /*
   * Test itemByCode toString
   */
  @Test
  public void testItemByCodeToString() {
    System.out.println("testItemByCodeToString");
    ItemByCode itemByCode = new ItemByCode(1, 1, "item");
    assertEquals("Item{" + "code=" + 1 + ", cpc=" + 1 + ", item=" + "item" + '}', itemByCode.toString());
  }

}

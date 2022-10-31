package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemByNameTest {

  /*
   * Test itemByName class
   */
  @Test
  public void testItemByName() {
    System.out.println("testItemByName");
    ItemByName item = new ItemByName(1, 1, "Portugal");
    assertEquals("Portugal", item.getItem());
    assertEquals(1, item.getCode());
    assertEquals(1, item.getCpc());
  }

  /*
   * Test itemByName compare not equal
   */
  @Test
  public void testItemByNameCompareNotEqualLess() {
    System.out.println("testItemByNameCompareNotEqualLess");
    ItemByName item = new ItemByName(1, 1, "Portugal");
    ItemByName item2 = new ItemByName(2, 2, "Spain");
    assertEquals(-1, item.compareTo(item2));
  }

  /*
   * Test itemByName compare equal
   */
  @Test
  public void testItemByNameCompareEqual() {
    System.out.println("testItemByNameCompareEqual");
    ItemByName item = new ItemByName(1, 1, "Portugal");
    ItemByName item2 = new ItemByName(1, 1, "Portugal");
    assertEquals(0, item.compareTo(item2));
  }

  /*
   * Test itemByName compare not equal greater
   */
  @Test
  public void testItemByNameCompareNotEqualGreater() {
    System.out.println("testItemByNameCompareNotEqualGreater");
    ItemByName item = new ItemByName(2, 2, "Spain");
    ItemByName item2 = new ItemByName(1, 1, "Portugal");
    assertEquals(1, item.compareTo(item2));
  }

  /*
   * Test itemByName toString
   */
  @Test
  public void testItemByNameToString() {
    System.out.println("testItemByNameToString");
    ItemByName item = new ItemByName(1, 1, "Portugal");
    assertEquals("Item{" + "code=" + 1 + ", cpc=" + 1 + ", item=" + "Portugal" + '}', item.toString());
  }

}

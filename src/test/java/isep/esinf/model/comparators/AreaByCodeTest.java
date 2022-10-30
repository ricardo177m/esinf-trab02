package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Item;

public class AreaByCodeTest {

  /*
   * Test area by code
   */
  @Test
  public void testAreaByCode() {
    System.out.println("testAreaByCode");
    AreaByCode area = new AreaByCode("Portugal", 1, 1);
    assertEquals("Portugal", area.getArea());
    assertEquals(1, area.getCode());
    assertEquals(1, area.getM49Code());
  }

  /*
   * Test area by code with item
   */
  @Test
  public void testAreaByCodeWithItem() {
    System.out.println("testAreaByCodeWithItem");
    AreaByCode area = new AreaByCode("Portugal", 1, 1);
    Item item = new ItemByCode(1, 1, "Item");
    area.addItem(item);
    assertEquals("Portugal", area.getArea());
    assertEquals(1, area.getCode());
    assertEquals(1, area.getM49Code());
    assertEquals(item, area.getItem(item));
  }

  /*
   * Test area by code compare not equal
   */
  @Test
  public void testAreaByCodeCompareNotEqualLess() {
    System.out.println("testAreaByCodeCompareNotEqualLess");
    AreaByCode area = new AreaByCode("Portugal", 1, 1);
    AreaByCode area2 = new AreaByCode("Portugal", 2, 1);
    assertEquals(-1, area.compareTo(area2));
  }

  /*
   * Test area by code compare equal
   */
  @Test
  public void testAreaByCodeCompareEqual() {
    System.out.println("testAreaByCodeCompareEqual");
    AreaByCode area = new AreaByCode("Portugal", 1, 1);
    AreaByCode area2 = new AreaByCode("Portugal", 1, 1);
    assertEquals(0, area.compareTo(area2));
  }

  @Test
  public void testAreaByCodeCompareNotEqualGreater() {
    System.out.println("testAreaByCodeCompareEqualGreater");
    AreaByCode area = new AreaByCode("Portugal", 2, 1);
    AreaByCode area2 = new AreaByCode("Portugal", 1, 1);
    assertEquals(1, area.compareTo(area2));
  }

}

package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Item;

public class AreaByNameTest {

  /*
   * Test area by name
   */
  @Test
  public void testAreaByName() {
    System.out.println("testAreaByName");
    AreaByName area = new AreaByName("Portugal", 1, 1);
    assertEquals("Portugal", area.getArea());
    assertEquals(1, area.getCode());
    assertEquals(1, area.getM49Code());
  }

  /*
   * Test area by name with item
   */
  @Test
  public void testAreaByNameWithItem() {
    System.out.println("testAreaByNameWithItem");
    AreaByName area = new AreaByName("Portugal", 1, 1);
    Item item = new ItemByName(1, 1, "Item");
    area.addItem(item);
    assertEquals("Portugal", area.getArea());
    assertEquals(1, area.getCode());
    assertEquals(1, area.getM49Code());
    assertEquals(item, area.getItem(item));
  }

  /*
   * Test area by name compare not equal
   */
  @Test
  public void testAreaByNameCompareNotEqualLess() {
    System.out.println("testAreaByNameCompareNotEqualLess");
    AreaByName area = new AreaByName("Portugal", 1, 1);
    AreaByName area2 = new AreaByName("Spain", 2, 3);
    assertEquals(-1, area.compareTo(area2));
  }

  /*
   * Test area by name compare equal
   */
  @Test
  public void testAreaByNameCompareEqual() {
    System.out.println("testAreaByNameCompareEqual");
    AreaByName area = new AreaByName("Portugal", 3, 2);
    AreaByName area2 = new AreaByName("Portugal", 1, 1);
    assertEquals(0, area.compareTo(area2));
  }

  /*
   * Test area by name compare not equal
   */
  @Test
  public void testAreaByNameCompareNotEqualGreater() {
    System.out.println("testAreaByNameCompareNotEqualGreater");
    AreaByName area = new AreaByName("Portugal", 1, 1);
    AreaByName area2 = new AreaByName("Spain", 2, 3);
    assertEquals(1, area2.compareTo(area));
  }

}

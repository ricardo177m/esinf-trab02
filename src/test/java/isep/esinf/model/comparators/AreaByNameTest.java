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
    AreaByName area = new AreaByName(1, 1, "Portugal");
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
    AreaByName area = new AreaByName(1, 1, "Portugal");
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
    AreaByName area = new AreaByName(1, 1, "Portugal");
    AreaByName area2 = new AreaByName(3, 2, "Spain");
    assertEquals(-1, area.compareTo(area2));
  }

  /*
   * Test area by name compare equal
   */
  @Test
  public void testAreaByNameCompareEqual() {
    System.out.println("testAreaByNameCompareEqual");
    AreaByName area = new AreaByName(2, 3, "Portugal");
    AreaByName area2 = new AreaByName(1, 1, "Portugal");
    assertEquals(0, area.compareTo(area2));
  }

  /*
   * Test area by name compare not equal
   */
  @Test
  public void testAreaByNameCompareNotEqualGreater() {
    System.out.println("testAreaByNameCompareNotEqualGreater");
    AreaByName area = new AreaByName(1, 1, "Portugal");
    AreaByName area2 = new AreaByName(3, 2, "Spain");
    assertEquals(1, area2.compareTo(area));
  }

  /*
   * Test area by name toString
   */
  @Test
  public void testAreaByNameToString() {
    System.out.println("testAreaByNameToString");
    AreaByName area = new AreaByName(1, 1, "Portugal");
    assertEquals("Area{" + "name=" + "Portugal" + ", code=" + 1 + ", m49Code=" + 1 + '}', area.toString());
  }
}

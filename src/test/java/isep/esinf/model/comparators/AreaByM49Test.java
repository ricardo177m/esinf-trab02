package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Item;

public class AreaByM49Test {

  /*
   * Test area by m49
   */
  @Test
  public void testAreaByM49() {
    System.out.println("testAreaByM49");
    AreaByM49 area = new AreaByM49(1, "1", "Portugal");
    assertEquals("Portugal", area.getArea());
    assertEquals(1, area.getCode());
    assertEquals("1", area.getM49Code());
  }

  /*
   * Test area by m49 with item
   */
  @Test
  public void testAreaByM49WithItem() {
    System.out.println("testAreaByM49WithItem");
    AreaByM49 area = new AreaByM49(1, "1", "Portugal");
    Item item = new ItemByCode(1, "1", "Item");
    area.addItem(item);
    assertEquals("Portugal", area.getArea());
    assertEquals(1, area.getCode());
    assertEquals("1", area.getM49Code());
    assertEquals(item, area.getItem(item));
  }

  /*
   * Test area by m49 compare not equal
   */
  @Test
  public void testAreaByM49CompareNotEqualLess() {
    System.out.println("testAreaByM49CompareNotEqualLess");
    AreaByM49 area = new AreaByM49(1, "1", "Portugal");
    AreaByM49 area2 = new AreaByM49(2, "2", "Portugal");
    assertTrue(area.compareTo(area2) < 0);
  }

  /*
   * Test area by m49 compare equal
   */
  @Test
  public void testAreaByM49CompareEqual() {
    System.out.println("testAreaByM49CompareEqual");
    AreaByM49 area = new AreaByM49(1, "1", "Portugal");
    AreaByM49 area2 = new AreaByM49(1, "1", "Portugal");
    assertEquals(0, area.compareTo(area2));
  }

  /*
   * Test area by m49 compare not equal greater
   */
  @Test
  public void testAreaByM49CompareNotEqualGreater() {
    System.out.println("testAreaByM49CompareNotEqualGreater");
    AreaByM49 area = new AreaByM49(2, "3", "Portugal");
    AreaByM49 area2 = new AreaByM49(1, "1", "Portugal");
    assertTrue(area.compareTo(area2) > 0);
  }

  /*
   * Test area by m49 toString
   */
  @Test
  public void testAreaByM49ToString() {
    System.out.println("testAreaByM49ToString");
    AreaByM49 area = new AreaByM49(1, "1", "Portugal");
    assertEquals("Area{" + "name=" + "Portugal" + ", code=" + 1 + ", m49Code=" + 1 + '}', area.toString());
  }

  /*
   * Test area by m49 clone
   */
  @Test
  public void testAreaByM49Clone() {
    System.out.println("testAreaByM49Clone");
    AreaByM49 area = new AreaByM49(1, "1", "Portugal");
    AreaByM49 area2 = (AreaByM49) area.clone();
    assertEquals(area, area2);
  }

}

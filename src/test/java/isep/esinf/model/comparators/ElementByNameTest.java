package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ElementByNameTest {

  /*
   * Test element by name
   */
  @Test
  public void testElementByName() {
    System.out.println("testElementByName");
    ElementByName element = new ElementByName(1, "Portugal");
    assertEquals("Portugal", element.getElement());
    assertEquals(1, element.getCode());
  }

  /*
   * Test element by name compare not equal
   */
  @Test
  public void testElementByNameCompareNotEqualLess() {
    System.out.println("testElementByNameCompareNotEqualLess");
    ElementByName element = new ElementByName(1, "Portugal");
    ElementByName element2 = new ElementByName(2, "Spain");
    assertEquals(-1, element.compareTo(element2));
  }

  /*
   * Test element by name compare equal
   */
  @Test
  public void testElementByNameCompareEqual() {
    System.out.println("testElementByNameCompareEqual");
    ElementByName element = new ElementByName(1, "Portugal");
    ElementByName element2 = new ElementByName(1, "Portugal");
    assertEquals(0, element.compareTo(element2));
  }

  /*
   * Test element by name compare not equal greater
   */
  @Test
  public void testElementByNameCompareNotEqualGreater() {
    System.out.println("testElementByNameCompareNotEqualGreater");
    ElementByName element = new ElementByName(2, "Spain");
    ElementByName element2 = new ElementByName(1, "Portugal");
    assertEquals(1, element.compareTo(element2));
  }

  /*
   * Test element by name toString
   */
  @Test
  public void testElementByNameToString() {
    System.out.println("testElementByNameToString");
    ElementByName element = new ElementByName(1, "Portugal");
    assertEquals("Element{" + "code=" + 1 + ", element=" + "Portugal" + '}', element.toString());
  }

}

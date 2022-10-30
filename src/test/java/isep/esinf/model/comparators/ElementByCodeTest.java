package isep.esinf.model.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ElementByCodeTest {

  /*
   * Test element by code
   */
  @Test
  public void testElementByCode() {
    System.out.println("testElementByCode");
    ElementByCode element = new ElementByCode(1, "Portugal");
    assertEquals("Portugal", element.getElement());
    assertEquals(1, element.getCode());
  }

  /*
   * Test element by code compare not equal
   */
  @Test
  public void testElementByCodeCompareNotEqualLess() {
    System.out.println("testElementByCodeCompareNotEqualLess");
    ElementByCode element = new ElementByCode(1, "Portugal");
    ElementByCode element2 = new ElementByCode(2, "Portugal");
    assertEquals(-1, element.compareTo(element2));
  }

  /*
   * Test element by code compare equal
   */
  @Test
  public void testElementByCodeCompareEqual() {
    System.out.println("testElementByCodeCompareEqual");
    ElementByCode element = new ElementByCode(1, "Portugal");
    ElementByCode element2 = new ElementByCode(1, "Portugal");
    assertEquals(0, element.compareTo(element2));
  }

  /*
   * Test element by code compare not equal greater
   */
  @Test
  public void testElementByCodeCompareNotEqualGreater() {
    System.out.println("testElementByCodeCompareNotEqualGreater");
    ElementByCode element = new ElementByCode(2, "Portugal");
    ElementByCode element2 = new ElementByCode(1, "Portugal");
    assertEquals(1, element.compareTo(element2));
  }

  /*
   * Test element by code toString
   */
  @Test
  public void testElementByCodeToString() {
    System.out.println("testElementByCodeToString");
    ElementByCode element = new ElementByCode(1, "Portugal");
    assertEquals("Element{" + "code=" + 1 + ", element=" + "Portugal" + '}', element.toString());
  }
}

package isep.esinf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import isep.esinf.model.comparators.ElementByCode;

public class ElementTest {
  private static Element e;

  @Test
  public void testvalueSumTimeInterval() {
    System.out.println("testvalueSumTimeInterval");
    e = new ElementByCode(0, "element");
    e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2003, new Value(200, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2005, new Value(300, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2007, new Value(250, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2009, new Value(100, "unit", "flag", "flagDescription")));

    assertEquals((float) (200 + 300 + 250), e.valueSumTimeInterval(2001, 2007));
  }

  @Test
  public void testvalueSumTimeIntervalWithNullElement() {
    System.out.println("testvalueSumTimeIntervalWithNullElement");
    e = new ElementByCode(0, "element");
    assertEquals(0, e.valueSumTimeInterval(2001, 2007));
  }

  @Test
  public void testvalueSumTimeIntervalWhitoutData() {
    System.out.println("testvalueSumTimeIntervalWhitoutData");
    e = new ElementByCode(0, "element");
    e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));

    assertEquals(0, e.valueSumTimeInterval(2001, 2007));
  }

  @Test
  public void testvalueSumTimeIntervalWithNullData() {
    System.out.println("testvalueSumTimeIntervalWithNullData");
    e = new ElementByCode(0, "element");
    e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2003, new Value(200, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2005, new Value(300, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2007, new Value(250, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2009, new Value(100, "unit", "flag", "flagDescription")));

    assertEquals(0, e.valueSumTimeInterval(2010, 2015));
  }

  @Test
  public void testvalueSumTimeIntervalWithNullDataAndNullElement() {
    System.out.println("testvalueSumTimeIntervalWithNullDataAndNullElement");
    e = new ElementByCode(0, "element");
    assertEquals(0, e.valueSumTimeInterval(2010, 2015));
  }

  @Test
  public void testvalueSumTimeIntervalWithNullDataAndNullElementAndNullInterval() {
    System.out.println("testvalueSumTimeIntervalWithNullDataAndNullElementAndNullInterval");
    e = new ElementByCode(0, "element");
    assertEquals(0, e.valueSumTimeInterval(0, 0));
  }

  @Test
  public void testElementClassClone() {
    System.out.println("testElementClassClone");
    e = new ElementByCode(0, "element");
    e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2003, new Value(200, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2005, new Value(300, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2007, new Value(250, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2009, new Value(100, "unit", "flag", "flagDescription")));

    Element e2 = e.clone();

    assertEquals(e, e2);
  }

  @Test
  public void testElementClassCloneWithNullElement() {
    System.out.println("testElementClassCloneWithNullElement");
    e = new ElementByCode(0, "element");
    Element e2 = e.clone();

    assertEquals(e, e2);
  }

  @Test
  public void testElementEquals() {
    System.out.println("testElementEquals");
    e = new ElementByCode(0, "element");
    e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
    e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));

    Element e2 = new ElementByCode(0, "element");
    e2.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
    e2.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));

    assertEquals(e, e2);
  }

  @Test
  public void testElementEqualsWithNullElement() {
    System.out.println("testElementEqualsWithNullElement");
    e = new ElementByCode(0, "element");
    Element e2 = new ElementByCode(0, "element");

    assertEquals(e, e2);
  }

  @Test
  public void testElementEqualsNullObj() {
    System.out.println("testElementEqualsNullObj");
    e = new ElementByCode(0, "element");
    Element e2 = null;

    assertEquals(false, e.equals(e2));
  }

  @Test
  public void testElementEqualsWithDifferentCode() {
    System.out.println("testElementEqualsWithDifferentCode");
    e = new ElementByCode(0, "element");
    Element e2 = new ElementByCode(1, "element");

    assertEquals(false, e.equals(e2));
  }

  @Test
  public void testElementEqualsWithDifferentName() {
    System.out.println("testElementEqualsWithDifferentName");
    e = new ElementByCode(0, "element");
    Element e2 = new ElementByCode(0, "element2");

    assertEquals(false, e.equals(e2));
  }

  @Test
  public void testElementEqualsWithElementNull() {
    System.out.println("testElementEqualsWithElementNull");
    e = new ElementByCode(0, null);
    Element e2 = new ElementByCode(0, "element");

    assertEquals(false, e.equals(e2));
  }

}

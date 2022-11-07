package isep.esinf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValueTest {

  /*
   * Test valueClass
   */
  @Test
  public void testValueClass() {
    System.out.println("testValueClass");
    Value v = new Value(100, "unit", "flag", "flagDescription");
    assertEquals(100, v.getValue());
    assertEquals("unit", v.getUnit());
    assertEquals("flag", v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullValue
   */
  @Test
  public void testValueClassWithNullValue() {
    System.out.println("testValueClassWithNullValue");

    Value v = new Value(0, "unit", "flag", "flagDescription");
    assertEquals(0, v.getValue());
    assertEquals("unit", v.getUnit());
    assertEquals("flag", v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullUnit
   */
  @Test
  public void testValueClassWithNullUnit() {
    System.out.println("testValueClassWithNullUnit");

    Value v = new Value(100, null, "flag", "flagDescription");
    assertEquals(100, v.getValue());
    assertEquals(null, v.getUnit());
    assertEquals("flag", v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullFlag
   */
  @Test
  public void testValueClassWithNullFlag() {
    System.out.println("testValueClassWithNullFlag");

    Value v = new Value(100, "unit", null, "flagDescription");
    assertEquals(100, v.getValue());
    assertEquals("unit", v.getUnit());
    assertEquals(null, v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullFlagDescription
   */
  @Test
  public void testValueClassWithNullFlagDescription() {
    System.out.println("testValueClassWithNullFlagDescription");

    Value v = new Value(100, "unit", "flag", null);
    assertEquals(100, v.getValue());
    assertEquals("unit", v.getUnit());
    assertEquals("flag", v.getFlag());
    assertEquals(null, v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullValueAndNullUnit
   */
  @Test
  public void testValueClassWithNullValueAndNullUnit() {
    System.out.println("testValueClassWithNullValueAndNullUnit");

    Value v = new Value(0, null, "flag", "flagDescription");
    assertEquals(0, v.getValue());
    assertEquals(null, v.getUnit());
    assertEquals("flag", v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullValueAndNullFlag
   */
  @Test
  public void testValueClassWithNullValueAndNullFlag() {
    System.out.println("testValueClassWithNullValueAndNullFlag");

    Value v = new Value(0, "unit", null, "flagDescription");
    assertEquals(0, v.getValue());
    assertEquals("unit", v.getUnit());
    assertEquals(null, v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullValueAndNullFlagDescription
   */
  @Test
  public void testValueClassWithNullValueAndNullFlagDescription() {
    System.out.println("testValueClassWithNullValueAndNullFlagDescription");

    Value v = new Value(0, "unit", "flag", null);
    assertEquals(0, v.getValue());
    assertEquals("unit", v.getUnit());
    assertEquals("flag", v.getFlag());
    assertEquals(null, v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullUnitAndNullFlag
   */
  @Test
  public void testValueClassWithNullUnitAndNullFlag() {
    System.out.println("testValueClassWithNullUnitAndNullFlag");

    Value v = new Value(100, null, null, "flagDescription");
    assertEquals(100, v.getValue());
    assertEquals(null, v.getUnit());
    assertEquals(null, v.getFlag());
    assertEquals("flagDescription", v.getFlagDescription());
  }

  /*
   * Test valueClassWithNullUnitAndNullFlagDescription
   */
  @Test
  public void testValueClassWithNulls() {
    System.out.println("testValueClassWithNulls");

    Value v = new Value(0, null, null, null);
    assertEquals(0, v.getValue());
    assertEquals(null, v.getUnit());
    assertEquals(null, v.getFlag());
    assertEquals(null, v.getFlagDescription());
  }

  /*
   * Test value class setFlagDescription
   */
  @Test
  public void testValueClassSetFlagDescription() {
    System.out.println("testValueClassSetFlagDescription");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    v.setFlagDescription("newFlagDescription");
    assertEquals("newFlagDescription", v.getFlagDescription());
  }

  /*
   * Test value class clone
   */
  @Test
  public void testValueClassClone() {
    System.out.println("testValueClassClone");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = v.clone();
    assertEquals(100, v2.getValue());
    assertEquals("unit", v2.getUnit());
    assertEquals("flag", v2.getFlag());
    assertEquals("flagDescription", v2.getFlagDescription());
  }

  /*
   * Test value class equals
   */
  @Test
  public void testValueClassEquals() {
    System.out.println("testValueClassEquals");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = new Value(100, "unit", "flag", "flagDescription");
    assertEquals(true, v.equals(v2));
  }

  /*
   * Test value class equals with null
   */
  @Test
  public void testValueClassEqualsWithNull() {
    System.out.println("testValueClassEqualsWithNull");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    assertEquals(false, v.equals(null));
  }

  /*
   * Test value class equals with different value
   */
  @Test
  public void testValueClassEqualsWithDifferentValue() {
    System.out.println("testValueClassEqualsWithDifferentValue");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = new Value(200, "unit", "flag", "flagDescription");
    assertEquals(false, v.equals(v2));
  }

  /*
   * Test value class equals with different unit
   */
  @Test
  public void testValueClassEqualsWithDifferentUnit() {
    System.out.println("testValueClassEqualsWithDifferentUnit");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = new Value(100, "unit2", "flag", "flagDescription");
    assertEquals(false, v.equals(v2));
  }

  /*
   * Test value class equals with different flag
   */
  @Test
  public void testValueClassEqualsWithDifferentFlag() {
    System.out.println("testValueClassEqualsWithDifferentFlag");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = new Value(100, "unit", "flag2", "flagDescription");
    assertEquals(false, v.equals(v2));
  }

  /*
   * Test value class equals with different flag description
   */
  @Test
  public void testValueClassEqualsWithDifferentFlagDescription() {
    System.out.println("testValueClassEqualsWithDifferentFlagDescription");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = new Value(100, "unit", "flag", "flagDescription2");
    assertEquals(false, v.equals(v2));
  }

  /*
   * Test value class equals with
   * different value, unit, flag, and flag description
   */
  @Test
  public void testValueClassEqualsWithDifferentValueUnitFlagAndFlagDescription() {
    System.out.println("testValueClassEqualsWithDifferentValueUnitFlagAndFlagDescription");

    Value v = new Value(100, "unit", "flag", "flagDescription");
    Value v2 = new Value(200, "unit2", "flag2", "flagDescription2");
    assertEquals(false, v.equals(v2));
  }

}

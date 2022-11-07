package isep.esinf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import isep.esinf.model.comparators.AreaByCode;

public class ProductionDataTest {

  /*
   * Test productionDataClass
   */
  @Test
  public void testProductionDataClass() {
    System.out.println("testProductionDataClass");
    ProductionData pd = new ProductionData(2010, new Value(100, "unit", "flag", "flagDescription"));
    assertEquals(2010, pd.getYear());
    assertEquals(100, pd.getValue());
    assertEquals("unit", pd.getUnit());
    assertEquals("flag", pd.getFlag());
    assertEquals("flagDescription", pd.getFlagDescription());
  }

  /*
   * Test productionDataClass with null value
   */
  @Test
  public void testProductionDataClassWithNullValue() {
    System.out.println("testProductionDataClassWithNullValue");
    Value value = null;
    ProductionData pd = new ProductionData(2010, value);
    assertEquals(2010, pd.getYear());
    assertNull(value);
  }

  /*
   * Test productionDataClass with null unit
   */
  @Test
  public void testProductionDataClassWithNullUnit() {
    System.out.println("testProductionDataClassWithNullUnit");
    ProductionData pd = new ProductionData(2010, new Value(100, null, "flag", "flagDescription"));
    assertEquals(2010, pd.getYear());
    assertEquals(100, pd.getValue());
    assertEquals(null, pd.getUnit());
    assertEquals("flag", pd.getFlag());
    assertEquals("flagDescription", pd.getFlagDescription());
  }

  /*
   * Test productionDataClass with null flag
   */
  @Test
  public void testProductionDataClassWithNullFlag() {
    System.out.println("testProductionDataClassWithNullFlag");
    ProductionData pd = new ProductionData(2010, new Value(100, "unit", null, "flagDescription"));
    assertEquals(2010, pd.getYear());
    assertEquals(100, pd.getValue());
    assertEquals("unit", pd.getUnit());
    assertEquals(null, pd.getFlag());
    assertEquals("flagDescription", pd.getFlagDescription());
  }

  /*
   * Test productionDataClass with null flagDescription
   */
  @Test
  public void testProductionDataClassWithNullFlagDescription() {
    System.out.println("testProductionDataClassWithNullFlagDescription");
    ProductionData pd = new ProductionData(2010, new Value(100, "unit", "flag", null));
    assertEquals(2010, pd.getYear());
    assertEquals(100, pd.getValue());
    assertEquals("unit", pd.getUnit());
    assertEquals("flag", pd.getFlag());
    assertEquals(null, pd.getFlagDescription());
  }

  /*
   * Test productionDataClass with null year
   */
  @Test
  public void testProductionDataClassWithNullYear() {
    System.out.println("testProductionDataClassWithNullYear");
    ProductionData pd = new ProductionData(0, new Value(100, "unit", "flag", "flagDescription"));
    assertEquals(0, pd.getYear());
    assertEquals(100, pd.getValue());
    assertEquals("unit", pd.getUnit());
    assertEquals("flag", pd.getFlag());
    assertEquals("flagDescription", pd.getFlagDescription());
  }

  /*
   * Test productionDataClass with null year and null unit
   */
  @Test
  public void testProductionDataClassWithNullYearAndNullUnit() {
    System.out.println("testProductionDataClassWithNullYearAndNullUnit");
    ProductionData pd = new ProductionData(0, new Value(100, null, "flag", "flagDescription"));
    assertEquals(0, pd.getYear());
    assertEquals(100, pd.getValue());
    assertEquals(null, pd.getUnit());
    assertEquals("flag", pd.getFlag());
    assertEquals("flagDescription", pd.getFlagDescription());
  }

  /*
   * Test productionDataClass toString
   */
  @Test
  public void testProductionDataClassToString() {
    System.out.println("testProductionDataClassToString");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    assertEquals("ProductionData{" + "year=" + 2010 + ", value=" + value + '}', pd.toString());
  }

  /*
   * Test productionDataClass clone
   */
  @Test
  public void testProductionDataClassClone() {
    System.out.println("testProductionDataClassClone");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    ProductionData pdClone = pd.clone();
    assertEquals(pd, pdClone);
  }

  /*
   * Test productionDataClass equals
   */
  @Test
  public void testProductionDataClassEquals() {
    System.out.println("testProductionDataClassEquals");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    ProductionData pdClone = pd.clone();
    assertEquals(true, pd.equals(pdClone));
  }

  /*
   * Test productionDataClass equals with diff year
   */
  @Test
  public void testProductionDataClassNotEquals() {
    System.out.println("testProductionDataClassNotEquals");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    ProductionData pdClone = new ProductionData(2011, value);
    assertEquals(false, pd.equals(pdClone));
  }

  /*
   * Test productionDataClass equals with null
   */
  @Test
  public void testProductionDataClassEqualsWithNull() {
    System.out.println("testProductionDataClassEqualsWithNull");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    assertEquals(false, pd.equals(null));
  }

  /*
   * Test productionDataClass equals with diff class
   */
  @Test
  public void testProductionDataClassEqualsWithDiffClass() {
    System.out.println("testProductionDataClassEqualsWithDiffClass");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    assertEquals(false, pd.equals(new AreaByCode(0, null, null)));
  }

  /*
   * Test productionDataClass equals with diff value
   */
  @Test
  public void testProductionDataClassEqualsWithDiffValue() {
    System.out.println("testProductionDataClassEqualsWithDiffValue");
    Value value = new Value(100, "unit", "flag", "flagDescription");
    ProductionData pd = new ProductionData(2010, value);
    Value value2 = new Value(200, "unit", "flag", "flagDescription");
    ProductionData pd2 = new ProductionData(2010, value2);
    assertEquals(false, pd.equals(pd2));
  }

}

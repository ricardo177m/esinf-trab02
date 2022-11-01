package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.mock.MockGeoData;
import isep.esinf.model.Container;

public class AccumulatedProductionInAreaTest {
  AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();

  public static Container container;
  private static List<Map<String, String>> geoData;

  @BeforeAll
  public static void setup() {
    MockContainer mockContainer = new MockContainer();
    container = mockContainer.mockByCode();
    geoData = (new MockGeoData()).mock();
  }

  /*
   * Test if the sum of the production of an item in a list of areas is correct
   */
  @Test
  public void testAccumulatedProductionInArea() {
    System.out.println("testAccumulatedProductionInArea");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(200, sum);
  }

  /*
   * Test if the sum of production is zero when coordinates are out of the areas
   */
  @Test
  public void testSumProductionNullWhenCoordsOutOfRange() {
    System.out.println("testSumProductionNullWhenCoordsOutOfRange");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, -50.0, -50.0, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is zero when the item code is not in the
   * container
   */
  @Test
  public void testSumProductionZeroWhenItemCodeNotInContainer() {
    System.out.println("testSumProductionZeroWhenItemCodeNotInContainer");

    int itemCode = 100;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is zero when the element code is not in the
   * container
   */
  @Test
  public void testSumProductionZeroWhenElementCodeNotInContainer() {
    System.out.println("testSumProductionZeroWhenElementCodeNotInContainer");

    int itemCode = 8;
    int elementCode = 100;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is zero when the year is not in the container
   */
  @Test
  public void testSumProductionZeroWhenYearNotInContainer() {
    System.out.println("testSumProductionZeroWhenYearNotInContainer");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1000,
        container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is zero when the year is in the container but
   * the it do not corresponds to the item code
   */
  @Test
  public void testSumProductionZeroWhenYearNotInItemCode() {
    System.out.println("testSumProductionZeroWhenYearNotInItemCode");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1981,
        container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is zero when the container is empty
   */
  @Test
  public void testSumProductionZeroWhenContainerIsEmpty() {
    System.out.println("testSumProductionZeroWhenContainerIsEmpty");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        new Container(), geoData);

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is zero when the geoData is empty
   */
  @Test
  public void testSumProductionZeroWhenGeoDataIsEmpty() {
    System.out.println("testSumProductionZeroWhenGeoDataIsEmpty");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, List.of());

    assertEquals(0, sum);
  }

  /*
   * Test if the sum of production is null when the geoData is null
   */
  @Test
  public void testSumProductionNullWhenGeoDataIsNull() {
    System.out.println("testSumProductionNullWhenGeoDataIsNull");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, null);

    assertEquals(null, sum);
  }

  /*
   * Test if the sum of production is zero when the container is null
   */
  @Test
  public void testSumProductionZeroWhenContainerIsNull() {
    System.out.println("testSumProductionNullWhenContainerIsNull");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980, null,
        geoData);

    assertEquals(null, sum);
  }

}

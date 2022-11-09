package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.mock.MockGeoData;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.shared.Constants;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.PropertiesUtils;

public class AccumulatedProductionInAreaTest {
  private AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();

  Properties props = PropertiesUtils.getProperties();
  private final String BASE_PATH = props.getProperty(Constants.PARAMS_DATA_FOLDER_PATH);

  private static Container container;
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

    assertEquals(0, sum);
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
   * it do not
   * corresponds to item code
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

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980, container, null);

    assertEquals(-1, sum);
  }

  /*
   * Test if the sum of production is zero when the container is null
   */
  @Test
  public void testSumProductionZeroWhenContainerIsNull() {
    System.out.println("testSumProductionNullWhenContainerIsNull");

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980, null, geoData);

    assertEquals(-1, sum);
  }

  /*
   * Test sum production with multiple values
   */
  @Test
  public void testSumProductionWithMultipleValues() {
    System.out.println("testSumProductionWithMultipleValues");

    int itemCode = 1;
    int elementCode = 1;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(600, sum);
  }

  /*
   * Test the sum of production with the same x axis coords
   */
  @Test
  public void testSumProductionSameXAxis() {
    System.out.println("testSumProductionSameXAxis");

    int itemCode = 8;
    int elementCode = 1;

    Double sum = aInArea.execute(-3.373056, -3.373056, 200, 200, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(400, sum);
  }

  /*
   * Test sum production with multiple values
   */
  @Test
  public void testSumProductionWithMultipleValues2() {
    System.out.println("testSumProductionWithMultipleValues2");

    int itemCode = 9;
    int elementCode = 6;

    Double sum = aInArea.execute(-100.0, -100.0, 200.0, 200.0, itemCode, elementCode, 1987,
        container, geoData);

    assertEquals(1800, sum);
  }

  /*
   * Test sum production with coords that are in the container but do not match
   * any area
   */
  @Test
  public void testSumProductionWithCoordsNotInArea() {
    System.out.println("testSumProductionWithCoordsNotInArea");

    int itemCode = 9;
    int elementCode = 6;

    Double sum = aInArea.execute(50, 50, 60, 60, itemCode, elementCode, 1980, container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test sum production with coords that are in the container (making it a point)
   */
  @Test
  public void testSumProductionWithCoordsPoint() {
    System.out.println("testSumProductionWithCoordsPoint");

    int itemCode = 9;
    int elementCode = 6;

    Double sum = aInArea.execute(0, 0, 0, 0, itemCode, elementCode, 1980, container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test the sum of production with the same Y axis coords
   */
  @Test
  public void testSumProductionSameYAxis() {
    System.out.println("testSumProductionSameYAxis");

    int itemCode = 8;
    int elementCode = 1;

    Double sum = aInArea.execute(-3.373056, 177.64933, 1, 177.64933, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(200, sum);
  }

  /*
   * Test the sum of production with x2,y2 coords smaller than x1,y1
   */
  @Test
  public void testSumProductionWithCoordsX2Y2SmallerThanX1Y1() {
    System.out.println("testSumProductionWithCoordsX2Y2SmallerThanX1Y1");

    int itemCode = 9;
    int elementCode = 6;

    Double sum = aInArea.execute(200, 200, -100, -100, itemCode, elementCode, 1987, container, geoData);

    assertEquals(1800, sum);
  }

  /*
   * Test the sum of production with all areas in the container
   */
  @Test
  public void testSumProductionWithAllAreasInContainer() {
    System.out.println("testSumProductionWithAllAreasInContainer");

    int itemCode = 1;
    int elementCode = 1;

    Double sum = aInArea.execute(-1000, -1000, 1000, 1000, itemCode, elementCode, 1980, container, geoData);

    assertEquals(800, sum);
  }

  /*
   * Test the sum of production with data from file
   */
  @Test
  public void testSumProductionWithFileSmall() throws FileNotFoundException {
    System.out.println("testSumProductionWithFileSmall");

    CSVReader r = new CSVReader(BASE_PATH + "/Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv");

    List<Map<String, String>> containerData = r.read();

    LoadData ld = new LoadData();
    Container container = ld.execute(containerData, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    r = new CSVReader(BASE_PATH + "/Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv");

    List<Map<String, String>> geoData = r.read();

    int itemCode = 689;
    int elementCode = 5419;

    Double sum = aInArea.execute(-1000, -1000, 1000, 1000, itemCode, elementCode, 2009, container, geoData);

    assertEquals(29820.0, sum);
  }

  /*
   * Test the sum of production with data from file
   */
  @Test
  public void testSumProductionWithFileSmallDifferentArea() throws FileNotFoundException {
    System.out.println("testSumProductionWithFileSmallDifferentArea");

    CSVReader r = new CSVReader(BASE_PATH + "/Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv");

    List<Map<String, String>> containerData = r.read();

    LoadData ld = new LoadData();
    Container container = ld.execute(containerData, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    r = new CSVReader(BASE_PATH + "/Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv");

    List<Map<String, String>> geoData = r.read();

    int itemCode = 1062;
    int elementCode = 5313;

    Double sum = aInArea.execute(-1000, -1000, 1000, 1000, itemCode, elementCode, 1977, container, geoData);

    assertEquals(53000.0, sum);
  }

  /*
   * Test the sum of production with data from file but with coords out of range
   */
  @Test
  public void testSumProductionWithFileSmallCoordsOutOfRange() throws FileNotFoundException {
    System.out.println("testSumProductionWithFileSmallCoordsOutOfRange");

    CSVReader r = new CSVReader(BASE_PATH + Constants.DATAFILE_FR_GER_IT_PT_SP_SMALL);

    List<Map<String, String>> containerData = r.read();

    LoadData ld = new LoadData();
    Container container = ld.execute(containerData, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    r = new CSVReader(BASE_PATH + Constants.DATAFILE_AREA_COORDINATES);

    List<Map<String, String>> geoData = r.read();

    int itemCode = 1062;
    int elementCode = 5313;

    Double sum = aInArea.execute(-1, -1, 1, 1, itemCode, elementCode, 1977, container, geoData);

    assertEquals(0, sum);
  }

  /*
   * Test the sum of production with data from file but year out of range
   */
  @Test
  public void testSumProductionWithFileSmallYearOutOfRange() throws FileNotFoundException {
    System.out.println("testSumProductionWithFileSmallYearOutOfRange");

    CSVReader r = new CSVReader(BASE_PATH + Constants.DATAFILE_FR_GER_IT_PT_SP_SMALL);

    List<Map<String, String>> containerData = r.read();

    LoadData ld = new LoadData();
    Container container = ld.execute(containerData, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    r = new CSVReader(BASE_PATH + Constants.DATAFILE_AREA_COORDINATES);

    List<Map<String, String>> geoData = r.read();

    int itemCode = 1062;
    int elementCode = 5313;

    Double sum = aInArea.execute(-1000, -1000, 1000, 1000, itemCode, elementCode, 123, container, geoData);

    assertEquals(0, sum);
  }
}

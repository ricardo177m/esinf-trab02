package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.TwoDTree;

public class LoadGeographicalDataTest {
  LoadGeographicalData loadGeographicalData = new LoadGeographicalData();

  @Test
  public void testLoadGeographicalData() {
    Container c = new Container();
    TwoDTree<Area> tree = new TwoDTree<>();
    Area portugal = new AreaByName(13, "100", "Portugal");
    Area spain = new AreaByName(14, "50", "Spain");
    Area italy = new AreaByName(11, "90", "Italy");

    c.addArea(portugal);
    c.addArea(spain);
    c.addArea(italy);

    List<Map<String, String>> geoData = new ArrayList<>();
    geoData.add(Map.of("area", "Portugal", "latitude", "39.3999", "longitude",
        "-8.2245"));
    geoData.add(Map.of("area", "Spain", "latitude", "40.4637", "longitude",
        "-3.7492"));
    geoData.add(Map.of("area", "Italy", "latitude", "41.8719", "longitude",
        "12.5674"));

    tree.insert(italy, 41.8719, 12.5674);
    tree.insert(portugal, 39.3999, -8.2245);
    tree.insert(spain, 40.4637, -3.7492);

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    assertEquals(result.toString(), tree.toString());
  }

  /*
   * Test loadGeographicalData with emptyData (geoData is empty)
   */
  @Test
  public void testLoadGeographicalDataEmptyDataListEmpty() {
    System.out.println("testLoadGeographicalDataEmptyDataListEmpty");
    Container c = new Container();

    Area portugal = new AreaByName(13, "100", "Portugal");
    Area spain = new AreaByName(14, "50", "Spain");
    Area italy = new AreaByName(11, "90", "Italy");

    c.addArea(portugal);
    c.addArea(spain);
    c.addArea(italy);

    List<Map<String, String>> geoData = new ArrayList<>();

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    assertEquals("", result.toString());

  }

  /*
   * Test loadGeographicalData with emptyData (container is empty)
   */
  @Test
  public void testLoadGeographicalDataEmptyDataWithContainerEmpty() {
    System.out.println("testLoadGeographicalDataEmptyDataWithContainerEmpty");
    Container c = new Container();

    List<Map<String, String>> geoData = new ArrayList<>();
    geoData.add(Map.of("area", "Portugal", "latitude", "39.3999", "longitude",
        "-8.2245"));
    geoData.add(Map.of("area", "Spain", "latitude", "40.4637", "longitude", "123"));

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    assertEquals("", result.toString());

  }

  // test loadGeographicalData with not available data /data/EmptyFile.csv
  @Test
  public void testLoadGeographicalDataWithNotAvailableData() throws FileNotFoundException {
    System.out.println("testLoadGeographicalDataWithNotAvailableData");
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/EmptyFile.csv");

    Container c = new Container();
    Area portugal = new AreaByName(13, "100", "Portugal");
    Area italy = new AreaByName(11, "90", "Italy");
    Area spain = new AreaByName(14, "50", "Spain");

    c.addArea(portugal);
    c.addArea(spain);
    c.addArea(italy);

    List<Map<String, String>> geoData = r.read();

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    assertEquals("", result.toString());

  }

  // test loadGeographicalData with file TestLoadGeoData_Small.csv
  @Test
  public void testLoadGeographicalDataWithSmallFile() throws FileNotFoundException {
    System.out.println("testLoadGeographicalDataWithSmallFile");
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/TestLoadGeoData_Small.csv");

    Container c = new Container();
    TwoDTree<Area> tree = new TwoDTree<>();

    Area burundi = new AreaByName(13, "100", "Burundi");
    Area israel = new AreaByName(14, "101", "Israel");
    Area tuvalu = new AreaByName(0, "102", "Tuvalu");
    Area mozambique = new AreaByName(13, "103", "Mozambique");
    Area faroeIslands = new AreaByName(14, "104", "Faroe Islands");
    Area pitcairnIslands = new AreaByName(0, "105", "Pitcairn Islands");
    Area niue = new AreaByName(13, "106", "Niue");
    Area eswatini = new AreaByName(14, "107", "Eswatini");

    c.addArea(burundi);
    c.addArea(israel);
    c.addArea(tuvalu);
    c.addArea(mozambique);
    c.addArea(faroeIslands);
    c.addArea(pitcairnIslands);
    c.addArea(niue);
    c.addArea(eswatini);

    List<Map<String, String>> geoData = r.read();

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    tree.insert(burundi, -3.3731, 29.9189);
    tree.insert(faroeIslands, 61.892635, -6.911806);
    tree.insert(israel, 31.046051, 34.851612);
    tree.insert(eswatini, -26.522503, 31.465866);
    tree.insert(niue, -19.054445, -169.867233);
    tree.insert(mozambique, -18.665695, 35.529562);
    tree.insert(pitcairnIslands, -24.703615, -127.439308);

    assertEquals(result.toString(), tree.toString());

  }

  /*
   * Test loadGeographicalData with file TestLoadGeoData_Small.csv crossing data
   * with mock container
   */
  @Test
  public void testLoadGeographicalDataWithMockContainer() throws FileNotFoundException {
    System.out.println("testLoadGeographicalDataWithMockContainer");
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/TestLoadGeoData_Small.csv");

    MockContainer c = new MockContainer();
    Container container = c.mockByCode();
    TwoDTree<Area> tree = new TwoDTree<>();

    List<Map<String, String>> geoData = r.read();

    TwoDTree<Area> result = loadGeographicalData.execute(container, geoData);

    tree.insert(new AreaByCode(400, "500", "Burundi"), -3.3731, 29.9189);

    assertEquals(result.toString(), tree.toString());

  }

  /*
   * Test loadGeographicalData with files
   */
  @Test
  public void testLoadGeographicalDataWithFilesTreeSize() throws FileNotFoundException {
    System.out.println("testLoadGeographicalDataWithFilesTreeSize");
    CSVReader r = new CSVReader(
        "/home/drew/Downloads/Production_Crops_Livestock/Production_Crops_Livestock/Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv");

    List<Map<String, String>> containerData = r.read();

    Container container = LoadData.execute(containerData, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    r = new CSVReader(
        "/home/drew/Downloads/Production_Crops_Livestock/Production_Crops_Livestock/Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv");

    List<Map<String, String>> geoData = r.read();

    TwoDTree<Area> result = loadGeographicalData.execute(container, geoData);

    assertEquals(5, result.size());
  }

  /*
   * Test loadGeographicalData tree height
   */
  @Test
  public void testLoadGeographicalDataWithFilesTreeHeight() throws FileNotFoundException {
    System.out.println("testLoadGeographicalDataWithFilesTreeHeight");
    CSVReader r = new CSVReader(
        "/home/drew/Downloads/Production_Crops_Livestock/Production_Crops_Livestock/Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv");

    List<Map<String, String>> containerData = r.read();

    Container container = LoadData.execute(containerData, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    r = new CSVReader(
        "/home/drew/Downloads/Production_Crops_Livestock/Production_Crops_Livestock/Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv");

    List<Map<String, String>> geoData = r.read();

    TwoDTree<Area> result = loadGeographicalData.execute(container, geoData);

    assertEquals(3, result.height());
  }
}

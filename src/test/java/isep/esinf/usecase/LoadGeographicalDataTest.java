package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.TwoDTree;

public class LoadGeographicalDataTest {
  LoadGeographicalData loadGeographicalData = new LoadGeographicalData();

  @Test
  public void testLoadGeographicalData() {
    Container c = new Container();
    TwoDTree<Area> tree = new TwoDTree<>();

    Area portugal = new AreaByName("Portugal", 13, 100);
    Area spain = new AreaByName("Spain", 14, 50);
    Area italy = new AreaByName("Italy", 11, 90);

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
    Area portugal = new AreaByName("Portugal", 13, 100);
    Area spain = new AreaByName("Spain", 14, 50);
    Area italy = new AreaByName("Italy", 11, 90);

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

  // test loadGeographicalData with invalid file
  @Test
  public void testLoadGeographicalDataWithInvalidFile() {

  }

  // test loadGeographicalData with not available data /data/EmptyFile.csv
  @Test
  public void testLoadGeographicalDataWithNotAvailableData() throws FileNotFoundException {
    System.out.println("testLoadGeographicalDataWithNotAvailableData");
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/EmptyFile.csv");

    Container c = new Container();
    Area portugal = new AreaByName("Portugal", 13, 100);
    Area spain = new AreaByName("Spain", 14, 50);
    Area italy = new AreaByName("Italy", 11, 90);

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

    Area burundi = new AreaByName("Burundi", 13, 100);
    Area israel = new AreaByName("Israel", 14, 101);
    Area tuvalu = new AreaByName("Tuvalu", 0, 102);
    Area mozambique = new AreaByName("Mozambique", 13, 103);
    Area faroeIslands = new AreaByName("Faroe Islands", 14, 104);
    Area pitcairnIslands = new AreaByName("Pitcairn Islands", 0, 105);
    Area niue = new AreaByName("Niue", 13, 106);
    Area eswatini = new AreaByName("Eswatini", 14, 107);

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
    tree.insert(tuvalu, -7.109535, 177.64933);

    assertEquals(result.toString(), tree.toString());

  }

  @Test
  public void testLoadGeographicalDataCrossingFiles() throws FileNotFoundException {
    // TO DO (waiting for implementation of the method)
  }

}

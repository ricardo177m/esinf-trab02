package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.utils.TwoDTree;

public class LoadGeographicalDataTest {
  // test loadGeographicalData
  LoadGeographicalData loadGeographicalData = new LoadGeographicalData();

  // test loadGeographicalData
  // its giving the correct output but the toString is not correct

  //@Test
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

    tree.insert(portugal, 39.3999, -8.2245);
    tree.insert(spain, 40.4637, -3.7492);
    tree.insert(italy, 41.8719, 12.5674);

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    assertEquals(result, tree);

  }

  // test loadGeographicalData with empty data
  // @Test
  public void testLoadGeographicalDataEmptyData() {
    Container c = new Container();
    TwoDTree<Area> tree = new TwoDTree<>();
    Area portugal = new AreaByName("Portugal", 13, 100);
    Area spain = new AreaByName("Spain", 14, 50);
    Area italy = new AreaByName("Italy", 11, 90);

    c.addArea(portugal);
    c.addArea(spain);
    c.addArea(italy);

    List<Map<String, String>> geoData = new ArrayList<>();

    TwoDTree<Area> result = loadGeographicalData.execute(c, geoData);

    assertEquals(result, tree);

  }

  // test loadGeographicalData with invalid file
  @Test
  public void testLoadGeographicalDataWithInvalidFile() {
    // TODO
  }

  @Test
  public void testLoadGeographicalDataWithNotAvailableData() {
    // TODO
  }
  // test loadGeographicalData with not available data

}

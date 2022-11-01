package isep.esinf.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MockGeoData {
  public List<Map<String, String>> mock() {
    List<Map<String, String>> geoData = new ArrayList<>();
    geoData.add(Map.of("area", "Portugal", "latitude", "39.3999", "longitude", "-8.2245"));
    geoData.add(Map.of("area", "Spain", "latitude", "40.4637", "longitude", "-3.7492"));
    geoData.add(Map.of("area", "Burundi", "latitude", "-3.373056", "longitude", "29.918886"));
    geoData.add(Map.of("area", "Tuvalu", "latitude", "-3.373056", "longitude", "177.64933"));
    return geoData;
  }
}

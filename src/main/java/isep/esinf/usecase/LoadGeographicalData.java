package isep.esinf.usecase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.utils.TwoDTree;

public class LoadGeographicalData {
  private Map<String, Map<String, String>> mapListToMap(List<Map<String, String>> list) {
    Map<String, Map<String, String>> map = new HashMap<>();
    for (Map<String, String> m : list)
      map.put(m.get("area"), m);

    return map;
  }

  public TwoDTree<Area> execute(Container container, List<Map<String, String>> geoData) {
    Map<String, Map<String, String>> map = mapListToMap(geoData);
    TwoDTree<Area> tree = new TwoDTree<>();

    for (Area area : container.getAreas()) {
      Map<String, String> data = map.get(area.getArea());
      if (data == null)
        continue;

      tree.insert(area, Double.parseDouble(data.get("latitude")),
          Double.parseDouble(data.get("longitude")));
    }

    return tree;
  }
}

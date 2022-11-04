package isep.esinf.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.utils.TwoDNode;
import isep.esinf.utils.TwoDTree;
import java.awt.geom.Point2D;

/**
 * @author André Barros
 * @author Tomás Lopes
 */
public class LoadGeographicalData {
  private Map<String, Map<String, String>> mapListToMap(List<Map<String, String>> list) {
    if (list == null)
      return null;
    Map<String, Map<String, String>> map = new HashMap<>();
    for (Map<String, String> m : list)
      map.put(m.get("area"), m);

    return map;
  }

  /**
   * Helper method to load data from a csv file into a TwoDTree.
   * This method gets an already loaded Container and adds the coordinates of
   * countries to it.
   */
  public TwoDTree<Area> execute(Container container, List<Map<String, String>> geoData) {
    if (container == null || geoData == null)
      return null;

    Map<String, Map<String, String>> map = mapListToMap(geoData);
    TwoDTree<Area> tree = new TwoDTree<>();

    List<TwoDNode<Area>> nodes = new ArrayList<>();

    for (Area area : container.getAreas()) {
      Map<String, String> data = map.get(area.getArea());
      if (data == null)
        continue;

      nodes.add(
          new TwoDNode<Area>(area, null, null, new Point2D.Double(Double.parseDouble(data.get("latitude")),
              Double.parseDouble(data.get("longitude")))));

    }

    tree.buildTree(nodes);

    return tree;
  }
}

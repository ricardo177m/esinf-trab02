package isep.esinf.usecase;

import java.util.List;
import java.util.Map;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByName;
import isep.esinf.utils.TwoDTree;

/**
 * Alínea 4
 *
 * @author Tomás Lopes
 */
public class ClosestProductionArea {
  public Area execute(double latitude, double longitude, String item, String element, int year,
      Container data, List<Map<String, String>> geoDataMap) {
    Item i = new ItemByName(0, 0, item);
    Element e = new ElementByName(0, element);

    Container sanitizedData = data.getAreasWithConditions(i, e, year);

    if (sanitizedData.getNOfAreas() == 0)
      return null;

    LoadGeographicalData loadGeographicalData = new LoadGeographicalData();
    TwoDTree<Area> geoData = loadGeographicalData.execute(sanitizedData, geoDataMap);

    return geoData.findNearestNeighbor(latitude, longitude);
  }
}

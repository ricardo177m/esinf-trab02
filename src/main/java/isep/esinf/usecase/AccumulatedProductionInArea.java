package isep.esinf.usecase;

import java.util.List;
import java.util.Map;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.utils.TwoDTree;

/**
 * Alínea 5
 *
 * @author André Barros
 */
public class AccumulatedProductionInArea {
  /*
   * Returns the sum of the production of an item in a list of areas
   */
  private double getSumProduction(List<Area> areas, ItemByCode item, ElementByCode element,
      int year) {
    double sum_production = 0;

    for (Area area : areas)
      sum_production += area.getItem(item).getElement(element).getProductionData(year).getValue();

    return sum_production;
  }

  /*
   * Returns the accumulated production of an item in a given area
   */
  public Double execute(double x1, double y1, double x2, double y2, int itemCode, int elementCode,
      int year, Container container, List<Map<String, String>> geoData) {
    ElementByCode e = new ElementByCode(elementCode, "");
    ItemByCode i = new ItemByCode(itemCode, 0, "");

    if (container == null)
      return null;

    Container sanitizedData = container.getAreasWithConditions(i, e, year);

    LoadGeographicalData loadGeographicalData = new LoadGeographicalData();
    TwoDTree<Area> tree = loadGeographicalData.execute(sanitizedData, geoData);

    if (tree == null)
      return null;

    List<Area> areas = tree.searchRangeArea(x1, y1, x2, y2);

    return getSumProduction(areas, i, e, year);
  }
}

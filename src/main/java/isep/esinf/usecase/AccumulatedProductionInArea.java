package isep.esinf.usecase;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.TwoDTree;

/**
 * Alínea 5
 *
 * @author André Barros
 */
public class AccumulatedProductionInArea {

  /*
   * Returns the accumulated production of an item in a given area
   */
  public Double execute(double x1, double y1, double x2, double y2, ItemByCode item, int year, ElementByCode element,
      Container data) {

    Container sanitizedData = data.getAreasWithConditions(item, element, year);

    TwoDTree<Area> tree;

    try {
      tree = getData(sanitizedData, "./src/test/java/isep/esinf/data/TestLoadGeoData_Small.csv");
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }

    List<Area> areas = tree.searchRangeArea(x1, y1, x2, y2);

    double sum_production = getSumProduction(areas, item, element, year);

    return sum_production;
  }

  /*
   * Returns a TwoDTree with the data from the file
   */
  private TwoDTree<Area> getData(Container container, String fileName) throws FileNotFoundException {
    LoadGeographicalData loadGeographicalData = new LoadGeographicalData();
    CSVReader csvReader = new CSVReader(fileName);

    List<Map<String, String>> data = csvReader.read();

    return loadGeographicalData.execute(container, data);
  }

  /*
   * Returns the sum of the production of an item in a list of areas
   */
  private double getSumProduction(List<Area> areas, ItemByCode item, ElementByCode element, int year) {
    double sum_production = 0;

    for (Area area : areas) {
      sum_production += area.getItem(item).getElement(element).getProductionData(year).getValue();
    }

    return sum_production;
  }
}

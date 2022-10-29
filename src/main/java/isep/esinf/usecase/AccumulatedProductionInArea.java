package isep.esinf.usecase;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
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
  public List<Area> execute(double x1, double y1, double x2, double y2, Item item, int year, Element element,
      Container data) {

    TwoDTree<Area> tree;

    try {
      tree = getData(data, "fileName.csv");
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }

    return tree.searchRangeArea(x1, y1, x2, y2);
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
}

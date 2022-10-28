package isep.esinf.usecase;

import isep.esinf.model.Area;
import isep.esinf.model.Item;
import isep.esinf.model.Element;
import isep.esinf.model.Container;
import isep.esinf.utils.TwoDTree;
import isep.esinf.utils.CSVReader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Alínea 4
 *
 * @author Tomás Lopes
 */
public class ClosestProductionArea {
  private TwoDTree<Area> getGeographicalData(Container container, String fileName) throws FileNotFoundException {
    LoadGeographicalData loadGeographicalData = new LoadGeographicalData();
    CSVReader csvReader = new CSVReader(fileName);

    List<Map<String, String>> data = csvReader.read();

    return loadGeographicalData.execute(container, data);
  }

  public Area execute(double latitude, double longitude, Item item, Element element, int year,
      Container data) {
    Container sanitizedData = data.getAreasWithConditions(item,element,year);

    try {
      TwoDTree<Area> geoData = getGeographicalData(sanitizedData, "data/areas.csv");

      return  geoData.findNearestNeighbor(latitude, longitude);
    }catch(FileNotFoundException e) {
      System.out.println("File not found");
    }
    return null;
  }
}

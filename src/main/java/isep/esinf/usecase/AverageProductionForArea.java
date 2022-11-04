package isep.esinf.usecase;

import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

import isep.esinf.exceptions.InvalidTimeIntervalException;
import isep.esinf.exceptions.NullAreaException;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.AreaByName;

/**
 * Alínea 2
 * 
 * @author Carlos Lopes
 */
public class AverageProductionForArea {
  private int firstYear, lastYear;
  private Area area;

  public AverageProductionForArea(String area, int firstYear, int lastYear, Container container) throws InvalidTimeIntervalException, NullAreaException{
    if(area == null || area.equals(""))
    throw new NullAreaException();

    Area a = new AreaByName(0, "", area);
    this.area = container.getArea(a);

    setTimeInterval(firstYear, lastYear);
  }

  public void setTimeInterval(int firstYear, int lastYear) throws InvalidTimeIntervalException{
    if(firstYear <= 0 || lastYear <= 0){

      if(lastYear < firstYear){
        this.lastYear = firstYear;
        this.firstYear = lastYear;
      }else{
        this.lastYear = lastYear;
        this.firstYear = firstYear;
      }

    }else{
      throw new InvalidTimeIntervalException();
    }
  }
  
  public TreeMap<Map.Entry<String,String>, Double> execute() {
    TreeMap<Map.Entry<String,String>, Double> map = new TreeMap<>();

    Iterable<Item> items = area.getItems();

    for (Item item : items) {
      Iterable<Element> elements = item.getElements();
      for (Element element : elements) {
        Map.Entry<String,String> entry = new AbstractMap.SimpleEntry<String, String>(item.getItem(), element.getElement());  
        map.put(entry, element.valueSumTimeInterval(firstYear, lastYear));    
      }
    }

    return map;

  }
}

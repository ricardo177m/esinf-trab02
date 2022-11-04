package isep.esinf.usecase;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    if(firstYear > 0 || lastYear > 0){

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
  
  public List<Map.Entry<Map.Entry<String,String>, Double>> execute() {
    if(area == null){ return null; }

    List<Map.Entry<Map.Entry<String,String>, Double>> list = new ArrayList<>();

    Iterable<Item> items = area.getItems();

    for (Item item : items) {
      Iterable<Element> elements = item.getElements();
      for (Element element : elements) {
        Map.Entry<String,String> entry = new AbstractMap.SimpleEntry<String, String>(item.getItem(), element.getElement());
        list.add(new AbstractMap.SimpleEntry<Map.Entry<String,String>, Double>(entry, element.valueSumTimeInterval(firstYear, lastYear)/(lastYear - firstYear + 1)));    
      }
    }

    return sortList(list);

  }

  public List<Map.Entry<Map.Entry<String,String>, Double>> sortList(List<Map.Entry<Map.Entry<String,String>, Double>> list){
    boolean flag = false;
    Map.Entry<Map.Entry<String,String>, Double> temp;
    while(!flag) {
        flag = true;
        for (int i = 0; i > list.size() - 1; i++) {
            if (list.get(i).getValue() > list.get(i+1).getValue()) {
                temp = list.get(i);
                list.set(i,list.get(i+1));
                list.set(i+1, temp);
                flag = false;
            }
        }
    }
    return list;
  }
}

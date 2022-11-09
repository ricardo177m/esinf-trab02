package isep.esinf.usecase;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import isep.esinf.exceptions.InvalidTimeIntervalException;
import isep.esinf.exceptions.NullAreaException;
import isep.esinf.exceptions.NullContainerException;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.utils.MergeSort;

/**
 * Alínea 2
 * 
 * @author Carlos Lopes
 */
public class AverageProductionForArea {
  private int firstYear, lastYear;
  private Area area;

  public AverageProductionForArea(String area, int firstYear, int lastYear, Container container) throws InvalidTimeIntervalException, NullAreaException, NullContainerException{
    if(area == null || area.equals(""))
    throw new NullAreaException();

    if(container == null)
    throw new NullContainerException();

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
        double sum = element.valueSumTimeInterval(firstYear, lastYear);
        double average = sum / (lastYear - firstYear + 1); // + 1 because first and last year are included
        list.add(new AbstractMap.SimpleEntry<Map.Entry<String,String>, Double>(entry, average));   
      }
    }

    return (new MergeSort<Map.Entry<Map.Entry<String,String>, Double>>()).sort(list,cmp);

  }

  private final Comparator<Map.Entry<Map.Entry<String,String>, Double>> cmp = new Comparator<Map.Entry<Map.Entry<String,String>, Double>>(){
    @Override
    public int compare(Map.Entry<Map.Entry<String,String>, Double> o1, Map.Entry<Map.Entry<String,String>, Double> o2) {
      return - Double.compare(o1.getValue(), o2.getValue());
    }
  };
}

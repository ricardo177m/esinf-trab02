package isep.esinf.usecase;

import java.util.ArrayList;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;

/**
 * Alínea 3
 * Given an Item and an Element, get the top N areas with the biggest value
 * in the last year registered in the data file.
 * 
 * @author Tomás Russo
 */
public class BestLastYear {
  Item item;
  Element element;
  Container data;

  /**
   * Constructor for BestLastYear
   * 
   * @param item    Item to be used
   * @param element Element to be used
   */
  public BestLastYear(Item item, Element element, Container data) {
    this.item = item;
    this.element = element;
    /* Get only the Areas with the given item and element */
    this.data = data.getAreasWithConditions(item, element);
  }

  /**
   * Get the top N areas with the biggest value in the last year registered
   * in the data file.
   * 
   * @param N Number of areas to be returned
   * @return Top N areas with the biggest value in the last year registered or
   *         null if there are no areas
   * @throws IllegalArgumentException if N is less than 1
   */
  public ArrayList<Area> execute(int N) {
    /* Check if N is valid */
    if (N <= 0)
      throw new IllegalArgumentException("N must be greater than 0");
    /* Check if there are any areas */
    if (data == null || data.isEmpty())
      return null;

    /* Create an ArrayList to store the top N areas */
    ArrayList<Area> topN = new ArrayList<>();

    /*
     * Get the most recent year registered in the data file, for the given item and
     * element
     */
    int lastYear = getMostRecentRegisteredYearForItemAndElement();

    /*
     * Get only Areas with the given Item and Element for the last registered year
     */
    Container newAreas = data.getAreasWithConditions(item, element, lastYear);

    /* Iterate over all valid Areas */
    for (Area area : newAreas.getAreas()) {
      /* Fill the array with the first N Areas in newAreas */
      if (topN.size() < N) {
        topN.add(area);
        continue;
      }

      /*
       * If it gets here, it means that there are more valid areas in newAreas than N.
       * 
       * So, check if any of the remaining valid areas has a bigger value than any of
       * the areas stored in topN, and if so, replace it.
       */
      for (int i = 0; i < topN.size(); i++) {
        if (area.getItem(item).getElement(element).getProductionData(lastYear).getValue() > topN.get(i).getItem(item)
            .getElement(element).getProductionData(lastYear).getValue()) {
          // topN.add(i, area);
          // topN.remove(topN.size() - 1);
          topN.set(i, area);
          break;
        }
      }
    }

    return topN;
  }

  /**
   * Get the most recent registered year in the data file, for the given Item and
   * Element.
   * 
   * @return most recent registered year in the data file
   */
  private int getMostRecentRegisteredYearForItemAndElement() {
    int max = 0;

    for (Area area : data.getAreas()) {
      Element e = area.getItem(item).getElement(element);

      if (e.getMostRecentYear() > max) {
        max = e.getMostRecentYear();
      }
    }

    return max;
  }
}

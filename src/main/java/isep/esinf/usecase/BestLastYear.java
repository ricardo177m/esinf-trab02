package isep.esinf.usecase;

import java.util.ArrayList;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.utils.AVL;

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
  public BestLastYear(Container data, Item item, Element element) {
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

    /* Get an ArrayList of areas ordered by value */
    topN = orderAreasByValueOfYear(newAreas, lastYear);

    if (topN.size() > N) {
      /* Remove the last N elements from the ArrayList */
      for (int i = 0; i < topN.size() - N; i++) {
        topN.remove(topN.size() - 1);
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

    /* Iterate over all areas to find the max year */
    for (Area area : data.getAreas()) {
      Element e = area.getItem(item).getElement(element);

      if (e.getMostRecentYear() > max) {
        max = e.getMostRecentYear();
      }
    }

    return max;
  }

  /**
   * Get an ArrayList with areas ordered by the value of the given year
   * 
   * Complexity: O(n . log n)
   * 
   * @param areas A Container with the areas to be ordered
   * @param year  The year to be used to order the areas
   * @return An ArrayList with areas ordered by the value of the given year
   */
  private ArrayList<Area> orderAreasByValueOfYear(Container areas, int year) {
    /* Check if areas have any element */
    if (areas == null || areas.isEmpty())
      return null;

    /* Inner class to order areas by it's value */
    class AreaValue implements Comparable<AreaValue> {
      Area area;
      double value;

      /* Constructor for AreaValue */
      public AreaValue(Area area, double value) {
        this.area = area;
        this.value = value;
      }

      /* Compare AreaValues by it's value */
      @Override
      public int compareTo(AreaValue o) {
        if (this.value > o.value)
          return 1;
        else if (this.value < o.value)
          return -1;
        else
          return 0;
      }
    }

    /* Create an AVL tree to store the areas ordered by it's value */
    AVL<AreaValue> avl = new AVL<>();

    /* Iterate over all areas to add them to the AVL tree */
    for (Area area : areas.getAreas()) {
      avl.insert(new AreaValue(area, area.getItem(item).getElement(element).getProductionData(year).getValue()));
    }

    /* Create an ArrayList to store the areas ordered by it's value */
    ArrayList<Area> orderedAreas = new ArrayList<>();

    /* Iterate in order over the AVL tree to add the areas to the ArrayList */
    for (AreaValue areaValue : avl.inOrder()) {
      orderedAreas.add(areaValue.area);
    }

    return orderedAreas;
  }
}

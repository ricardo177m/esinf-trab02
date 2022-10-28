package isep.esinf.usecase;

import java.util.ArrayList;

import isep.esinf.model.Area;
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

  /**
   * Constructor for BestLastYear
   * 
   * @param item    Item to be used
   * @param element Element to be used
   */
  public BestLastYear(Item item, Element element) {
    this.item = item;
    this.element = element;
  }

  /**
   * Get the top N areas with the biggest value in the last year registered
   * in the data file.
   * 
   * @param n Number of areas to be returned
   * @return Top N areas with the biggest value in the last year registered
   */
  public ArrayList<Area> execute(int N) {
    ArrayList<Area> topN = new ArrayList<>();

    return topN;
  }
}

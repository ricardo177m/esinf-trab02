package isep.esinf.usecase;

import java.util.List;
import java.util.Map;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.ProductionData;
import isep.esinf.utils.Field;

/**
 * Alínea 1 - Load FAOSTAT data from a file into an AVL tree.
 *
 * @author Ricardo Moreira <1211285@isep.ipp.pt>
 */
public class LoadData {
  public static void execute(List<Map<String, String>> data, Class<? extends Area> area,
      Class<? extends Item> item, Class<? extends Element> element) {
    // import data from a csv file into BSTs
    Container container = new Container();

    // Area > Item > Element > ProductionData

    data.forEach(row -> {
      try {
        // Area
        int areaCode = Integer.parseInt(row.get(Field.AREA_CODE.name));
        // String tmp = row.get(Field.AREA_M49.name);
        int areaM49 = Integer.parseInt(row.get(Field.AREA_M49.name));
        String areaName = row.get(Field.AREA.name);

        // create instance of area
        Area newArea =
            (Area) area.getDeclaredConstructor().newInstance(areaCode, areaM49, areaName);

        Area found = container.getArea(newArea);

        if (found == null) {
          container.addArea(newArea);
          found = newArea;
        }

        // Item
        int itemCode = Integer.parseInt(row.get(Field.ITEM_CODE.name));
        //
        int itemCpc = Integer.parseInt(row.get(Field.ITEM_CPC.name));
        String itemName = row.get(Field.ITEM.name);

        // create instance of item
        Item newItem =
            (Item) item.getDeclaredConstructor().newInstance(itemCode, itemCpc, itemName);

        Item foundItem = found.getItem(newItem);

        if (foundItem == null) {
          found.addItem(newItem);
          foundItem = newItem;
        }

        // Element
        int elementCode = Integer.parseInt(row.get(Field.ELEMENT_CODE.name));
        String elementName = row.get(Field.ELEMENT.name);

        // create instance of element
        Element newElement =
            (Element) element.getDeclaredConstructor().newInstance(elementCode, elementName);

        Element foundElement = foundItem.getElement(newElement);

        if (foundElement == null) {
          foundItem.addElement(newElement);
          foundElement = newElement;
        }

        // ProductionData
        int year = Integer.parseInt(row.get(Field.YEAR.name));
        double value = Double.parseDouble(row.get(Field.VALUE.name));

        // create instance of production data
        ProductionData production = new ProductionData(year, value);

        foundElement.addProductionData(production);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}

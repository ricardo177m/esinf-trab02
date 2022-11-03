package isep.esinf.usecase;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.ProductionData;
import isep.esinf.model.Value;
import isep.esinf.utils.Field;

/**
 * Alínea 1 - Load FAOSTAT data from a file into an AVL tree.
 *
 * @author Ricardo Moreira <1211285@isep.ipp.pt>
 */
public class LoadData {
  public static Container execute(List<Map<String, String>> data, Class<? extends Area> areaClass,
      Class<? extends Item> itemClass, Class<? extends Element> elementClass) {
    // import data from a csv file into BSTs
    Container container = new Container();

    // Area > Item > Element > ProductionData
    Logger.getLogger(LoadData.class.getName())
        .info(String.format("ok we got data (size=%d), processing it...", data.size()));

    data.forEach(row -> {
      try {
        // Area
        int areaCode = row.get(Field.AREA_CODE.name).length() == 0 ? 0
            : Integer.parseInt(row.get(Field.AREA_CODE.name));
        String areaM49 = row.get(Field.AREA_M49.name);
        String areaName = row.get(Field.AREA.name);

        // create instance of area
        Area newArea = areaClass.getConstructor(int.class, String.class, String.class)
            .newInstance(areaCode, areaM49, areaName);

        Area found = container.getArea(newArea);

        if (found == null) {
          container.addArea(newArea);
          found = newArea;
        }

        // Item
        int itemCode = row.get(Field.ITEM_CODE.name).length() == 0 ? 0
            : Integer.parseInt(row.get(Field.ITEM_CODE.name));
        String itemCpc = row.get(Field.ITEM_CPC.name);
        String itemName = row.get(Field.ITEM.name);

        // create instance of item
        Item newItem = itemClass.getDeclaredConstructor(int.class, String.class, String.class)
            .newInstance(itemCode, itemCpc, itemName);

        Item foundItem = found.getItem(newItem);

        if (foundItem == null) {
          found.addItem(newItem);
          foundItem = newItem;
        }

        // Element
        int elementCode = row.get(Field.ELEMENT_CODE.name).length() == 0 ? 0
            : Integer.parseInt(row.get(Field.ELEMENT_CODE.name));
        String elementName = row.get(Field.ELEMENT.name);

        // create instance of element
        Element newElement = (Element) elementClass.getDeclaredConstructor(int.class, String.class)
            .newInstance(elementCode, elementName);

        Element foundElement = foundItem.getElement(newElement);

        if (foundElement == null) {
          foundItem.addElement(newElement);
          foundElement = newElement;
        }

        // ProductionData
        int year = Integer.parseInt(row.get(Field.YEAR.name));
        double value = row.get(Field.VALUE.name).length() == 0 ? 0
            : Double.parseDouble(row.get(Field.VALUE.name));
        String unit = row.get(Field.UNIT.name);
        String flag = row.get(Field.FLAG.name);

        // create instance of production data
        // TODO add flag description & ignore lines with "data unavailable" flag (!)
        ProductionData production =
            new ProductionData(year, new Value(value, unit, flag, "Flag Description placeholder"));

        foundElement.addProductionData(production);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    return container;
  }
}

package isep.esinf.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByName;

public class ContainerTest {
  @BeforeAll
  public static void setup() {
    // create a container with elements to sanitize
    Container container = new Container();

    Area firstArea = new AreaByCode("Portugal", 100, 200);
    Area secondArea = new AreaByCode("Spain", 200, 300);
    Area thirdArea = new AreaByCode("France", 300, 400);

    Item firstItem = new ItemByName(1, 2, "Item 1");
    Item secondItem = new ItemByName(2, 3, "Item 2");
    Item thirdItem = new ItemByName(3, 4, "Item 3");
    Item fourthItem = new ItemByName(4, 5, "Item 4");
    Item fifthItem = new ItemByName(5, 6, "Item 5");
    Item sixthItem = new ItemByName(6, 7, "Item 6");
    Item seventhItem = new ItemByName(7, 8, "Item 7");
    Item eighthItem = new ItemByName(8, 9, "Item 8");

    Element firstElement = new ElementByCode(1, "Element 1");
    Element secondElement = new ElementByCode(2, "Element 2");
    Element thirdElement = new ElementByCode(3, "Element 3");
    Element fourthElement = new ElementByCode(4, "Element 4");

    ProductionData firstProductionData = new ProductionData(1980, 200);
    ProductionData secondProductionData = new ProductionData(1981, 300);
    ProductionData thirdProductionData = new ProductionData(1982, 400);
    ProductionData fourthProductionData = new ProductionData(1983, 500);
    ProductionData fifthProductionData = new ProductionData(1984, 600);
    ProductionData sixthProductionData = new ProductionData(1985, 700);
    ProductionData seventhProductionData = new ProductionData(1986, 800);

    firstElement.addProductionData(firstProductionData);
    firstElement.addProductionData(secondProductionData);
    firstElement.addProductionData(thirdProductionData);
    secondElement.addProductionData(fourthProductionData);
    secondElement.addProductionData(fifthProductionData);
    thirdElement.addProductionData(sixthProductionData);
    thirdElement.addProductionData(seventhProductionData);

    firstItem.addElement(firstElement);
    firstItem.addElement(secondElement);
    secondItem.addElement(thirdElement);
    secondItem.addElement(fourthElement);

    firstArea.addItem(firstItem);
    firstArea.addItem(secondItem);
    secondArea.addItem(thirdItem);
    secondArea.addItem(fourthItem);
    thirdArea.addItem(fifthItem);
    thirdArea.addItem(sixthItem);
    thirdArea.addItem(seventhItem);
    firstArea.addItem(fifthItem);

    container.addArea(firstArea);
    container.addArea(secondArea);
    container.addArea(thirdArea);
  }

  @Test
  public void testGetAreasWithCondition() {

  }
}

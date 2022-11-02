package isep.esinf.mock;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.ProductionData;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.model.comparators.ItemByName;

public class MockContainer {
  public Container mockByCode() {
    Container container = new Container();

    Area firstArea = new AreaByCode(100, "200", "Portugal");
    Area secondArea = new AreaByCode(200, "300", "Spain");
    Area thirdArea = new AreaByCode(300, "400", "France");
    Area fourthArea = new AreaByCode(400, "500", "Burundi");
    Area fifthArea = new AreaByCode(500, "600", "Tuvalu");

    Item firstItem = new ItemByCode(1, "2", "Item 1");
    Item secondItem = new ItemByCode(2, "3", "Item 2");
    Item thirdItem = new ItemByCode(3, "4", "Item 3");
    Item fourthItem = new ItemByCode(4, "5", "Item 4");
    Item fifthItem = new ItemByCode(5, "6", "Item 5");
    Item sixthItem = new ItemByCode(6, "7", "Item 6");
    Item seventhItem = new ItemByCode(7, "8", "Item 7");
    Item eigthItem = new ItemByCode(8, "9", "Item 8");
    Item ninthItem = new ItemByCode(9, "10", "Item 9");

    Element firstElement = new ElementByCode(1, "Element 1");
    Element secondElement = new ElementByCode(2, "Element 2");
    Element thirdElement = new ElementByCode(3, "Element 3");
    Element fourthElement = new ElementByCode(4, "Element 4");

    Element fifthElement = new ElementByCode(5, "Element 5");
    Element sixthElement = new ElementByCode(6, "Element 6");

    ProductionData firstProductionData = new ProductionData(1980, 200);
    ProductionData secondProductionData = new ProductionData(1981, 300);
    ProductionData thirdProductionData = new ProductionData(1982, 400);
    ProductionData fourthProductionData = new ProductionData(1983, 500);
    ProductionData fifthProductionData = new ProductionData(1984, 600);
    ProductionData sixthProductionData = new ProductionData(1985, 700);
    ProductionData seventhProductionData = new ProductionData(1986, 800);

    ProductionData eighthProductionData = new ProductionData(1980, 721.02);

    firstElement.addProductionData(firstProductionData);
    firstElement.addProductionData(secondProductionData);
    firstElement.addProductionData(thirdProductionData);
    firstElement.addProductionData(eighthProductionData);

    secondElement.addProductionData(firstProductionData);
    secondElement.addProductionData(fourthProductionData);
    secondElement.addProductionData(fifthProductionData);

    thirdElement.addProductionData(sixthProductionData);
    thirdElement.addProductionData(seventhProductionData);

    fourthElement.addProductionData(firstProductionData);

    fifthElement.addProductionData(firstProductionData);
    fifthElement.addProductionData(eighthProductionData);

    sixthElement.addProductionData(eighthProductionData);

    firstItem.addElement(firstElement);
    firstItem.addElement(secondElement);
    secondItem.addElement(thirdElement);
    secondItem.addElement(fourthElement);
    thirdItem.addElement(firstElement);
    thirdItem.addElement(secondElement);
    fourthItem.addElement(thirdElement);
    fourthItem.addElement(fourthElement);
    fifthItem.addElement(firstElement);
    fifthItem.addElement(secondElement);
    sixthItem.addElement(thirdElement);
    seventhItem.addElement(firstElement);
    seventhItem.addElement(secondElement);

    eigthItem.addElement(fourthElement);
    eigthItem.addElement(firstElement);
    eigthItem.addElement(fifthElement);

    ninthItem.addElement(sixthElement);

    firstArea.addItem(firstItem);
    firstArea.addItem(secondItem);
    firstArea.addItem(thirdItem);
    firstArea.addItem(fifthItem);

    secondArea.addItem(firstItem);
    secondArea.addItem(thirdItem);
    secondArea.addItem(fourthItem);
    secondArea.addItem(fifthItem);

    thirdArea.addItem(firstItem);
    thirdArea.addItem(fifthItem);
    thirdArea.addItem(sixthItem);
    thirdArea.addItem(seventhItem);

    fourthArea.addItem(firstItem);
    fourthArea.addItem(eigthItem);
    fourthArea.addItem(ninthItem);

    fifthArea.addItem(firstItem);
    fifthArea.addItem(eigthItem);
    fifthArea.addItem(ninthItem);

    container.addArea(firstArea);
    container.addArea(secondArea);
    container.addArea(thirdArea);
    container.addArea(fourthArea);
    container.addArea(fifthArea);

    return container;
  }

  public Container mockByName() {
    Container container = new Container();

    Area firstArea = new AreaByName(100, "200", "Portugal");
    Area secondArea = new AreaByName(200, "300", "Spain");
    Area thirdArea = new AreaByName(300, "400", "France");
    Area fourthArea = new AreaByName(400, "500", "Burundi");

    Item firstItem = new ItemByName(1, "2", "Item 1");
    Item secondItem = new ItemByName(2, "3", "Item 2");
    Item thirdItem = new ItemByName(3, "4", "Item 3");
    Item fourthItem = new ItemByName(4, "5", "Item 4");
    Item fifthItem = new ItemByName(5, "6", "Item 5");
    Item sixthItem = new ItemByName(6, "7", "Item 6");
    Item seventhItem = new ItemByName(7, "8", "Item 7");

    Item itemCode = new ItemByName(8, "9", "Item 8");

    Element firstElement = new ElementByName(1, "Element 1");
    Element secondElement = new ElementByName(2, "Element 2");
    Element thirdElement = new ElementByName(3, "Element 3");
    Element fourthElement = new ElementByName(4, "Element 4");

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
    secondElement.addProductionData(firstProductionData);
    secondElement.addProductionData(fourthProductionData);
    secondElement.addProductionData(fifthProductionData);
    thirdElement.addProductionData(sixthProductionData);
    thirdElement.addProductionData(seventhProductionData);
    fourthElement.addProductionData(firstProductionData);

    firstItem.addElement(firstElement);
    firstItem.addElement(secondElement);
    secondItem.addElement(thirdElement);
    secondItem.addElement(fourthElement);
    thirdItem.addElement(firstElement);
    thirdItem.addElement(secondElement);
    fourthItem.addElement(thirdElement);
    fourthItem.addElement(fourthElement);
    fifthItem.addElement(firstElement);
    fifthItem.addElement(secondElement);
    sixthItem.addElement(thirdElement);
    seventhItem.addElement(firstElement);
    seventhItem.addElement(secondElement);
    itemCode.addElement(fourthElement);

    firstArea.addItem(firstItem);
    firstArea.addItem(secondItem);
    firstArea.addItem(thirdItem);
    secondArea.addItem(firstItem);
    secondArea.addItem(thirdItem);
    secondArea.addItem(fourthItem);
    secondArea.addItem(fifthItem);
    thirdArea.addItem(fifthItem);
    thirdArea.addItem(sixthItem);
    thirdArea.addItem(seventhItem);
    firstArea.addItem(fifthItem);
    fourthArea.addItem(seventhItem);
    fourthArea.addItem(itemCode);

    container.addArea(firstArea);
    container.addArea(secondArea);
    container.addArea(thirdArea);
    container.addArea(fourthArea);

    return container;
  }
}

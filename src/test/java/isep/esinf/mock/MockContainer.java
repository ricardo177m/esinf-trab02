package isep.esinf.mock;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.ProductionData;
import isep.esinf.model.Value;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.model.comparators.ItemByName;

public class MockContainer {
  public Container mockByCodeSmall() {
    Container container = new Container();
    MockArea mockArea = new MockArea();

    container.addArea(mockArea.mockFirstArea());
    container.addArea(mockArea.mockSecondArea());
    container.addArea(mockArea.mockThirdArea());
    container.addArea(mockArea.mockFourthArea());
    container.addArea(mockArea.mockFifthArea());

    return container;
  }

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
    Item eightItem = new ItemByCode(8, "9", "Item 8");
    Item ninthItem = new ItemByCode(9, "10", "Item 9");

    Element firstElement = new ElementByCode(1, "Element 1");
    Element secondElement = new ElementByCode(2, "Element 2");
    Element thirdElement = new ElementByCode(3, "Element 3");
    Element fourthElement = new ElementByCode(4, "Element 4");
    Element fifthElement = new ElementByCode(5, "Element 5");
    Element sixthElement = new ElementByCode(6, "Element 6");

    ProductionData firstProductionData =
        new ProductionData(1980, new Value(200, "testunit", "testflag", null));
    ProductionData secondProductionData =
        new ProductionData(1981, new Value(300, "testunit", "testflag", null));
    ProductionData thirdProductionData =
        new ProductionData(1982, new Value(400, "testunit", "testflag", null));
    ProductionData fourthProductionData =
        new ProductionData(1983, new Value(500, "testunit", "testflag", null));
    ProductionData fifthProductionData =
        new ProductionData(1984, new Value(600, "testunit", "testflag", null));
    ProductionData sixthProductionData =
        new ProductionData(1985, new Value(700, "testunit", "testflag", null));
    ProductionData seventhProductionData =
        new ProductionData(1986, new Value(800, "testunit", "testflag", null));

    ProductionData eighthProductionData =
        new ProductionData(1987, new Value(900, "testunit", "testflag", null));
    ProductionData ninthProductionData =
        new ProductionData(1987, new Value(1000, "testunit", "testflag", null));
    ProductionData tenthProductionData =
        new ProductionData(1987, new Value(1100, "testunit", "testflag", null));
    ProductionData eleventhProductionData =
        new ProductionData(1987, new Value(1200, "testunit", "testflag", null));
    ProductionData twelfthProductionData =
        new ProductionData(1987, new Value(1300, "testunit", "testflag", null));
    ProductionData thirteenthProductionData =
        new ProductionData(1987, new Value(1400, "testunit", "testflag", null));

    firstElement.addProductionData(firstProductionData);
    firstElement.addProductionData(secondProductionData);
    firstElement.addProductionData(thirdProductionData);
    firstElement.addProductionData(eighthProductionData);

    secondElement.addProductionData(firstProductionData);
    secondElement.addProductionData(fourthProductionData);
    secondElement.addProductionData(fifthProductionData);
    secondElement.addProductionData(ninthProductionData);

    thirdElement.addProductionData(sixthProductionData);
    thirdElement.addProductionData(seventhProductionData);
    thirdElement.addProductionData(tenthProductionData);

    fourthElement.addProductionData(firstProductionData);
    fourthElement.addProductionData(eleventhProductionData);

    fifthElement.addProductionData(firstProductionData);
    fifthElement.addProductionData(eighthProductionData);
    fifthElement.addProductionData(twelfthProductionData);

    sixthElement.addProductionData(eighthProductionData);
    sixthElement.addProductionData(thirteenthProductionData);

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

    eightItem.addElement(fourthElement);
    eightItem.addElement(firstElement);
    eightItem.addElement(fifthElement);

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
    fourthArea.addItem(eightItem);
    fourthArea.addItem(ninthItem);

    fifthArea.addItem(firstItem);
    fifthArea.addItem(eightItem);
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

    ProductionData firstProductionData =
        new ProductionData(1980, new Value(200, "testunit", "testflag", null));
    ProductionData secondProductionData =
        new ProductionData(1981, new Value(300, "testunit", "testflag", null));
    ProductionData thirdProductionData =
        new ProductionData(1982, new Value(400, "testunit", "testflag", null));
    ProductionData fourthProductionData =
        new ProductionData(1983, new Value(500, "testunit", "testflag", null));
    ProductionData fifthProductionData =
        new ProductionData(1984, new Value(600, "testunit", "testflag", null));
    ProductionData sixthProductionData =
        new ProductionData(1985, new Value(700, "testunit", "testflag", null));
    ProductionData seventhProductionData =
        new ProductionData(1986, new Value(800, "testunit", "testflag", null));

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

  public Container mockByCodeMini() {
    Container container = new Container();

    Area a1 = new AreaByCode(100, "200", "Portugal");
    Area a2 = new AreaByCode(200, "300", "Spain");

    Item i1 = new ItemByCode(1, "2", "Item 1");
    Item i2 = new ItemByCode(2, "3", "Item 2");

    Element e1 = new ElementByCode(1, "Element 1");
    Element e2 = new ElementByCode(2, "Element 2");

    ProductionData p1 = new ProductionData(1980,
        new Value(10, "testunit", "I", "Imputed value"));
    ProductionData p2 = new ProductionData(1981,
        new Value(20, "testunit", "A", "Official figure"));
    ProductionData p3 = new ProductionData(1982,
        new Value(30, "testunit", "E", "Estimated value"));

    a1.addItem(i1);
    a1.addItem(i2);
    a2.addItem(i1);
    a2.addItem(i2);

    i1.addElement(e1);
    i1.addElement(e2);
    i2.addElement(e1);
    i2.addElement(e2);

    e1.addProductionData(p1);
    e1.addProductionData(p2);
    e1.addProductionData(p3);
    e2.addProductionData(p1);
    e2.addProductionData(p2);
    e2.addProductionData(p3);

    container.addArea(a1);
    container.addArea(a2);

    return container;
  }

  public Container mockByNameMini() {
    Container container = new Container();

    Area a1 = new AreaByName(100, "200", "Portugal");
    Area a2 = new AreaByName(200, "300", "Spain");

    Item i1 = new ItemByName(1, "2", "Item 1");
    Item i2 = new ItemByName(2, "3", "Item 2");

    Element e1 = new ElementByName(1, "Element 1");
    Element e2 = new ElementByName(2, "Element 2");

    ProductionData p1 = new ProductionData(1980,
        new Value(10, "testunit", "I", "Imputed value"));
    ProductionData p2 = new ProductionData(1981,
        new Value(20, "testunit", "A", "Official figure"));
    ProductionData p3 = new ProductionData(1982,
        new Value(30, "testunit", "E", "Estimated value"));

    a1.addItem(i1);
    a1.addItem(i2);
    a2.addItem(i1);
    a2.addItem(i2);

    i1.addElement(e1);
    i1.addElement(e2);
    i2.addElement(e1);
    i2.addElement(e2);

    e1.addProductionData(p1);
    e1.addProductionData(p2);
    e1.addProductionData(p3);
    e2.addProductionData(p1);
    e2.addProductionData(p2);
    e2.addProductionData(p3);

    container.addArea(a1);
    container.addArea(a2);

    return container;
  }

  public Container mockByCodeMiniVersionMissingFlags() {
    Container container = new Container();

    Area a1 = new AreaByCode(100, "200", "Portugal");
    Area a2 = new AreaByCode(200, "300", "Spain");

    Item i1 = new ItemByCode(1, "2", "Item 1");
    Item i2 = new ItemByCode(2, "3", "Item 2");

    Element e1 = new ElementByCode(1, "Element 1");
    Element e2 = new ElementByCode(2, "Element 2");

    ProductionData p1 = new ProductionData(1980,
        new Value(10, "testunit", "I", "Imputed value"));
    ProductionData p3 = new ProductionData(1982,
        new Value(30, "testunit", "E", "Estimated value"));

    a1.addItem(i1);
    a1.addItem(i2);
    a2.addItem(i1);
    a2.addItem(i2);

    i1.addElement(e1);
    i1.addElement(e2);
    i2.addElement(e1);
    i2.addElement(e2);

    e1.addProductionData(p1);
    e1.addProductionData(p3);
    e2.addProductionData(p1);
    e2.addProductionData(p3);

    container.addArea(a1);
    container.addArea(a2);

    return container;
  }

  public Container mockByCodeExtraMini() {
    Container container = new Container();

    Area a1 = new AreaByCode(100, "200", "Portugal");

    Item i1 = new ItemByCode(1, "2", "Item 1");

    Element e1 = new ElementByCode(1, "Element 1");

    ProductionData p1 = new ProductionData(1980,
        new Value(10, "testunit", "A", "Official figure"));

    a1.addItem(i1);
    i1.addElement(e1);
    e1.addProductionData(p1);
    container.addArea(a1);

    return container;
  }


  public Container mockByNameExtraMini() {
    Container container = new Container();

    Area a1 = new AreaByName(100, "200", "Portugal");

    Item i1 = new ItemByName(1, "2", "Item 1");

    Element e1 = new ElementByName(1, "Element 1");

    ProductionData p1 = new ProductionData(1980,
        new Value(10, "testunit", "A", "Official figure"));

    a1.addItem(i1);
    i1.addElement(e1);
    e1.addProductionData(p1);
    container.addArea(a1);

    return container;
  }
}

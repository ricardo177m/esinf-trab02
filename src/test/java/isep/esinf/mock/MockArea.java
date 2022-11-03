package isep.esinf.mock;

import isep.esinf.model.Area;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.ProductionData;
import isep.esinf.model.Value;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;

public class MockArea {
  private static final Area firstArea = new AreaByCode(100, "200", "Portugal");
  private static final Area secondArea = new AreaByCode(200, "300", "Spain");
  private static final Area thirdArea = new AreaByCode(300, "400", "France");
  private static final Area fourthArea = new AreaByCode(400, "500", "Burundi");
  private static final Area fifthArea = new AreaByCode(500, "600", "Tuvalu");

  public MockArea() {
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
        new ProductionData(1980, new Value(200, "testunit", "testflag", "testFlagDescription"));
    ProductionData secondProductionData =
        new ProductionData(1981, new Value(300, "testunit", "testflag", "testFlagDescription"));
    ProductionData thirdProductionData =
        new ProductionData(1982, new Value(400, "testunit", "testflag", "testFlagDescription"));
    ProductionData fourthProductionData =
        new ProductionData(1983, new Value(500, "testunit", "testflag", "testFlagDescription"));
    ProductionData fifthProductionData =
        new ProductionData(1984, new Value(600, "testunit", "testflag", "testFlagDescription"));
    ProductionData sixthProductionData =
        new ProductionData(1985, new Value(700, "testunit", "testflag", "testFlagDescription"));
    ProductionData seventhProductionData =
        new ProductionData(1986, new Value(800, "testunit", "testflag", "testFlagDescription"));

    ProductionData eighthProductionData =
        new ProductionData(1980, new Value(721.02, "testunit", "testflag", "testFlagDescription"));

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

    ninthItem.addElement(thirdElement);

    firstArea.addItem(firstItem);
    firstArea.addItem(secondItem);
    firstArea.addItem(thirdItem);
    firstArea.addItem(fifthItem);

    secondArea.addItem(secondItem);

    thirdArea.addItem(firstItem);
    thirdArea.addItem(fifthItem);
    thirdArea.addItem(sixthItem);
    thirdArea.addItem(seventhItem);

    fourthArea.addItem(eightItem);
    fourthArea.addItem(ninthItem);

    fifthArea.addItem(firstItem);
    fifthArea.addItem(eightItem);
    fifthArea.addItem(ninthItem);
  }

  /**
   * Mocks an area with:
   *
   * - Items: 1,2,3,5; Elements: 1,2,3; Production Years: 1980, 1981, 1982, 1985, 1986
   *
   * @return a deep copy of the first area
   */
  public Area mockFirstArea() {
    return firstArea.clone();
  }

  /**
   * Mocks an area with:
   *
   * - Items: 2; Elements: 3; Production Years: 1985, 1986
   *
   * @return a deep copy of the second area
   */
  public Area mockSecondArea() {
    return secondArea.clone();
  }

  /**
   * Mocks an area with:
   *
   * - Items: 1,5,6,7; Elements: 1,2,3; Production Years: 1980, 1981, 1982, 1983, 1984, 1985, 1986
   *
   * @return a deep copy of the third area
   */
  public Area mockThirdArea() {
    return thirdArea.clone();
  }

  /**
   * Mocks an area with:
   *
   * - Items: 8,9; Elements: 1,3,4,5; Production Years: 1980, 1981, 1982, 1985, 1986
   *
   * @return a deep copy of the fourth area
   */
  public Area mockFourthArea() {
    return fourthArea.clone();
  }

  /**
   *
   * Mocks an area with:
   *
   * - Items: 1,8,9; Elements: 1,2,3,4,5; Production Years: 1980, 1981, 1982, 1983, 1984, 1985, 1986
   *
   * @return a deep copy of the fifth area
   */
  public Area mockFifthArea() {
    return fifthArea.clone();
  }
}

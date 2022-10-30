package isep.esinf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByName;

public class ContainerTest {
  private static Container container;
  private static Area firstArea = new AreaByCode(100, 200, "Portugal");
  private static Area secondArea = new AreaByCode(200, 300, "Spain");
  private static Item firstItem = new ItemByName(1, 2, "Item 1");
  private static Element secondElement = new ElementByCode(2, "Element 2");
  private static final int YEAR = 1980;

  @BeforeAll
  public static void setup() {
    // create a container with elements to filter
    container = (new MockContainer()).mock();
  }

  @Test
  public void testGetAreasWithCondition() {
    Container expected = new Container();
    expected.addArea(firstArea);
    expected.addArea(secondArea);

    Container actual = container.getAreasWithConditions(firstItem, secondElement, YEAR);

    assertEquals(expected, actual);
  }

  @Test
  public void testGetAreasWithNull() {
    Container actual = container.getAreasWithConditions(null, null, YEAR);

    assertEquals(0, actual.getNOfAreas());
  }
}

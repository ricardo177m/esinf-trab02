package isep.esinf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockArea;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByName;

public class ContainerTest {
  private static Container container;

  private static Item firstItem = new ItemByName(1, "2", "Item 1");
  private static Element secondElement = new ElementByCode(2, "Element 2");
  private static final int YEAR = 1980;

  @BeforeAll
  public static void setup() {
    // create a container with elements to filter
    container = (new MockContainer()).mockByCodeSmall();
  }

  @Test
  public void testGetAreasWithCondition() {
    Container expected = new Container();
    MockArea mockArea = new MockArea();

    expected.addArea(mockArea.mockFirstArea());
    expected.addArea(mockArea.mockThirdArea());
    expected.addArea(mockArea.mockFifthArea());

    Container actual = container.getAreasWithConditions(firstItem, secondElement, YEAR);

    assertEquals(expected, actual);
  }

  @Test
  public void testGetAreasWithNull() {
    Container actual = container.getAreasWithConditions(null, null, YEAR);

    assertEquals(0, actual.getNOfAreas());
  }
}

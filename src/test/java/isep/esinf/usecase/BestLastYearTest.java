package isep.esinf.usecase;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;

public class BestLastYearTest {
  BestLastYear bestLastYear;

  public static Container container = new Container();
  public static MockContainer mockContainer = new MockContainer();

  Item item;
  Element element;

  @BeforeAll
  public static void setup() {

  }

  @Test
  public void testWithMockByCodeAndN1() {
    container = mockContainer.mockByCode();

    item = new ItemByCode(1, "2", "Item 1");
    element = new ElementByCode(1, "Element 1");

    bestLastYear = new BestLastYear(container, item, element);

    ArrayList<Area> result = bestLastYear.execute(1);

    ArrayList<Area> expected = new ArrayList<>();

  }
}

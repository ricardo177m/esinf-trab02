package isep.esinf.usecase;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.model.comparators.ItemByName;

public class AcumulatedProductionInAreaTest {
  AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();

  @Test
  public void testAccumulatedProductionInArea() throws FileNotFoundException {
    MockContainer mockContainer = new MockContainer();

    ItemByCode item = new ItemByCode(10, 12, "Wheat");
    ElementByCode element = new ElementByCode(10, "Test");

    // Double sum = aInArea.execute(3.0, 3.0, 9.0, 9.0, item, 2010, element,
    // mockContainer);

  }
}

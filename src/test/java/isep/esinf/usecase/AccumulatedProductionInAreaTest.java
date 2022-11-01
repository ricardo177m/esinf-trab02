package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;

public class AccumulatedProductionInAreaTest {
  AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();

  /*
   * Test if the sum of the production of an item in a list of areas is correct
   */
  @Test
  public void testAccumulatedProductionInArea() throws FileNotFoundException {
    MockContainer mockContainer = new MockContainer();
    Container container = mockContainer.mock();

    ItemByCode item = new ItemByCode(8, 9, "Item 8");
    ElementByCode element = new ElementByCode(4, "Element 4");

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, item, 1980, element,
        container);

    assertEquals(200, sum);

  }
}

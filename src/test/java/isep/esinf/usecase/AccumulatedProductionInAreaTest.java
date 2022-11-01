package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.mock.MockGeoData;
import isep.esinf.model.Container;

public class AccumulatedProductionInAreaTest {
  AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();

  public static Container container;
  private static List<Map<String, String>> geoData;


  @BeforeAll
  public static void setup() {
    MockContainer mockContainer = new MockContainer();
    container = mockContainer.mockByCode();
    geoData = (new MockGeoData()).mock();
  }

  /*
   * Test if the sum of the production of an item in a list of areas is correct
   */
  @Test
  public void testAccumulatedProductionInArea() throws FileNotFoundException {

    int itemCode = 8;
    int elementCode = 4;

    Double sum = aInArea.execute(-100.0, -100.0, 100.0, 100.0, itemCode, elementCode, 1980,
        container, geoData);

    assertEquals(200, sum);
  }
}

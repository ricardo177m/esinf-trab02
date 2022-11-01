package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;

public class ClosestProductionAreaTest {
  private static Container container;
  private static List<Map<String, String>> geoData;

  @BeforeAll
  public static void setup() {
    container = (new MockContainer()).mockByName();

    geoData = new ArrayList<>();
    geoData.add(Map.of("area", "Portugal", "latitude", "39.3999", "longitude", "-8.2245"));
    geoData.add(Map.of("area", "Spain", "latitude", "40.4637", "longitude", "-3.7492"));
  }

  @Test
  public void testClosestProductionArea() {
    Area expected = new AreaByCode(100, 200, "Portugal");

    ClosestProductionArea closestProductionArea = new ClosestProductionArea();

    Area actual =
        closestProductionArea.execute(40, -8, "Item 1", "Element 2", 1980, container, geoData);

    assertEquals(0, actual.compareTo(expected));
  }

  @Test
  public void testClosestProductionAreaSecondExample() {
    Area expected = new AreaByCode(200, 300, "Spain");

    ClosestProductionArea closestProductionArea = new ClosestProductionArea();

    Area actual =
        closestProductionArea.execute(40, -4, "Item 1", "Element 2", 1980, container, geoData);

    assertEquals(0, actual.compareTo(expected));
  }

  @Test
  public void testClosestProductionAreaWithInvalidFilter() {
    ClosestProductionArea closestProductionArea = new ClosestProductionArea();
    Area actual =
        closestProductionArea.execute(40, -4, "Item 8", "Element 7", 2020, container, geoData);

    assertNull(actual);
  }
}

package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.mock.MockGeoData;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;

public class ClosestProductionAreaTest {
  private static Container container;
  private static List<Map<String, String>> geoData;

  @BeforeAll
  public static void setup() {
    container = (new MockContainer()).mockByName();

    geoData = (new MockGeoData()).mock();
  }

  @Test
  public void testClosestProductionArea() {
    Area expected = new AreaByCode(100, "200", "Portugal");

    ClosestProductionArea closestProductionArea = new ClosestProductionArea();

    Area actual = closestProductionArea.execute(40, -8, "Item 1", "Element 2", 1980, container, geoData);

    assertEquals(0, actual.compareTo(expected));
  }

  @Test
  public void testClosestProductionAreaSecondExample() {
    Area expected = new AreaByCode(200, "300", "Spain");

    ClosestProductionArea closestProductionArea = new ClosestProductionArea();

    Area actual = closestProductionArea.execute(40, -4, "Item 1", "Element 2", 1980, container, geoData);

    assertEquals(0, actual.compareTo(expected));
  }

  @Test
  public void testClosestProductionAreaWithInvalidFilter() {
    ClosestProductionArea closestProductionArea = new ClosestProductionArea();
    Area actual = closestProductionArea.execute(40, -4, "Item 8", "Element 7", 2020, container, geoData);

    assertNull(actual);
  }

  @Test
  public void testClosestProductionAreaWithInvalidGeoData() {
    ClosestProductionArea closestProductionArea = new ClosestProductionArea();
    Area actual = closestProductionArea.execute(40, -4, "Item 1", "Element 2", 1980, container, null);

    assertNull(actual);
  }

  @Test
  public void testClosestProductionAreaWithInvalidContainer() {
    ClosestProductionArea closestProductionArea = new ClosestProductionArea();
    Area actual = closestProductionArea.execute(40, -4, "Item 1", "Element 2", 1980, null, geoData);

    assertNull(actual);
  }
}

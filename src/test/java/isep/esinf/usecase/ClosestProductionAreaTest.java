package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.mock.MockGeoData;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByName;
import isep.esinf.shared.Constants;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.PropertiesUtils;

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

  @Test
  public void testClosestProductionAreaWithHugeFile() throws FileNotFoundException {
    Properties props = PropertiesUtils.getProperties();
    String dataPath = props.getProperty(Constants.PARAMS_DATA_FOLDER_PATH);
    String checkEnable = props.getProperty(Constants.PARAMS_ENABLE_BIG_TEST);

    if (checkEnable == null || !checkEnable.toLowerCase().equals("yes")) {
      System.out.println("Skipping big test.");
      return;
    }

    CSVReader csvReader = new CSVReader(dataPath + Constants.DATAFILE_WORLD_LARGE);
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) / 1000 + "s");

    start = Instant.now();
    Container container = LoadData.execute(data, AreaByName.class, ItemByName.class, ElementByName.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) / 1000 + "s");

    start = Instant.now();
    csvReader = new CSVReader(dataPath + Constants.DATAFILE_AREA_COORDINATES);
    List<Map<String, String>> geoData = csvReader.read();
    end = Instant.now();
    System.out
        .println("Time to read coordinates CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    // Area: code; Item: code; Element: code
    start = Instant.now();
    Area result = new ClosestProductionArea().execute(40, -8, "Olives", "Yield", 1985, container, geoData);
    end = Instant.now();
    System.out.println("Time to find closest area: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    // file has 2807800 lines without the header
    // 211 valid areas
    assertEquals("Portugal", result.getArea());
  }
}

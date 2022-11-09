package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByName;
import isep.esinf.shared.Constants;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.PropertiesUtils;

public class BigFilesByNameTest {
  static Properties props;
  static Container loadedByName;
  static List<Map<String, String>> geoData;
  static boolean isEnabled = true;

  @BeforeAll
  public static void setup() throws FileNotFoundException {
    props = PropertiesUtils.getProperties();
    String dataPath = props.getProperty(Constants.PARAMS_DATA_FOLDER_PATH);
    String checkEnable = props.getProperty(Constants.PARAMS_ENABLE_BIG_TEST);

    if (checkEnable == null || !checkEnable.toLowerCase().equals("yes")) {
      System.out.println("Skipping big tests.");
      isEnabled = false;
      return;
    }

    System.out.println("Setting up big files by name tests...");

    CSVReader csvReader = new CSVReader(dataPath + Constants.DATAFILE_WORLD_LARGE);

    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();

    System.out.println("  > Read data CSV file -> Elapsed time: "
        + (end.toEpochMilli() - start.toEpochMilli()) / 1000 + "s");

    csvReader = new CSVReader(dataPath + Constants.DATAFILE_AREA_COORDINATES);
    start = Instant.now();
    geoData = csvReader.read();
    end = Instant.now();
    System.out.println("  > Read geoData file -> Elapsed time: "
        + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    LoadData ld = new LoadData();

    // Area: name; Item: name; Element: name
    start = Instant.now();
    loadedByName = ld.execute(data, AreaByName.class, ItemByName.class, ElementByName.class);
    end = Instant.now();
    System.out.println("  > LoadData (by name) -> Elapsed time: "
        + (end.toEpochMilli() - start.toEpochMilli()) / 1000 + "s");
  }

  /**
   * * LoadData Test if the data loader is capable of loading a big dataset.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testLoadTonsOfData() throws FileNotFoundException {
    if (!isEnabled)
      return;

    System.out.println("Test LoadData > Big File");
    System.out.println("  > Data has already been loaded, gonna assert.");

    // file has 2807800 lines without the header
    // 211 valid areas
    assertEquals(211, loadedByName.getNOfAreas());
  }

  /**
   * * ClosestProductionArea
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testClosestProductionAreaWithMediumFile() throws FileNotFoundException {
    if (!isEnabled)
      return;

    System.out.println("Test ClosestProductionArea > Medium File");

    ClosestProductionArea closestProductionArea = new ClosestProductionArea();
    Instant start = Instant.now();
    Area actual =
        closestProductionArea.execute(0, 20, "Avocados", "Area harvested", 1997, loadedByName, geoData);
    Instant end = Instant.now();
    System.out.println(
        "  > execute() -> Elapsed time: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");

    assertEquals("Congo", actual.getArea());
  }

  /**
   * ClosestProductionArea
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testClosestProductionAreaWithHugeFile() throws FileNotFoundException {
    if (!isEnabled)
      return;

    System.out.println("Test ClosestProductionArea > Big File");

    Instant start = Instant.now();
    Area result =
        new ClosestProductionArea().execute(40, -8, "Olives", "Yield", 1985, loadedByName, geoData);
    Instant end = Instant.now();
    System.out.println(
        "  > execute() -> Elapsed time: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals("Portugal", result.getArea());
  }
}

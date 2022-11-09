package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.shared.Constants;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.PropertiesUtils;

public class BigFilesByCodeTest {
  static Properties props;
  static Container loadedByCode;
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

    System.out.println("Setting up big files by code tests...");

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

    // Area: Code Item: Code Element: Code
    LoadData ld = new LoadData();
    start = Instant.now();
    loadedByCode = ld.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("  > LoadData (by code) -> Elapsed time: "
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
    assertEquals(211, loadedByCode.getNOfAreas());
  }

  /**
   * * AccumulatedProductionInArea Test the sum of production with data from big file
   */
  @Test
  public void testSumProductionWithFileBigFile() throws FileNotFoundException {
    if (!isEnabled)
      return;

    System.out.println("Test AccumulatedProductionInArea > Big File");

    int itemCode = 1062;
    int elementCode = 5313;

    AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();
    Instant start = Instant.now();
    Double sum =
        aInArea.execute(-1000, -1000, 1000, 1000, itemCode, elementCode, 1977, loadedByCode, geoData);
    Instant end = Instant.now();
    System.out.println(
        "  > execute() -> Elapsed time: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals(2870292.0, sum);
  }
}

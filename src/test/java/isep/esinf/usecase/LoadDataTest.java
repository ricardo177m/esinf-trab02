package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import isep.esinf.mock.MockContainer;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.model.comparators.ItemByName;
import isep.esinf.shared.Constants;
import isep.esinf.utils.CSVReader;
import isep.esinf.utils.PropertiesUtils;

public class LoadDataTest {
  Container container;

  @BeforeEach
  public void setup() {
    // create a container with elements to sanitize
    container = (new MockContainer()).mockByCodeMini();
  }

  /**
   * Test the load of data from a CSV file.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testSimillarContainersExtraMiniDataset() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_extramini.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    container = (new MockContainer()).mockByCodeExtraMini();

    // Area: code; Item: code; Element: code
    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals(container, loaded);
  }

  /**
   * Test if the data loader is creating the correct container by loading a
   * dataset that represents the mock data.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testMiniDataset() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_mini.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    // Area: code; Item: code; Element: code
    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals(container, loaded);
  }

  /**
   * Test if the loaded data is different from the container with elements to
   * sanitize.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testDifferentContainers() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/not_mock_mini.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    // Area: code; Item: code; Element: code
    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    assertNotEquals(container, loaded);
  }

  /**
   * Test the loading of a CSV file with no data in it.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testEmpty() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/only_headers.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    Container c = new Container();

    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals(c, loaded);
  }

  /**
   * Test if the data loader is creating the correct container by loading a
   * dataset that represents the mock data by name.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testLoadByNameMiniDataset() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_mini.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    container = (new MockContainer()).mockByNameMini();

    // Area: name; Item: name; Element: name
    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByName.class, ItemByName.class, ElementByName.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals(container, loaded);
  }

  /**
   * Test if the data loader is actually inserting by name/code, where the trees
   * will have a different format.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testTreesWithDifferentFormats() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_mini.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    container = (new MockContainer()).mockByNameMini();

    // Area: code; Item: code; Element: code
    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertNotEquals(container, loaded);
  }

  /**
   * Test if the data loader is ignoring lines which have the "missing value"
   * flag.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testLoadByNameMiniWithMissingValueFlags() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_mini_missing_value_flag.csv");
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    container = (new MockContainer()).mockByCodeMiniVersionMissingFlags();

    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    assertEquals(container, loaded);
  }

  /**
   * Test if the data loader is capable of loading a big dataset.
   * ! WARNING: This test takes a long time to run.
   *
   * @throws FileNotFoundException
   */
  @Test
  public void testLoadTonsOfData() throws FileNotFoundException {
    Properties props = PropertiesUtils.getProperties();
    String dataPath = props.getProperty(Constants.PARAMS_DATA_FOLDER_PATH);

    CSVReader csvReader = new CSVReader(dataPath + Constants.DATAFILE_WORLD_LARGE);
    Instant start = Instant.now();
    List<Map<String, String>> data = csvReader.read();
    Instant end = Instant.now();
    System.out.println("Time to read CSV file: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    // Area: code; Item: code; Element: code
    start = Instant.now();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);
    end = Instant.now();
    System.out.println("Time to load data: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");

    // file has 2807800 lines without the header
    // 211 valid areas
    assertEquals(211, loaded.getNOfAreas());
  }
}

package isep.esinf.usecase;

import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.utils.CSVReader;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;

public class LoadDataTest {
  Container container;

  @BeforeEach
  public void setup() {
    // create a container with elements to sanitize
    container = (new MockContainer()).mockByCodeMini();
  }

  @Test
  public void testSimillarContainersExtraMiniDataset() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_extramini.csv");
    List<Map<String, String>> data = csvReader.read();

    container = (new MockContainer()).mockByCodeExtraMini();

    // Area: code;  Item: code;  Element: code
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    assertEquals(container, loaded);
  }

  @Test
  public void testSimillarContainersMiniDataset() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mock_mini.csv");
    List<Map<String, String>> data = csvReader.read();

    // Area: code;  Item: code;  Element: code
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    assertEquals(container, loaded);
  }

  @Test
  public void testDifferentContainers() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/not_mock_mini.csv");
    List<Map<String, String>> data = csvReader.read();

    // Area: code;  Item: code;  Element: code
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    assertNotEquals(container, loaded);
  }

  @Test
  public void testEmpty() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/only_headers.csv");
    List<Map<String, String>> data = csvReader.read();

    Container c = new Container();
    Container loaded = LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    assertEquals(c, loaded);
  }

  // TODO test with big files
  // TODO test flag Missing Value
}

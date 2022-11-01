package isep.esinf.usecase;

import org.junit.jupiter.api.Test;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.utils.CSVReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;

public class LoadDataTest {
  Container container;

  @BeforeEach
  public void setup() {
    // create a container with elements to sanitize
    container = new Container();
  }

  @Test
  public void test() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader("./src/test/java/isep/esinf/data/mini.csv");
    List<Map<String, String>> data = csvReader.read();

    // Area: code;  Item: code;  Element: code
    LoadData.execute(data, AreaByCode.class, ItemByCode.class, ElementByCode.class);

    // print the container
    System.out.println(container);
  }
}

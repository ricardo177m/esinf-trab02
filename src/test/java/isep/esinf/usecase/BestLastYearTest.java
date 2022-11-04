package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.AreaByCode;
import isep.esinf.model.comparators.ElementByCode;
import isep.esinf.model.comparators.ItemByCode;
import isep.esinf.utils.CSVReader;

public class BestLastYearTest {
  BestLastYear bestLastYear;

  public static Container data;

  Item item;
  Element element;

  @BeforeAll
  public static void setup() throws FileNotFoundException {
    CSVReader csvReader = new CSVReader(
        "./../faodata/TEST_DO_NOT_DELETE.csv");
    List<Map<String, String>> dataList = csvReader.read();

    // Area: code; Item: code; Element: code
    data = LoadData.execute(dataList, AreaByCode.class, ItemByCode.class, ElementByCode.class);
  }

  @Test
  public void testWithRootsAndProduction() {
    item = new ItemByCode(1720, "F1720", "Roots and Tubers, Total");
    element = new ElementByCode(5510, "Production");

    bestLastYear = new BestLastYear(data, item, element);

    ArrayList<Area> actual = bestLastYear.execute(1);

    ArrayList<Area> expected = new ArrayList<>();
    // Area france = new AreaByCode(68, "'250", "France");
    Area germany = new AreaByCode(79, "'276", "Germany");
    // Area italy = new AreaByCode(106, "'380", "Italy");
    // Area spain = new AreaByCode(203, "'724", "Spain");
    // Area portugal = new AreaByCode(174, "'620", "Portugal");

    expected.add(germany);

    assertEquals(expected.toString(), actual.toString());
  }
}

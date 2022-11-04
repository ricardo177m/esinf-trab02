package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
        "./src/test/java/isep/esinf/data/Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv");
    List<Map<String, String>> dataList = csvReader.read();

    // Area: code; Item: code; Element: code
    data = LoadData.execute(dataList, AreaByCode.class, ItemByCode.class, ElementByCode.class);
  }

  @Test
  public void testWithMockByCodeAndN1() {
    item = new ItemByCode(1, "2", "Item 1");
    element = new ElementByCode(1, "Element 1");

    bestLastYear = new BestLastYear(data, item, element);

    ArrayList<Area> actual = bestLastYear.execute(1);

    ArrayList<Area> expected = new ArrayList<>();

    assertEquals(expected, actual);
  }
}

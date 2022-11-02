package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CSVReaderTest {
  @Test
  public void testReaderWorks() throws FileNotFoundException {
    List<? extends Map<String, String>> l = new ArrayList<HashMap<String, String>>();
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/test.csv");

    l = r.read();

    HashMap<String, String> map = new HashMap<String, String>();
    List<HashMap<String, String>> expected = new ArrayList<HashMap<String, String>>();

    map.put("key1", "123");
    map.put("key2", "456");
    map.put("key3", "789");
    expected.add(map);

    map = new HashMap<String, String>();
    map.put("key1", "abc");
    map.put("key2", "def");
    map.put("key3", "ghi");
    expected.add(map);

    assertEquals(expected, l);
  }

  @Test
  public void testThrowsWithInvalidFile() {
    assertThrows(FileNotFoundException.class, () -> {
      new CSVReader("invalidFilePath.csv");
    });
  }

  @Test
  public void testWithEmptyFile() throws FileNotFoundException {
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/EmptyFile.csv");
    List<? extends Map<String, String>> l = r.read();

    assertEquals(new ArrayList<>(), l);
  }

  @Test
  public void testWithOneLineFile() throws FileNotFoundException {
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/EmptyFile.csv");
    List<? extends Map<String, String>> l = r.read();

    List<HashMap<String, String>> expected = new ArrayList<HashMap<String, String>>();

    assertEquals(expected, l);
  }

  @Test
  public void testReadsNotAvailableDataFile() throws FileNotFoundException {
    List<? extends Map<String, String>> l = new ArrayList<HashMap<String, String>>();
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/testWithNotAvailableData.csv");

    l = r.read();

    HashMap<String, String> map = new HashMap<String, String>();
    List<HashMap<String, String>> expected = new ArrayList<HashMap<String, String>>();

    map.put("Domain Code", "QCL");
    map.put("Domain", "Crops and livestock products");
    map.put("Element Code", "5510");
    map.put("Element", "Production");
    map.put("Area Code (FAO)", "18");
    map.put("Area", "Bhutan");
    map.put("Item Code (FAO)", "486");
    map.put("Item", "Bananas");
    map.put("Year Code", "1964");
    map.put("Year", "1964");
    map.put("Value", "");
    map.put("Unit", "tonnes");
    map.put("Flag", "M");
    map.put("Flag Description", "Data not available");
    expected.add(map);

    map = new HashMap<String, String>();
    map.put("Domain Code", "QCL");
    map.put("Domain", "Crops and livestock products");
    map.put("Area Code (FAO)", "18");
    map.put("Element Code", "5510");
    map.put("Item Code (FAO)", "486");
    map.put("Element", "Production");
    map.put("Area", "Bhutan");
    map.put("Item", "Bananas");
    map.put("Year Code", "1965");
    map.put("Year", "1965");
    map.put("Value", "");
    map.put("Unit", "tonnes");
    map.put("Flag", "M");
    map.put("Flag Description", "Data not available");
    expected.add(map);

    assertEquals(expected, l);
  }

  @Test
  public void testReadWorksWithCommasBetweenQuotes() throws FileNotFoundException {
    List<? extends Map<String, String>> l = new ArrayList<HashMap<String, String>>();
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/testWithCommasBetweenQuotes.csv");

    l = r.read();

    HashMap<String, String> map = new HashMap<String, String>();
    List<HashMap<String, String>> expected = new ArrayList<HashMap<String, String>>();

    map.put("key1", "12,3");
    map.put("key2", "4,56");
    map.put("key3", "789");
    expected.add(map);

    map = new HashMap<String, String>();
    map.put("key1", "ab,c");
    map.put("key2", "def");
    map.put("key3", "g,hi");
    expected.add(map);

    assertEquals(expected, l);
  }

  @Test
  public void testReadWorksWithCommasBetweenQuotesAndEmptyValues() throws FileNotFoundException {
    List<? extends Map<String, String>> l = new ArrayList<HashMap<String, String>>();
    CSVReader r = new CSVReader("./src/test/java/isep/esinf/data/emptyFields.csv");

    l = r.read();

    HashMap<String, String> map = new HashMap<String, String>();
    List<HashMap<String, String>> expected = new ArrayList<HashMap<String, String>>();

    map.put("Area Code", "68");
    map.put("Item", "Pro,du,ction");
    map.put("AaAA", "");
    map.put("\"gaagda\"", "");
    map.put("f", "A");
    expected.add(map);

    map = new HashMap<String, String>();
    map.put("Area Code", "1");
    map.put("Item", "'3");
    map.put("AaAA", "Italy");
    map.put("\"gaagda\"", "1");
    map.put("f", "'2");
    expected.add(map);

    assertEquals(expected, l);
  }
}

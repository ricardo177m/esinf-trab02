package isep.esinf.utils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Flags reader.
 *
 * @author Ricardo Moreira <1211285@isep.ipp.pt>
 */
public class FlagReader {
  private CSVReader csvreader;
  private Map<String, String> flags;
  private String missingValueFlag;

  private final String MISSING_VALUE_TRIGGER = "data cannot exist";

  public enum Field {
    FLAG("Flag"), DESCRIPTION("Description");

    public final String name;

    Field(String name) {
      this.name = name;
    }
  }

  /**
   * Flag reader constructor.
   *
   * @throws FileNotFoundException
   */
  public FlagReader(String filepath) throws FileNotFoundException {
    csvreader = new CSVReader(filepath);
    missingValueFlag = null;
  }

  public void read() {
    flags = new HashMap<>();
    List<Map<String, String>> data = csvreader.read();
    for (Map<String, String> line : data) {
      String flag = line.get(Field.FLAG.name);
      String desc = line.get(Field.DESCRIPTION.name);
      flags.put(flag, desc);
      if (desc.contains(MISSING_VALUE_TRIGGER))
        missingValueFlag = flag;
    }
  }

  public boolean hasFlag(String flag) {
    if (flags == null)
      throw new NullPointerException("Flags map is null (you probably want to call read() first)");
    return !(flags.get(flag) == null);
  }

  public String getFlagDesc(String flag) {
    if (flags == null)
      throw new NullPointerException("Flags map is null (you probably want to call read() first)");
    return flags.get(flag);
  }

  public String getMissingValueFlag() {
    return missingValueFlag;
  }
}

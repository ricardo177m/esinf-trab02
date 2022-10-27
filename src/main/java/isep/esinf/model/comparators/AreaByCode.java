package isep.esinf.model.comparators;

import java.util.Comparator;
import isep.esinf.model.Area;

public class AreaByCode implements Comparator<Area> {
  @Override
  public int compare(Area a1, Area a2) {
    return a2.getCode() - a1.getCode();
  }
}

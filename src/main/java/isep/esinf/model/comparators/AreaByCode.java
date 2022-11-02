package isep.esinf.model.comparators;

import isep.esinf.model.Area;

public class AreaByCode extends Area {
  public AreaByCode(int code, String m49Code, String name) {
    super(code, m49Code, name);
  }

  @Override
  public int compareTo(Area o) {
    return this.getCode() - o.getCode();
  }
}

package isep.esinf.model.comparators;

import isep.esinf.model.Area;

public class AreaByM49 extends Area {
  public AreaByM49(int code, int m49Code, String name) {
    super(code, m49Code, name);
  }

  @Override
  public int compareTo(Area o) {
    return this.getM49Code() - o.getM49Code();
  }
}

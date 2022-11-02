package isep.esinf.model.comparators;

import isep.esinf.model.Area;

public class AreaByName extends Area {
  public AreaByName(int code, String m49Code, String name) {
    super(code, m49Code, name);
  }

  @Override
  public int compareTo(Area o) {
    return this.getArea().compareTo(o.getArea());
  }
}

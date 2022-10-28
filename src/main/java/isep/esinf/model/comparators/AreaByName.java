package isep.esinf.model.comparators;

import isep.esinf.model.Area;

public class AreaByName extends Area {
  public AreaByName(String name, int code, int m49Code) {
    super(name, code, m49Code);
  }

  @Override
  public int compareTo(Area o) {
    return this.getArea().compareTo(o.getArea());
  }
}

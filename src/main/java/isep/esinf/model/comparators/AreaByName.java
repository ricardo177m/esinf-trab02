package isep.esinf.model.comparators;

import isep.esinf.model.Area;

public class AreaByName extends Area {
  public AreaByName(int code, int m49Code, String name) {
    super(code, m49Code, name);
  }

  @Override
  public int compareTo(Area o) {
    if (this.getArea().compareTo(o.getArea()) == 0) {
      return 0;
    }

    if (this.getArea().compareTo(o.getArea()) < 0) {
      return -1;
    }

    if (this.getArea().compareTo(o.getArea()) > 0) {
      return 1;
    }

    return 0;
  }
}

package isep.esinf.model.comparators;

import isep.esinf.model.Element;

public class ElementByName extends Element {
  public ElementByName(int code, String element) {
    super(code, element);
  }

  @Override
  public int compareTo(Element o) {
    if (this.getElement().compareTo(o.getElement()) < 0) {
      return -1;
    } else if (this.getElement().compareTo(o.getElement()) > 0) {
      return 1;
    } else {
      return 0;
    }
  }
}

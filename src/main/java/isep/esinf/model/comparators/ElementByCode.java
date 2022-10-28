package isep.esinf.model.comparators;

import isep.esinf.model.Element;

public class ElementByCode extends Element {
  public ElementByCode(int code, String element) {
    super(code, element);
  }

  @Override
  public int compareTo(Element o) {
    return this.getCode() - o.getCode();
  }
}

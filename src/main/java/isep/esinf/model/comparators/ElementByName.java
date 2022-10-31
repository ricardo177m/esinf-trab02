package isep.esinf.model.comparators;

import isep.esinf.model.Element;

public class ElementByName extends Element {
  public ElementByName(int code, String element) {
    super(code, element);
  }

  @Override
  public int compareTo(Element o) {
    return this.getElement().compareTo(o.getElement());
  }
}

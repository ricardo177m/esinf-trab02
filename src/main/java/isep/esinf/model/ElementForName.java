package isep.esinf.model;

public class ElementForName extends Element {
  public ElementForName(int code, String element) {
    super(code, element);
  }

  @Override
  public int compareTo(Element o) {
    return this.getElement().compareTo(o.getElement());
  }
}

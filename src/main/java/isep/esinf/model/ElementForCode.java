package isep.esinf.model;

public class ElementForCode extends Element {
  public ElementForCode(int code, String element) {
    super(code, element);
  }

  @Override
  public int compareTo(Element o) {
    return this.getCode() - o.getCode();
  }
}

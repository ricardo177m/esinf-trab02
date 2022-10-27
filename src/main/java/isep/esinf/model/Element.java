package isep.esinf.model;

public class Element {
  private int code;
  private String designation;

  public Element(int code, String designation) {
    this.code = code;
    this.designation = designation;
  }

  public int getCode() {
    return code;
  }

  public String getDesignation() {
    return designation;
  }

  @Override
  public String toString() {
    return String.format("Element %s w/ code %d\n", designation, code);
  }
}

package isep.esinf.model;

public class AreaForName extends Area {
  public AreaForName(String name, int code, int m49Code) {
    super(name, code, m49Code);
  }

  @Override
  public int compareTo(Area o) {
    return this.getArea().compareTo(o.getArea());
  }
}

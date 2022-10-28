package isep.esinf.model;

public class AreaForCode extends Area {
  public AreaForCode(String name, int code, int m49Code) {
    super(name, code, m49Code);
  }

  @Override
  public int compareTo(Area o) {
    return this.getCode() - o.getCode();
  }
}

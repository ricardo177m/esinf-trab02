package isep.esinf.model;

public class Area implements Comparable<Area> {
  private String country;
  private int code;
  private int codeM49;

  public Area(String country, int code, int codeM49) {
    this.code = code;
    this.codeM49 = codeM49;
    this.country = country;
  }

  // getters
  public int getCode() {
    return code;
  }

  public int getCodeM49() {
    return codeM49;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return String.format("Area %s w/ code %d & code M49 %d\n", country, code, codeM49);
  }

  @Override
  public int compareTo(Object o) {
    // TODO
    return 0;
  }

  @Override
  public int compareTo(Area a) {
    // TODO
    return 0;
  }
}

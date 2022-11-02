package isep.esinf.model;

public class ProductionData implements Comparable<ProductionData> {
  private int year;
  private double value;
  private String unit;
  private String flag;

  public ProductionData(int year, double value, String unit, String flag) {
    this.year = year;
    this.value = value;
    this.unit = unit;
    this.flag = flag;
  }

  public ProductionData(int year) {
    this.year = year;
  }

  public int getYear() {
    return year;
  }

  public double getValue() {
    return value;
  }

  public String getUnit() {
    return unit;
  }

  public String getFlag() {
    return flag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ProductionData that = (ProductionData) o;

    return year == that.year;
  }

  @Override
  public int compareTo(ProductionData o) {
    return this.getYear() - o.getYear();
  }

  @Override
  public String toString() {
    return "ProductionData{" + "year=" + year + ", value=" + value + '}';
  }
}

package isep.esinf.model;

public class ProductionData implements Comparable<ProductionData> {
  private int year;
  private Value value;

  public ProductionData(int year, Value value) {
    this.year = year;
    this.value = value;
  }

  public ProductionData(int year) {
    this.year = year;
  }

  public int getYear() {
    return year;
  }

  public double getValue() {
    return value.getValue();
  }

  public String getUnit() {
    return value.getUnit();
  }

  public String getFlag() {
    return value.getFlag();
  }

  public ProductionData clone() {
    return new ProductionData(year, value.clone());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ProductionData that = (ProductionData) o;

    if (year != that.year)
      return false;

    // different
    if (value == null ^ that.value == null)
      return false;

    // both null
    if (value == null && that.value == null)
      return true;

    return value.equals(that.value);
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

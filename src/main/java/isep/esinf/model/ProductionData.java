package isep.esinf.model;

public class ProductionData implements Comparable<ProductionData> {
  private int year;
  private double value;

  public ProductionData(int year, double value) {
    this.year = year;
    this.value = value;
  }

  public int getYear() {
    return year;
  }

  public double getValue() {
    return value;
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

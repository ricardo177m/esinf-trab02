package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Element implements Comparable<Element> {
  private int code;
  private String element;
  private BST<ProductionData> productionData;

  public Element(int code, String element) {
    this.code = code;
    this.element = element;
    this.productionData = new AVL<>();
  }

  public int getCode() {
    return code;
  }

  public String getElement() {
    return element;
  }

  public void addProductionData(ProductionData data) {
    productionData.insert(data);
  }

  public ProductionData getProductionData(int year) {
    return productionData.find(new ProductionData(year));
  }

  public int getMostRecentYear() {
    return productionData.biggestElement().getYear();
  }

  public abstract int compareTo(Element o);

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (getClass() != obj.getClass())
      return false;

    final Element other = (Element) obj;

    if (this.code != other.code)
      return false;

    if (this.element == null || other.element == null)
      return false;

    if (!this.element.equals(other.element))
      return false;

    return true;
  }

  @Override
  public String toString() {
    return "Element{" + "code=" + code + ", element=" + element + '}';
  }
}

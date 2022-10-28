package isep.esinf.model;

import isep.esinf.utils.BST;

public abstract class Element implements Comparable<Element> {
  private int code;
  private String element;
  private BST<ProductionData> productionData;

  public Element(int code, String element) {
    this.code = code;
    this.element = element;
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

  public abstract int compareTo(Element o);

  @Override
  public String toString() {
    return "Element{" + "code=" + code + ", element=" + element + '}';
  }
}

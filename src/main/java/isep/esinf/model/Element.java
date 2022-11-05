package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;
import isep.esinf.utils.Node;

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

  public Element clone() {
    try {
      Element clonedElement = (Element) getClass().getConstructors()[0].newInstance(code, element);
      clonedElement.productionData = productionData.clone();

      return clonedElement;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
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

    if (!this.productionData.equals(other.productionData))
      return false;

    return true;
  }

  @Override
  public String toString() {
    return "Element{" + "code=" + code + ", element=" + element + '}';
  }

  public double valueSumTimeInterval(int min, int max) {
    return valueSumTimeInterval(productionData.root(), min, max);
  }

  public double valueSumTimeInterval(Node<ProductionData> node, int min, int max) {

    if (node == null) {
      return 0;
    }

    if (node.getElement().getYear() >= min && node.getElement().getYear() <= max) {
      return node.getElement().getValue() +
          valueSumTimeInterval(node.getLeft(), min, max) +
          valueSumTimeInterval(node.getRight(), min, max);
    } else if (node.getElement().getYear() < min) {
      return valueSumTimeInterval(node.getRight(), min, max);
    } else {
      return valueSumTimeInterval(node.getLeft(), min, max);
    }
  }

}

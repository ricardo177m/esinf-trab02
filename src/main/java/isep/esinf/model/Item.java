package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Item implements Comparable<Item> {
  private int code;
  private int cpr;
  private String item;
  private BST<Element> elements;

  public Item(int code, int cpr, String item) {
    this.code = code;
    this.cpr = cpr;
    this.item = item;
    this.elements = new AVL<>();
  }

  public int getCode() {
    return code;
  }

  public int getCpr() {
    return cpr;
  }

  public String getItem() {
    return item;
  }

  public void addElement(Element element) {
    elements.insert(element);
  }

  public Element getElement(Element element) {
    return elements.find(element);
  }

  public abstract int compareTo(Item o);

  @Override
  public String toString() {
    return "Item{" + "code=" + code + ", cpr=" + cpr + ", item=" + item + '}';
  }
}

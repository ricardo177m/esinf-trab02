package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Item implements Comparable<Item> {
  private int code;
  private String cpc;
  private String item;
  private BST<Element> elements;

  public Item(int code, String cpc, String item) {
    this.code = code;
    this.cpc = cpc;
    this.item = item;
    this.elements = new AVL<>();
  }

  public int getCode() {
    return code;
  }

  public String getCpc() {
    return cpc;
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

  public Item clone() {
    try {
      Item clonedItem = (Item) getClass().getConstructors()[0].newInstance(code, cpc, item);
      clonedItem.elements = elements.clone();

      return clonedItem;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (getClass() != obj.getClass())
      return false;

    final Item other = (Item) obj;

    if (this.code != other.code)
      return false;

    if (!this.cpc.equals(other.cpc))
      return false;

    if (this.item == null || other.item == null)
      return false;

    if (!this.item.equals(other.item))
      return false;

    if (!this.elements.equals(other.elements))
      return false;

    return true;
  }

  @Override
  public String toString() {
    return "Item{" + "code=" + code + ", cpc=" + cpc + ", item=" + item + '}';
  }

  public Iterable<Element> getElements() {
    return elements.inOrder();
  }

}

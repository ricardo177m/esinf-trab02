package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Area implements Comparable<Area> {
  private String area;
  private int code;
  private int m49Code;
  private BST<Item> items;

  public Area(String name, int code, int m49Code) {
    this.area = name;
    this.code = code;
    this.m49Code = m49Code;
    this.items = new AVL<>();
  }

  public String getArea() {
    return area;
  }

  public int getCode() {
    return code;
  }

  public int getM49Code() {
    return m49Code;
  }

  public void addItem(Item item) {
    items.insert(item);
  }

  public Item getItem(Item item) {
    return items.find(item);
  }

  public abstract int compareTo(Area o);

  @Override
  public String toString() {
    return "Area{" + "name=" + area + ", code=" + code + ", m49Code=" + m49Code + '}';
  }
}

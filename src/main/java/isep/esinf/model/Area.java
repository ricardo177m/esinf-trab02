package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Area implements Comparable<Area> {
  private String area;
  private int code;
  private int m49Code;
  private BST<Item> items;

  public Area(int code, int m49Code, String name) {
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
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Area other = (Area) obj;

    if (this.area == null || other.area == null)
      return false;

    if (!this.area.equals(other.area))
      return false;

    if (this.code != other.code)
      return false;

    if (this.m49Code != other.m49Code)
      return false;

    return true;
  }

  @Override
  public String toString() {
    return "Area{" + "name=" + area + ", code=" + code + ", m49Code=" + m49Code + '}';
  }
}

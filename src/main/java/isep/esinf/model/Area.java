package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Area implements Comparable<Area> {
  private String area;
  private int code;
  private String m49Code;
  private BST<Item> items;

  public Area(int code, String m49Code, String name) {
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

  public String getM49Code() {
    return m49Code;
  }

  public void addItem(Item item) {
    items.insert(item);
  }

  public Item getItem(Item item) {
    return items.find(item);
  }

  public abstract int compareTo(Area o);

  public Area clone() {
    try {
      // for some reason getDeclaredConstructor() is not working in class Area
      // by using getConstructors()[0] instead, it works with the same result
      Area clonedArea = (Area) getClass().getConstructors()[0].newInstance(code, m49Code, area);
      clonedArea.items = items.clone();

      return clonedArea;
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

    final Area other = (Area) obj;

    if (this.area == null || other.area == null)
      return false;

    if (!this.area.equals(other.area))
      return false;

    if (this.code != other.code)
      return false;

    if (!this.m49Code.equals(other.m49Code))
      return false;

    if (!this.items.equals(other.items))
      return false;

    return true;
  }

  @Override
  public String toString() {
    return "Area{" + "name=" + area + ", code=" + code + ", m49Code=" + m49Code + '}';
  }
}

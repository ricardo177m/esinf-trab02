package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public abstract class Area implements Comparable<Area> {
  private String area;
  private int code;
  private int m49Code;
  private BST<Item> productions;

  public Area(String name, int code, int m49Code) {
    this.area = name;
    this.code = code;
    this.m49Code = m49Code;
    this.productions = new AVL<>();
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

  public BST<Item> getProductions() {
    return productions;
  }

  public void addProduction(Item production) {
    productions.insert(production);
  }

  public abstract int compareTo(Area o);

  @Override
  public String toString() {
    return "Area{" + "name=" + area + ", code=" + code + ", m49Code=" + m49Code + '}';
  }
}

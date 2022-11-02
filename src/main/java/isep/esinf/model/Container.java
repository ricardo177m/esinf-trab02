package isep.esinf.model;

import isep.esinf.utils.AVL;
import isep.esinf.utils.BST;

public class Container {
  private BST<Area> areas;

  public Container() {
    this.areas = new AVL<>();
  }

  public void addArea(Area area) {
    areas.insert(area);
  }

  public Area getArea(Area area) {
    return areas.find(area);
  }

  public Iterable<Area> getAreas() {
    return areas.inOrder();
  }

  public int getNOfAreas() {
    return areas.size();
  }

  public boolean isEmpty() {
    return areas.isEmpty();
  }

  public Container getAreasWithConditions(Item item, Element element) {
    Container areasWithItem = new Container();

    Iterable<Area> a = areas.inOrder();

    // TODO optimize this (is starting allways from the root)
    for (Area area : a) {
      Item i = area.getItem(item);
      if (i == null)
        continue;

      Element e = i.getElement(element);
      if (e == null)
        continue;

      areasWithItem.addArea(area);
    }

    return areasWithItem;
  }

  public Container getAreasWithConditions(Item item, Element element, int year) {
    Container areasWithItem = new Container();

    Iterable<Area> a = areas.inOrder();

    // TODO optimize this (is starting allways from the root)
    for (Area area : a) {
      Item i = area.getItem(item);
      if (i == null)
        continue;

      Element e = i.getElement(element);
      if (e == null)
        continue;

      ProductionData p = e.getProductionData(year);
      if (p == null)
        continue;

      areasWithItem.addArea(area);
    }

    return areasWithItem;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Container container = (Container) o;

    if (areas == null && container.areas == null)
      return true;

    boolean result = areas.equals(container.areas);
    return result;
  }
}

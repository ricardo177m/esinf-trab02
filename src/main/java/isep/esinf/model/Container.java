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
    Container filteredAreas = new Container();

    for (Area area : areas.inOrder()) {
      Item i = area.getItem(item);
      if (i == null)
        continue;

      Element e = i.getElement(element);
      if (e == null)
        continue;

      filteredAreas.addArea(area);
    }

    return filteredAreas;
  }

  public Container getAreasWithConditions(Item item, Element element, int year) {
    Container filteredAreas = new Container();

    for (Area area : areas.inOrder()) {
      Item i = area.getItem(item);
      if (i == null)
        continue;

      Element e = i.getElement(element);
      if (e == null)
        continue;

      ProductionData p = e.getProductionData(year);
      if (p == null)
        continue;

      filteredAreas.addArea(area);
    }

    return filteredAreas;
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

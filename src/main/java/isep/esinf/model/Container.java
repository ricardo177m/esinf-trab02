package isep.esinf.model;

import java.util.List;
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

  public Container getAreasWithConditions(Item item, Element element, int year) {
    Container areasWithItem = new Container();

    Iterable<Area> a = areas.inOrder();

    // TODO optimize this (is starting allways from the root)
    for (Area area : a) {
      Item i = area.getItem(item);
      if (i == null) continue;

      Element e = i.getElement(element);
      if(e == null) continue;

      ProductionData p = e.getProductionData(year);
      if(p == null) continue;

      areasWithItem.addArea(area);
    }

    return areasWithItem;
  }
}

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

  public BST<Area> getAreas() {
    return areas;
  }
}

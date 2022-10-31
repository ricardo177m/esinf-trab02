package isep.esinf.model.comparators;

import isep.esinf.model.Item;

public class ItemByName extends Item {
  public ItemByName(int code, int cpc, String item) {
    super(code, cpc, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getItem().compareTo(o.getItem());
  }
}

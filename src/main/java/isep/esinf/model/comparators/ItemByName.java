package isep.esinf.model.comparators;

import isep.esinf.model.Item;

public class ItemByName extends Item {
  public ItemByName(int code, int cpc, String item) {
    super(code, cpc, item);
  }

  @Override
  public int compareTo(Item o) {
    if (this.getItem().compareTo(o.getItem()) < 0) {
      return -1;
    } else if (this.getItem().compareTo(o.getItem()) > 0) {
      return 1;
    } else {
      return 0;
    }
  }
}

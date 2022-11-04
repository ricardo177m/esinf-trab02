package isep.esinf.model.comparators;

import isep.esinf.model.Item;

public class ItemByCPC extends Item {
  public ItemByCPC(int code, String cpc, String item) {
    super(code, cpc, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getCpc().compareTo(o.getCpc());
  }
}

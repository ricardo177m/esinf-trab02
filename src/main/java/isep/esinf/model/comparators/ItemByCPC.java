package isep.esinf.model.comparators;

import isep.esinf.model.Item;

public class ItemByCPC extends Item {
  public ItemByCPC(int code, int cpr, String item) {
    super(code, cpr, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getCpc() - o.getCpc();
  }
}

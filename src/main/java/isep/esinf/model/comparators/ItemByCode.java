package isep.esinf.model.comparators;

import isep.esinf.model.Item;

public class ItemByCode extends Item {
  public ItemByCode(int code, int cpc, String item) {
    super(code, cpc, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getCode() - o.getCode();
  }
}

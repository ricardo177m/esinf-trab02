package isep.esinf.model.comparators;

import isep.esinf.model.Item;

public class ItemByCode extends Item {
  public ItemByCode(int code, int cpr, String item) {
    super(code, cpr, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getCode() - o.getCode();
  }
}

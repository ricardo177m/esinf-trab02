package isep.esinf.model;

public class ItemForName extends Item {
  public ItemForName(int code, int cpr, String item) {
    super(code, cpr, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getItem().compareTo(o.getItem());
  }
}

package isep.esinf.model;

public class ItemForCode extends Item {
  public ItemForCode(int code, int cpr, String item) {
    super(code, cpr, item);
  }

  @Override
  public int compareTo(Item o) {
    return this.getCode() - o.getCode();
  }
}

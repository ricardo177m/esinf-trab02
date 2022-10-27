package isep.esinf.model;

public class Item {
  private int code;
  private String codeCPC;
  private String designation;

  public Item(int code, String codeCPC, String designation) {
    this.code = code;
    this.codeCPC = codeCPC;
    this.designation = designation;
  }

  public int getCode() {
    return code;
  }

  public String getCodeCPC() {
    return codeCPC;
  }

  public String getDesignation() {
    return designation;
  }

  @Override
  public String toString() {
    return String.format("Item %s w/ code %d & code CPC %d\n", designation, code, codeCPC);
  }
}

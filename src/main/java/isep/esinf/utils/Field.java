package isep.esinf.utils;

public enum Field {
  AREA_CODE("Area Code"), AREA_M49("Area Code (M49)"), AREA("Area"), ITEM_CODE(
      "Item Code"), ITEM_CPC("Item Code (CPC)"), ITEM("Item"), ELEMENT_CODE(
          "Element Code"), ELEMENT(
              "Element"), YEAR("Year"), UNIT("Unit"), VALUE("Value"), FLAG("Flag");

  public final String name;

  private Field(String name) {
    this.name = name;
  }
}

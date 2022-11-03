package isep.esinf.model;

public class Value {
  private double value;
  private String unit;
  private String flag;
  private String flagDescription;

  public Value(double value, String unit, String flag, String flagDescription) {
    this.value = value;
    this.unit = unit;
    this.flag = flag;
    this.flagDescription = flagDescription;
  }

  public double getValue() {
    return this.value;
  }

  public String getUnit() {
    return this.unit;
  }

  public String getFlag() {
    return this.flag;
  }

  public String getFlagDescription() {
    return this.flagDescription;
  }

  public void setFlagDescription(String flagDescription) {
    this.flagDescription = flagDescription;
  }

  public Value clone() {
    return new Value(value, unit, flag, flagDescription);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Value)) {
      return false;
    }
    Value value = (Value) o;

    // compare 2 doubles
    if (Math.abs(this.getValue() - value.getValue()) <= 0.000001)
      return true;

    // different
    if (value.getUnit() == null ^ this.getUnit() == null)
      return false;

    // both null
    if (value.getUnit() == null && this.getUnit() == null)
      return true;

    if (!value.getUnit().equals(this.getUnit()))
      return false;

    // different
    if (value.getFlag() == null ^ this.getFlag() == null)
      return false;

    // both null
    if (value.getFlag() == null && this.getFlag() == null)
      return true;

    if (!value.getFlag().equals(this.getFlag()))
      return false;

    // different
    if (value.getFlagDescription() == null ^ this.getFlagDescription() == null)
      return false;

    // both null
    if (value.getFlagDescription() == null && this.getFlagDescription() == null)
      return true;

    return value.getFlagDescription().equals(this.getFlagDescription());
  }
}

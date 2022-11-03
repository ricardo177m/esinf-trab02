package isep.esinf.model;

public class Value {
  private double value;
  private String unit;
  private String flag;
  private String flagDescription;

  public Value(double value, String unit, String flag, String flagDescription) {
    setFlag(flagDescription);
    setFlagDescription(flagDescription);
    setUnit(unit);
    setValue(value);
  }

  public double getValue() {
    return this.value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getUnit() {
    return this.unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getFlag() {
    return this.flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getFlagDescription() {
    return this.flagDescription;
  }

  public void setFlagDescription(String flagDescription) {
    this.flagDescription = flagDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Value)) {
      return false;
    }
    Value value = (Value) o;

    if (value.getValue() != this.getValue())
      return false;

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

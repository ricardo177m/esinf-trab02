package isep.esinf.model;

public class Value {
    private double value;
    private String unit;
    private String flag;
    private String flagDescription;

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

    public Value(double value, String unit, String flag, String flagDescription){
        setFlag(flagDescription);
        setFlagDescription(flagDescription);
        setUnit(unit);
        setValue(value);
    }
    
}

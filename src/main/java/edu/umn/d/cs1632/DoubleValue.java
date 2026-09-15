package edu.umn.d.cs1632;

public class DoubleValue extends Value {

    private double value;

    public DoubleValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String getType() {
        return "Double";
    }

    @Override
    public String getDisplayType() {
        return value + "(D)";
    }
}
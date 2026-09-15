package edu.umn.d.cs1632;

public class IntValue extends Value {

    private int value;

    public IntValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getType() {
        return "Int";
    }

    @Override
    public String getDisplayType() {
        return value + "(I)";
    }
}
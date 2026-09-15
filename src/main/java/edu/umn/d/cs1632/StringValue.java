package edu.umn.d.cs1632;

public class StringValue extends Value {

    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getType() {
        return "String";
    }

    @Override
    public String getDisplayType() {
        return value + "(S)";
    }
}
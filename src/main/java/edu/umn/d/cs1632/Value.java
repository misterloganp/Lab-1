package edu.umn.d.cs1632;

public abstract class Value {

    public abstract String getType();

    public abstract String getDisplayType();

    @Override
    public String toString() {
        return getDisplayType();
    }
}
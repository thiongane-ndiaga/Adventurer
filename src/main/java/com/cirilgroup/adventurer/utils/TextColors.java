package com.cirilgroup.adventurer.utils;

public enum TextColors {
    RESET("\u001B[0m"), GREEN("\u001B[32m"), BLUE("\u001B[34m");

    private String value;
    private TextColors(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}

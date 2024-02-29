package com.cirilgroup.adventurer.utils;

/**
 * Enumérqtion des couleurs de texte sur la console
 */
public enum TextColors {
    RESET("\u001B[0m"), GREEN("\u001B[32m"), BLUE("\u001B[34m");

    private final String value;
    private TextColors(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}

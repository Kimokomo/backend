package com.example.webApp.model;

public enum Gender {

    MALE("m"),
    FEAMLE("f"),
    OTHER("o");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

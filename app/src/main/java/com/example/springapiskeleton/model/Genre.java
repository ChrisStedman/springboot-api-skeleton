package com.example.springapiskeleton.model;

public enum Genre {
    COUNTRY("Country"),

    GRUNGE("Grunge"),

    POP("Pop"),

    ROCK("Rock"),

    JAZZ("Jazz"),

    PUNK("Punk");

    private final String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Genre fromValue(String value) {
        for (Genre genre : Genre.values()) {
            if (genre.value.equals(value)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

package org.squirrel.world.db.model;

public enum Continent {
    NORTH_AMERICA ("north america"),
    ASIA ("asia"),
    AFRICA ("africa"),
    EUROPE ("europe"),
    SOUTH_AMERICA ("south america"),
    OCEANIA ("oceania"),
    ANTARCTICA ("antarctica");

    private String value;

    Continent(String value) {
        this.value = value;
    }

    public static Continent fromValue(String value) {
        if (value == null) {
            return null;
        }

        switch (value) {
            case "North America":
                return NORTH_AMERICA;
            case "South America":
                return SOUTH_AMERICA;
            default:
                return Continent.valueOf(value.toUpperCase());
        }
    }
}

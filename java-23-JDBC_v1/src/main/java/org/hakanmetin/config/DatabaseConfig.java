package org.hakanmetin.config;

public final class DatabaseConfig {

    private DatabaseConfig() {
    }

    public static String require(String variableName) {
        String value = System.getenv(variableName);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Fehlende Umgebungsvariable für die Datenbank: " + variableName);
        }

        return value;
    }
}

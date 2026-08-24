package org.hakanmetin;

/** Ein Fahrer kann unabhängig von einem bestimmten Fahrzeug existieren. */
public final class Fahrer {

    private final String name;

    public Fahrer(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Der Fahrername darf nicht leer sein.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
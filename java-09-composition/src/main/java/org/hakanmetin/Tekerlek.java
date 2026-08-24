package org.hakanmetin;

public final class Tekerlek {

    public enum Position {
        VORNE_LINKS, VORNE_RECHTS, HINTEN_LINKS, HINTEN_RECHTS
    }

    private final Position position;

    public Tekerlek(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Die Radposition darf nicht null sein.");
        }
        this.position = position;
    }
}

package org.hakanmetin;

/** Ein Objekt steht jetzt für genau einen Sitz und kann eigenen Zustand tragen. */
public final class Koltuk {

    public enum Position {
        FAHRER, BEIFAHRER, HINTEN_LINKS, HINTEN_RECHTS
    }

    private final Position position;
    private boolean belegt;

    Koltuk(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Die Sitzposition darf nicht null sein.");
        }
        this.position = position;
    }

    void belegen() {
        if (belegt) {
            throw new IllegalStateException(position + " ist bereits belegt.");
        }
        belegt = true;
    }

    void freigeben() {
        belegt = false;
    }

    Position getPosition() {
        return position;
    }

    boolean isBelegt() {
        return belegt;
    }
}

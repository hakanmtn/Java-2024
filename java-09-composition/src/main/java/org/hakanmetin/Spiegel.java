package org.hakanmetin;

/**
 * Der Spiegel wird im aktuellen Modell intern durch Fahrzeug erzeugt
 * und nicht als veränderliche Referenz nach außen gegeben.
 */
public final class Spiegel {

    public enum Position {
        LINKS, RECHTS
    }

    private final Position position;
    private final boolean einklappbar;
    private boolean eingeklappt;

    public Spiegel(Position position, boolean einklappbar) {
        if (position == null) {
            throw new IllegalArgumentException("Die Spiegelposition darf nicht null sein.");
        }
        this.position = position;
        this.einklappbar = einklappbar;
    }

    void einklappen() {
        if (!einklappbar) {
            throw new IllegalStateException(position + " der Spiegel ist nicht einklappbar.");
        }
        eingeklappt = true;
    }

    Position getPosition() {
        return position;
    }

    public boolean isEingeklappt() {
        return eingeklappt;
    }
}

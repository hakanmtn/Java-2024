package org.hakanmetin;

/**
 * Ein Motor kann vor dem Fahrzeug existieren und wird dem Fahrzeug von außen
 * übergeben. Im Beispiel ist er deshalb der aggregierte Bestandteil.
 */
public final class Motor {

    private final int leistungWatt;
    private boolean gestartet;

    public Motor(int leistungWatt) {
        if (leistungWatt <= 0) {
            throw new IllegalArgumentException("Die Motorleistung muss positiv sein.");
        }
        this.leistungWatt = leistungWatt;
    }

    public int getLeistungWatt() {
        return leistungWatt;
    }

    public boolean isGestartet() {
        return gestartet;
    }

    public void starten() {
        gestartet = true;
    }

    public void stoppen() {
        gestartet = false;
    }
}

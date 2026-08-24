package org.hakanmetin;

/** Das Lenkrad ist fest in den Lebenszyklus des Fahrzeugs eingebunden. */
public final class Direksiyon {

    private final int durchmesserCm;

    public Direksiyon(int durchmesserCm) {
        if (durchmesserCm < 20 || durchmesserCm > 60) {
            throw new IllegalArgumentException("Der Lenkraddurchmesser muss zwischen 20 und 60 cm liegen.");
        }
        this.durchmesserCm = durchmesserCm;
    }

    public int getDurchmesserCm() {
        return durchmesserCm;
    }
}

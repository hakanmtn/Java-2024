package org.hakanmetin;

/** Der Tank ist in diesem Verbrenner-Beispiel ein kompositioneller Bestandteil. */
public final class Depo {

    public enum Kraftstoffart {
        BENZIN, DIESEL
    }

    private final Kraftstoffart kraftstoffart;
    private final int kapazitaetLiter;
    private int fuellstandLiter;

    public Depo(Kraftstoffart kraftstoffart, int kapazitaetLiter) {
        if (kraftstoffart == null) {
            throw new IllegalArgumentException("Die Kraftstoffart darf nicht null sein.");
        }
        if (kapazitaetLiter <= 0) {
            throw new IllegalArgumentException("Die Tankkapazität muss positiv sein.");
        }
        this.kraftstoffart = kraftstoffart;
        this.kapazitaetLiter = kapazitaetLiter;
    }

    public void tanken(int liter) {
        if (liter <= 0) {
            throw new IllegalArgumentException("Die Tankmenge muss positiv sein.");
        }
        if (fuellstandLiter + liter > kapazitaetLiter) {
            throw new IllegalArgumentException("Der Tank würde überfüllt.");
        }
        fuellstandLiter += liter;
    }

    public Kraftstoffart getKraftstoffart() {
        return kraftstoffart;
    }

    public int getKapazitaetLiter() {
        return kapazitaetLiter;
    }

    public int getFuellstandLiter() {
        return fuellstandLiter;
    }
}

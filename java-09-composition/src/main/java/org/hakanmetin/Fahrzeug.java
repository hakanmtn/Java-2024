package org.hakanmetin;

import java.util.Objects;

/**
 * Das Gesamtobjekt demonstriert drei verschiedene Objektbeziehungen.
 *
 * <ul>
 *   <li>Aggregation: Der Motor wird von außen übergeben.</li>
 *   <li>Komposition: Tank, Lenkrad, Spiegel, Räder und Sitze entstehen intern.</li>
 *   <li>Assoziation: Ein Fahrer wird nur vorübergehend in fahrenMit verwendet.</li>
 * </ul>
 */
public final class Fahrzeug {

    // AGGREGATION: externe Erzeugung, aber dauerhafte has-a-Referenz.
    private final Motor motor;

    // KOMPOSITION: interne Erzeugung, private/finale Referenzen, keine Herausgabe.
    private final Depo tank;
    private final Direksiyon lenkrad;
    private final Spiegel[] spiegel;
    private final Tekerlek[] raeder;
    private final Koltuk[] sitze;

    public Fahrzeug(Motor motor) {
        this.motor = Objects.requireNonNull(motor, "Der Motor darf nicht null sein.");

        this.tank = new Depo(Depo.Kraftstoffart.BENZIN, 50);
        this.lenkrad = new Direksiyon(30);
        this.spiegel = new Spiegel[] {
                new Spiegel(Spiegel.Position.LINKS, true),
                new Spiegel(Spiegel.Position.RECHTS, true)
        };
        this.raeder = new Tekerlek[] {
                new Tekerlek(Tekerlek.Position.VORNE_LINKS),
                new Tekerlek(Tekerlek.Position.VORNE_RECHTS),
                new Tekerlek(Tekerlek.Position.HINTEN_LINKS),
                new Tekerlek(Tekerlek.Position.HINTEN_RECHTS)
        };
        this.sitze = new Koltuk[] {
                new Koltuk(Koltuk.Position.FAHRER),
                new Koltuk(Koltuk.Position.BEIFAHRER),
                new Koltuk(Koltuk.Position.HINTEN_LINKS),
                new Koltuk(Koltuk.Position.HINTEN_RECHTS)
        };
    }

    public void starten() {
        if (tank.getFuellstandLiter() == 0) {
            throw new IllegalStateException("Das Fahrzeug kann mit leerem Tank nicht starten.");
        }
        motor.starten();
    }

    public void stoppen() {
        motor.stoppen();
    }

    public void tanken(int liter) {
        tank.tanken(liter);
    }

    public void spiegelEinklappen() {
        for (Spiegel einzelnerSpiegel : spiegel) {
            einzelnerSpiegel.einklappen();
        }
    }

    /**
     * ASSOZIATION: fahrer ist nur ein Methodenparameter. Das Fahrzeug speichert
     * ihn nicht und übernimmt daher weder Besitz noch Lebenszyklus.
     */
    public String fahrenMit(Fahrer fahrer) {
        Objects.requireNonNull(fahrer, "Der Fahrer darf nicht null sein.");
        if (!motor.isGestartet()) {
            throw new IllegalStateException("Vor dem Fahren muss der Motor gestartet werden.");
        }
        return fahrer.getName() + " fährt das Fahrzeug.";
    }

    /** Gibt Werte aus, aber keine veränderlichen Komponentenreferenzen. */
    public String beschreibung() {
        return "Fahrzeug{" +
                "motorleistung=" + motor.getLeistungWatt() + " W" +
                ", kraftstoff=" + tank.getKraftstoffart() +
                ", tank=" + tank.getFuellstandLiter() + "/" + tank.getKapazitaetLiter() + " l" +
                ", lenkrad=" + lenkrad.getDurchmesserCm() + " cm" +
                ", spiegel=" + spiegel.length +
                ", räder=" + raeder.length +
                ", sitze=" + sitze.length +
                '}';
    }
}
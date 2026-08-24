package org.hakanmetin;

/**
 * Programmstart für die Lernübung. Das eigentliche Gesamtobjekt steht bewusst
 * in der singular benannten Klasse
 */
public final class AppMain {

    public static void main(String[] args) {
        // AGGREGATION: Der Motor existiert bereits vor dem Fahrzeug.
        Motor motor = new Motor(6_000);
        Fahrzeug fahrzeug = new Fahrzeug(motor);

        // ASSOZIATION: Der Fahrer wird nur für diesen Vorgang verwendet.
        Fahrer fahrer = new Fahrer("Hakan");

        fahrzeug.tanken(20);
        fahrzeug.starten();
        fahrzeug.spiegelEinklappen();

        System.out.println(fahrzeug.beschreibung());
        System.out.println(fahrzeug.fahrenMit(fahrer));

        fahrzeug.stoppen();
        System.out.println("Motor läuft nach dem Stoppen: " + motor.isGestartet());
    }
}

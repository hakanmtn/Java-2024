package org.hakanmetin.hayvanlar.Köpek;

import org.hakanmetin.hayvanlar.Hayvan;

public class Köpek extends Hayvan {
    @Override
    public void sesVer() {
        System.out.println("Köpek: Hav hav");
    }

    @Override
    public void bilgisiniGetir() {
        System.out.println();
    }
}

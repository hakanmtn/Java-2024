package org.hakanmetin;

import org.hakanmetin.base.Personel;
import org.hakanmetin.department.Muhasebe;
import org.hakanmetin.department.Müdür;
import org.hakanmetin.department.Yazilimci;

public class AppMain {
    public static void main(String[] args) {

        Müdür müdür = new Müdür();

        müdür.setName("Hakan");
        müdür.setSoyadi("Metin");
        müdür.setMaas(8_000f);
        müdür.setMakamAraci(true);
        müdür.setTelefon("3235352365");
        müdür.setSicilNo(123);
        müdür.setDepartment("Arge");

        müdür.bilgisiniYaz(müdür);

        System.out.println("---------");

        Muhasebe muhasebe = new Muhasebe();

        muhasebe.setName("Natalie");
        muhasebe.setSoyadi("Weiss");
        muhasebe.setMaas(9_000f);
        muhasebe.setYeminDurumu(true);
        muhasebe.setTelefon("5646445895489");
        muhasebe.setSicilNo(154);
        muhasebe.setDepartment("Finance");

        muhasebe.bilgisiniYaz(muhasebe);

        System.out.println("---------");

        Yazilimci yazilimci = new Yazilimci();

        yazilimci.setName("Mathias");
        yazilimci.setSoyadi("Koch");
        yazilimci.setMaas(7_000f);
        yazilimci.setUzmanlikAlani("Java");
        yazilimci.setTelefon("5646445895489");
        yazilimci.setSicilNo(2342);
        yazilimci.setDepartment("Arge");

        yazilimci.bilgisiniYaz(yazilimci);

        //polymorphism
        Personel personel = new Personel();
        personel.hesapla();
    }
}

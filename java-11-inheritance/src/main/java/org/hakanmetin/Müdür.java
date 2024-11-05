package org.hakanmetin;

import lombok.Getter;
import lombok.Setter;

import java.sql.SQLOutput;

@Getter
@Setter
public class Müdür extends Personel{

    private boolean makamAraci;

    public Müdür(String name,
                 String soyadi,
                 String telefon,
                 String department,
                 int sicilNo,
                 String mezuniyet,
                 String adress,
                 short maas,
                 boolean medeniDurumu,
                 boolean makamAraci) {
        //super her zaman constructorun ilk satirinda durur.
        super(name, soyadi, telefon, department, sicilNo, mezuniyet, adress, maas, medeniDurumu);
        this.makamAraci = makamAraci;
    }

    public Müdür() {

    }

    public void bilgisiniYaz(Müdür müdür){
        System.out.println(müdür.getName() + " " + müdür.getSoyadi());
        System.out.println("Arac: " + (müdür.isMakamAraci() ? "Var" : "Yok"));
        System.out.println(müdür.getTelefon());
        System.out.println(müdür.getDepartment());
        System.out.println(müdür.getSicilNo());

    }
}

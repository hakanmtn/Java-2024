package org.hakanmetin;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Personel {


    private String name;
    private String soyadi;
    private String telefon;
    private String department;
    private int sicilNo;
    private String mezuniyet;
    private String adress;
    private short maas;
    private boolean medeniDurumu;

}
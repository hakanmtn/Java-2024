package org.hakanmetin._02;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//Model - Kalip
public class Personel {

    private String firstName;
    private String lastName;
    private String tc;
    private String sicilNo;
    private String department;
    private int birthYear;
    private boolean medeniDurum;
    private int cocukSayisi;

    public void ekranaYaz(){
        System.out.println("Ekrana Yaz");
    }



}

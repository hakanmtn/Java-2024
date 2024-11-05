package org.hakanmetin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Muhasebe extends Personel{
    private boolean yeminDurumu;
    private String unvani;

    public void bilgisiniYaz(Muhasebe muhasebe){
        System.out.println(muhasebe.getName() + " " + muhasebe.getSoyadi());
        System.out.println("Medeni Durumu: " + (muhasebe.isYeminDurumu() ? "Var" : "Yok"));
        System.out.println(muhasebe.getTelefon());
        System.out.println(muhasebe.getDepartment());
        System.out.println(muhasebe.getSicilNo());

    }


}

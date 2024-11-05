package org.hakanmetin.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hakanmetin.base.Personel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Yazilimci extends Personel {

    private String uzmanlikAlani;

    public void bilgisiniYaz(Yazilimci yazilimci){
        System.out.println(yazilimci.getName() + " " + yazilimci.getSoyadi());
        System.out.println("Medeni Durumu: " + yazilimci.getUzmanlikAlani());
        System.out.println(yazilimci.getTelefon());
        System.out.println(yazilimci.getDepartment());
        System.out.println(yazilimci.getSicilNo());

    }

}

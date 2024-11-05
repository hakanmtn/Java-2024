package org.hakanmetin.base;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Getter
public class Arac {

    //JAVA DA COKLU MIRAS OLMAZ
    private short koltukSayisi;
    private byte tekerSayisi;
    private String marka;
    private int motorHacmi;
    private String yakitTipi;

}

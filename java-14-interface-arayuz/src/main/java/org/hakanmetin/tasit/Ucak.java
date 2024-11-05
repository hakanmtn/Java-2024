package org.hakanmetin.tasit;

import lombok.*;
import org.hakanmetin.base.Arac;
import org.hakanmetin.utilies.IInternationalAirTransportAssociation;
import org.hakanmetin.utilies.IKanun;



@Setter
@ToString (callSuper = true)  //Miras aldigi icin ust siniftan böyle kullanabiliriz
@Getter
public class Ucak extends Arac implements IKanun, IInternationalAirTransportAssociation {
    @Override
    public int hizSiniri(int hizLimiti) {
        return hizLimiti;
    }

    @Override
    public String bakimDurumu(String durumBilgisi) {
        return durumBilgisi;
    }

    @Override
    public float tasitVergisi(float vergiMikatari) {
        return vergiMikatari;
    }

    @Override
    public byte emisyonDegeri(byte olcumOrani) {
        return olcumOrani;
    }

    @Override
    public boolean kurumUyeDurumu(boolean durumu) {
        return durumu;
    }

    @Override
    public float aidat(float aidatOdemesi) {
        return aidatOdemesi;
    }

    @Override
    public boolean vizeIzinDurumu(boolean vizeIzinDurumu) {
        return vizeIzinDurumu;
    }

    @Override
    public short yolcuKapasitesi(short yolcuKapasitesi) {
        return yolcuKapasitesi;
    }
}

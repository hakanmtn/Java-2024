package org.hakanmetin.tasit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hakanmetin.base.Arac;
import org.hakanmetin.utilies.IKanun;
import org.hakanmetin.utilies.ITaksicilerDernegi;
import org.hakanmetin.utilies.IUlastirmaBakanligi;

@Setter
@Getter
@ToString (callSuper = true)
public class Taksi extends Arac implements IKanun, IUlastirmaBakanligi, ITaksicilerDernegi {
    @Override
    public int hizSiniri(int hizLimiti) {
        return hizLimiti;
    }

    @Override
    public String bakimDurumu(String durumBilgisi) {
        return durumBilgisi;
    }

    @Override
    public float tasitVergisi(float vergiMiktari) {
        return vergiMiktari;
    }

    @Override
    public byte emisyonDegeri(byte olcumOrani) {
        return olcumOrani;
    }

    @Override
    public boolean ruhsatDurumu(boolean durum) {
        return durum;
    }

    @Override
    public boolean ehliyetDurumu(boolean durum) {
        return durum;
    }

    @Override
    public String sigortaBilgiEvraki() {
        return "";
    }

    @Override
    public boolean dernekUyelikDurumu(boolean durumu) {
        return durumu;
    }

    @Override
    public float acilisUcreti(float acilisParasi) {
        return acilisParasi;
    }
}

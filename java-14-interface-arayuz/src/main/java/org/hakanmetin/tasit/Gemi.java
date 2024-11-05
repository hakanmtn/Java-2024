package org.hakanmetin.tasit;

import org.hakanmetin.base.Arac;
import org.hakanmetin.utilies.IKanun;

public class Gemi extends Arac implements IKanun {
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
}

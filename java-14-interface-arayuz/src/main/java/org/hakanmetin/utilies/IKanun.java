package org.hakanmetin.utilies;

public interface IKanun {

    /*
    * INTERFACE ler kurallar, herkes hepsine uymak zorunda
    * Burada methodlarin kesinlikle gövdesi yok.
    * Simdilerde var ama default anahtar kelimesini kullanamak zorundayiz.
    * örn. public default int hizSiniri(){return 0;}
    * INTERFACE in amaci kullanilmak, o yüzden PUBLIC
    * Interface icindeki bütün methodlar implements edilmek zorunda
    */

    public int hizSiniri(int hizLimiti);

    public String bakimDurumu(String durumBilgisi);

    public float tasitVergisi(float vergiMikatari);

    public byte emisyonDegeri(byte olcumOrani);
}

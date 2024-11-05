package org.hakanmetin.robotlar;

public interface SanayiTeknolojiBakanligi {

    /*
    * 1.Bir Bir Robot, bir insana zarar veremez, ya da zarar görmesine seyirci kalamaz.
    * 2.Bir robot, birinci vasayla celismedigi sürece bir insanin emirlerine uymak zomundadir.
    * 3.Bir robot, birinci ve ikinci yasayla celismedigi sürece kendi varligini korumakla yükümlüdür.
    */


    public boolean insanAnalizi(boolean durum);

    public boolean insanKorumaDurumu(boolean durum);

    public boolean chipNumarasiDurumu(boolean durum);

    public default void bakimHizmetiAlmaDurumu(boolean durum) {
        System.out.println("Bakim Hizmeti Durumu Alinacak.");
    }
}

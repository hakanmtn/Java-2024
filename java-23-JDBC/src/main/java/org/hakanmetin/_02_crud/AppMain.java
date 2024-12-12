package org.hakanmetin._02_crud;

import java.sql.SQLException;

public class AppMain {



    static final String SQL_GET_ALL_CLIENT = "SELECT * FROM musteriler";
    static final String SQL_GET_ALL_CLIENT_OLDER_THAN_25 = "SELECT * FROM musteriler WHERE musteri_yasi >25";
    static final String SQL_UPDATE_FIRST_CLIENTSINFO = "  UPDATE public.musteriler " +
            "  SET " + "  " +
            "musteri_adi= 'Michael', " +
            "  musteri_soyadi= 'Jackson', " +
            "  sehir= 'Colorado', " +
            "  musteri_yasi= 27 " +
            "  WHERE musteri_id = 1";

    static final String SQL_INSERT_FIRST_CLIENTSINFO =" INSERT INTO public.musteriler( " +
            " musteri_adi, musteri_soyadi, sehir, musteri_yasi) " +
            " VALUES ('Mathias', 'Kohl', 'Mailand', 30) ";



    static final String SQL_DELETE_FIRST_CLIENTSINFO =" DELETE FROM public.musteriler " +
            " WHERE musteri_id = 9 ";



    public static void main(String[] args) throws SQLException {

        MyCrud myCrud = new MyCrud();

        System.out.println("---READ----");
        myCrud.getAllClients(SQL_GET_ALL_CLIENT);
        myCrud.getAllClientsOlderThan25(SQL_GET_ALL_CLIENT_OLDER_THAN_25);

        System.out.println("----UPDATE----");
        myCrud.updateMusteriIdUpdate(SQL_UPDATE_FIRST_CLIENTSINFO);

        System.out.println("----INSERT----");
        myCrud.addACustomer(SQL_INSERT_FIRST_CLIENTSINFO);


        System.out.println("----DELETE----");
        myCrud.deleteACustomer(SQL_DELETE_FIRST_CLIENTSINFO);

        System.out.println("---READ----");
        myCrud.getAllClients(SQL_GET_ALL_CLIENT);
    }
}

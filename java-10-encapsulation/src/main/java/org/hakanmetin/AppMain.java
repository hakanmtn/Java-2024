package org.hakanmetin;

public class AppMain {


    public static void main(String[] args) {

        Account account = new Account();
        account.setName("Hakan");
        account.setLastName("Metin");
        account.setFiliale("Muenchen");
        account.setSubeNo(1000);
        account.setHesapNo(1234567L);
        account.setIbanNo("1111-2222-3333-4444");
        account.setHesapParaCinsi("Euro");
        account.setBalance(2574.15f);

        System.out.println(account);

        System.out.println("------------------");

        Account account2 = new Account("Natalie", "Weiss");
        account2.setFiliale("Stuttgart");
        account2.setSubeNo(1040);
        account2.setHesapNo(1237567L);
        account2.setIbanNo("1511-2252-3333-4444");
        account2.setHesapParaCinsi("Dollar");
        account2.setBalance(41574.15f);
        System.out.println(account2);

        System.out.println("------------------");
        Account account3 = new Account("Rosa", "Fex","Berlin", 1033,123453L, "1143-2342-3234-4234","Euro", 42323.23f);

        System.out.println(account3);

    }
}

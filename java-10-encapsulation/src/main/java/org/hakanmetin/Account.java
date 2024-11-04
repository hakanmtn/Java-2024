package org.hakanmetin;
//POJO - Model

public class Account {
    /*
    * public - Herkes kullanabilir, bu senaryoyu istemiyoruz
    * protected - bunu sadece miras alan siniflar kullanabiliyor. Baba- Ogul
    * Java da bir klasin sadece bir tane miras aldigi klas olabilir. Coklu Miras yok
    * private - Sadece bulundugu klasin icinde kullanilabilir.
    * */
    private String name;
    private String lastName;
    private String filiale;
    private int subeNo;
    private long hesapNo;
    private String ibanNo;
    private String hesapParaCinsi;
    private float balance;

    public Account() {
        System.out.println("Account constructor - Ohne Parameter.");
    }
    public Account(String name,
                   String lastName,
                   String filiale,
                   int subeNo,
                   long hesapNo,
                   String ibanNo,
                   String hesapParaCinsi,
                   float balance) {
        this.name = name;
        this.lastName = lastName;
        this.filiale = filiale;
        this.subeNo = subeNo;
        this.hesapNo = hesapNo;
        this.ibanNo = ibanNo;
        this.hesapParaCinsi = hesapParaCinsi;
        this.balance = balance;
        System.out.println("Hesap Cüzdani - bütün Parametreler dahil.");
    }

    public Account(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
        System.out.println("Hesap Cüzdani - 2 Parametreli. ");

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFiliale(String filiale) {
        this.filiale = filiale;
    }

    public void setSubeNo(int subeNo) {
        this.subeNo = subeNo;
    }

    public void setHesapNo(long hesapNo) {
        this.hesapNo = hesapNo;
    }

    public void setIbanNo(String ibanNo) {
        this.ibanNo = ibanNo;
    }

    public void setHesapParaCinsi(String hesapParaCinsi) {
        this.hesapParaCinsi = hesapParaCinsi;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFiliale() {
        return filiale;
    }

    public int getSubeNo() {
        return subeNo;
    }

    public long getHesapNo() {
        return hesapNo;
    }

    public String getIbanNo() {
        return ibanNo;
    }

    public String getHesapParaCinsi() {
        return hesapParaCinsi;
    }

    public float getBalance() {
        return balance;
    }



    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", filiale='" + filiale + '\'' +
                ", subeNo=" + subeNo +
                ", hesapNo=" + hesapNo +
                ", ibanNo='" + ibanNo + '\'' +
                ", hesapParaCinsi='" + hesapParaCinsi + '\'' +
                ", balance=" + balance +
                '}';
    }


}
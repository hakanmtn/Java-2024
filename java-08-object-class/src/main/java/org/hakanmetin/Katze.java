package org.hakanmetin;

public class Katze {


    //declaration
    int alter;
    String rasse;
    String farbe;
    // Constructor  vor dem Constructor existiert void, int .. NICHT, eger olursa o bir normal methoddur

    public Katze() {
            /*
            int alter = 0; //Bu bu scope icinde yepyeni bir variable.
            String rasse = "unknown";
            String farbe = "unknown";
            */
            alter = 0;
            rasse = "Unknown";
            farbe = "Unknown";
        }

    public Katze(int alter, String rasse, String farbe) {
        this.alter = alter;
        this.rasse = rasse;
        this.farbe = farbe;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setRasse(String rasse) {
        this.rasse = rasse;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getAlter() {
        return alter;
    }

    public String getRasse() {
        return rasse;
    }

    public String getFarbe() {
        return farbe;
    }

    /*

        Bu normal bir method, önunde int var, ve normalde methodlar kücük harfle baslar.
        public int Katze() {
            return 0;
        }
     */

    public static void main(String[] args) {

        Katze katze = new Katze(); //Ein Objeckt wurde erzeugt.

        System.out.println(katze.rasse);
        System.out.println(katze.farbe);
        System.out.println(katze.alter);

        System.out.println("---------------------");

        katze.rasse = "Van";
        katze.alter = 4;
        katze.farbe = "Weiss";
        System.out.println(katze.rasse);
        System.out.println(katze.farbe);
        System.out.println(katze.alter);

        System.out.println("---------------------");

        katze.rasse = "Ankara";
        katze.alter = 3;
        katze.farbe = "Weiss";
        System.out.println(katze.rasse);
        System.out.println(katze.farbe);
        System.out.println(katze.alter);

        System.out.println("--------------------");

        //Mehrere Katzen können erzeugt werden.
        Katze katze2 = new Katze(8,"Tekir","Alacali");
        System.out.println("Alter der Katze: " + katze2.alter + " - Farbe: "+ katze2.farbe + " - Rasse: "+ katze2.rasse );

        Katze katze3 = new Katze(9,"Britisch","Brown");
        System.out.println("Alter der Katze: " + katze3.alter + " - Farbe: "+ katze3.farbe + " - Rasse: "+ katze3.rasse );

        Katze katze4 = new Katze(10,"","Brown");  // Rasse ist nicht bekannt
        System.out.println("Alter der Katze: " + katze4.getAlter() + " - Farbe: "+ katze4.getFarbe() + " - Rasse: "+ katze4.getRasse());

        System.out.println("--------------------");

        katze.setAlter(6);

        System.out.println("Alter der Katze: " + katze.getAlter() + " - Farbe: "+ katze.getFarbe() + "- Rasse: "+ katze.getRasse());

    }


}
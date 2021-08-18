package Sreda;

import java.util.Arrays;
import java.util.Random;

public class Karatisti {
    private String ime;
    private int godine;
    private String rang;
    private String[] kata;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        if (rang.matches("[1-9]Kyu") || rang.matches("10Kyu") || rang.matches("[1-9]Dan") || rang.matches("10Dan")){
            this.rang = rang;
        } else {
            this.rang = "10Kyu";
            System.out.println("Niste uneli ispravan rang! Postavljena osnovna vrednost (10Kyu)");
        }
    }

    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
        this.kata = kata;
    }

    public Karatisti(String ime, int godine, String rang, String[] kata) {
        this.ime = ime;
        this.godine = godine;
        if (rang.matches("[1-9]Kyu") || rang.matches("10Kyu") || rang.matches("[1-9]Dan") || rang.matches("10Dan")){
            this.rang = rang;
        } else {
            this.rang = "10Kyu";
            System.out.println("Niste uneli ispravan rang! Postavljena osnovna vrednost (10Kyu)");
        }
        this.kata = kata;
    }

    public void napadni(int index){
        System.out.println("Karatista ".concat(ime).concat(" napada sa ").concat(kata[index]).concat(" katom"));
    }

    public void vatreniNapad(){
        napadni(new Random().nextInt(kata.length));
    }

    public void log(){
        System.out.println("Karatistia: ".concat(ime).concat(", ") + godine + ", ".concat(rang).concat(" - zna naredne kate ") + Arrays.toString(kata));
    }
}

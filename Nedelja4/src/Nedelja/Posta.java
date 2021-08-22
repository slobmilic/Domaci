package Nedelja;

import java.util.ArrayList;

public class Posta {
    private ArrayList<Poruka> poruke;


    /*Konstruktori*/

    public Posta(ArrayList<Poruka> poruke) {
        this.poruke = poruke;
    }
    /*Metode*/

    //Dodaje poruku p u poruke ako ona vec ne postoji (gledano u odnosu na id)
    public void add(Poruka p){
        //TODO: Implement me
    }

    //Brise poruku p iz poruka ako ona postoji (gledano u odnosu na id)
    public void remove(Poruka p){
        //TODO: Implement me
    }

    //Ispisuje poruku p i ibrese je iz poruka, ako ona postoji (gledano u odnosu na id)
    public void send(Poruka p){
        //TODO: Implement me
    }

    //Menja tekst poruke
    public void change(Poruka p, String msg){
        //TODO: Implement me
    }

    // Vraca sumu poruke p ako ta poruka postoji u listi
    public int isplata(Poruka p){
        //TODO: Implement me
    }


    // U konzoli ispisuje, ako je suma nenegativna:
    // {posiljalac} salje {suma} para {primalac}-u, uz poruku:
    // {poruka}
    // a ako je suma negativna:
    // {posiljalac} primac {suma} para od {primalac}-a, uz poruku:
    // {poruka}
    // za svaki element iz liste!
    @Override
    public String toString() {
        return "Posta{}";
    }
}

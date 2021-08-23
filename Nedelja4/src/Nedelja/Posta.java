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
        for (int i = 0; i < poruke.size(); i++) {
            if (p.getId() != poruke.get(i).getId()){
                poruke.add(p);
            }
        }
    }

    //Brise poruku p iz poruka ako ona postoji (gledano u odnosu na id)
    public void remove(Poruka p){
        //TODO: Implement me
        for (int i = 0; i < poruke.size(); i++) {
            if (p.getId() != poruke.get(i).getId()){
                poruke.remove(p);
            }
        }
    }

    //Ispisuje poruku p i ibrese je iz poruka, ako ona postoji (gledano u odnosu na id)
    public void send(Poruka p){
        //TODO: Implement me
//        for (int i = 0; i < poruke.size(); i++) {
//            if (p.getId() != poruke.get(i).getId()){
//                System.out.println(p.getPoruka());
//                poruke.remove(p);
//            }
//        }
        if (p.getId() == p.getId()){
            System.out.println(p.getPoruka());
            poruke.remove(p);
        }
    }

    //Menja tekst poruke
    public void change(Poruka p, String msg){
        //TODO: Implement me
        for (int i = 0; i < poruke.size(); i++) {
            p.setPoruka(msg);
        }
    }

    // Vraca sumu poruke p ako ta poruka postoji u listi
    public int isplata(Poruka p){
        //TODO: Implement me
        int iznos = 0;
        for (int i = 0; i < poruke.size(); i++) {
            iznos = p.getSuma();
        }
        return iznos;
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
        String poruka = "";
        for (Poruka value : poruke) {
            if (value.getSuma() > 0) {
                poruka = value.getPosiljalac() + " salje " + value.getSuma() + " para " + value.getPrimalac() + "-u, uz poruku: " + value.getPoruka();
            } else {
                poruka = value.getPosiljalac() + " primac " + value.getSuma() + " para od " + value.getPrimalac() + "-a, uz poruku: " + value.getPoruka();
            }
            return poruka;
        }
       return poruka;
    }
}

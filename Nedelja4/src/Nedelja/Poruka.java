package Nedelja;

public class Poruka {
    private String poruka;
    private String posiljalac;
    private String primalac;
    int suma;
    int id;

    /*Konstruktori*/

    public Poruka(String poruka, String posiljalac, String primalac, int suma, int id) {
        this.poruka = poruka;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.suma = suma;
        this.id = id;
    }
    /*Metode*/
    // TODO: setter i getter


    public String getPoruka() {
        return poruka;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public String getPrimalac() {
        return primalac;
    }

    public int getSuma() {
        return suma;
    }

    public int getId() {
        return id;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    // U konzoli ispisuje, ako je suma nenegativna:
    // {posiljalac} salje {suma} para {primalac}-u, uz poruku:
    // {poruka}
    // a ako je suma negativna:
    // {posiljalac} primac {suma} para od {primalac}-a, uz poruku:
    // {poruka}
    public void posalji(){
        //TODO: Implement me

    }

    // Ispisuje:
    // {posiljalac} i {prilamalac} vrse tranzakciju od {suma}, uz poruku: {poruka} ({id})

    @Override
    public String toString() {
        return "Poruka{}";
    }
}

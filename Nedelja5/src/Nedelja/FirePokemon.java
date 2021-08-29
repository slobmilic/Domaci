package Nedelja;

public class FirePokemon extends Pokemon{

    // private GrassPokemon grassPokemon;

    public FirePokemon(String name, int health) {
        super(name, health);
        super.setType("Fire type");
    }


    @Override
    public String attack() {
        return "Vatrom";
    }

    @Override
    public String defend() {
        return "Telesno";
    }

    @Override
    public String wins() {
        return "Grass type"; //grassPokemon.getName();
    }

    @Override
    public String lose() {
        return "Water type";
    }

    @Override
    public String logAll() {

        return "Napada: " + attack() + "\n"
                + "Brani se: " + defend() + "\n"
                + "Pobedjuje: " + wins() + "\n"
                + "Gubi od: " + lose();
    }


    // Napada: Vatrom
    // Brani se: Telesno
    // Pobedjuje: Grass type
    // Gubi od: Water type
}

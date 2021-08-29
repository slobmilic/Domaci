package Nedelja;

public class WaterPokemon extends Pokemon{


    public WaterPokemon(String name, int health) {
        super(name, health);
        super.setType("Water type");
    }


    @Override
    public String attack() {
        return "Vodom";
    }

    @Override
    public String defend() {
        return "Vodom";
    }

    @Override
    public String wins() {
        return "Fire type"; // kako doci do imena???
    }

    @Override
    public String lose() {
        return "Grass type";
    }

    @Override
    public String logAll() {
        return "Napada: " + attack() + "\n"
                + "Brani se: " + defend() + "\n"
                + "Pobedjuje: " + wins() + "\n"
                + "Gubi od: " + lose();
    }


    // Napada: Vodom
    // Brani se: Vodom
    // Pobedjuje: Fire type
    // Gubi od: Grass type


}

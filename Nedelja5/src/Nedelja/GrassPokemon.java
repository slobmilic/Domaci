package Nedelja;

public class GrassPokemon extends Pokemon{

    private String name;


    public GrassPokemon(String name, int health) {
        super(name, health);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String attack() {
        return "Travom";
    }

    @Override
    public String defend() {
        return "Izbegava";
    }

    @Override
    public String wins() {
        return "Water type";
    }

    @Override
    public String lose() {

        return "Fire type";
    }

    @Override
    public String logAll() {
        return "Napada: " + attack() + "\n"
                + "Brani se: " + defend() + "\n"
                + "Pobedjuje: " + wins() + "\n"
                + "Gubi od: " + lose();
    }


    // Napada: Travom
    // Brani se: Izbegava
    // Pobedjuje: Water type
    // Gubi od: Fire type
}

// one of the data object classes

public class Pakuri {

    String species;
    int attack, defense, speed;

    // This method should be the only constructor for this class.
    public Pakuri(String species) {
        this.species = species;

        // initialize values
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    // Returns the species of this critter
    public String getSpecies() {
        return species;
    }

    // Returns the attack value for this critter
    public int getAttack() {
        return attack;
    }

    // Returns the defense value for this critter
    public int getDefense() {
        return defense;
    }

    // Returns the speed of this critter
    public int getSpeed() {
        return speed;
    }

    // Changes the attack value for this critter to newAttack
    public void setAttack(int newAttack) {
        attack = newAttack;
    }

    // Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed
    public void evolve() {
        attack *= 2;
        defense *= 4;
        speed *= 3;
    }
}

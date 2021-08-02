// one of the data object classes

public class Pakudex {

    private Pakuri[] deck;
    private int capacity = -1;

    //Default constructor; if called, the default size for the Pakudex should be 20
    public Pakudex() {
        deck = new Pakuri[20];
    }

    // Initializes this object to contain exactly capacity objects when completely full
    public Pakudex(int capacity) {
        deck = new Pakuri[capacity];
    }

    // Returns the number of critters currently being stored in the Pakudex
    public int getSize() {
        return capacity + 1;
    }

    // Returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity() {
        return deck.length;
    }

    // Returns a String array containing the species of the critters as ordered in the Pakudex;
    // if there are no species added yet, this method should return null
    public String[] getSpeciesArray() {
        int count;
        for (count = 0; count < deck.length; count++) {
            if (deck[count] == null) {
                break;
            }
        }

        String[] pakudexDeck = new String[count];

        for (int i = 0; i < pakudexDeck.length; i++) {
            pakudexDeck[i] = deck[i].getSpecies();
        }

        if (capacity == -1) {
            return null;
        }

        return pakudexDeck;
    }

    // Returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1, and 2
    // respectively; if species is not in the Pakudex, returns null
    public int[] getStats(String species) {
        int[] statistics = new int[3];
        boolean valid = false;

        for (int i = 0; i < deck.length; i++) {
            if ((deck[i] != null) && species.equals(deck[i].getSpecies())) {
                valid = true;
            }
        }

        if (valid) {
            for (int i = 0; i < deck.length; i++) {
                if ((deck[i] != null) && (deck[i].getSpecies().equals(species))) {
                    statistics[0] = deck[i].getAttack();
                    statistics[1] = deck[i].getDefense();
                    statistics[2] = deck[i].getSpeed();
                }
            }
            return statistics;
        }
        else {
            return null;
        }
    }

    // Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
    public void sortPakuri() {
        for (int i = 0; i < deck.length; i++) {
            int min = i;

            for (int j = i + 1; j < deck.length; j++) {
                if ((deck[j] != null) && (deck[j].getSpecies().compareTo(deck[min].getSpecies()) < 0 )) {
                    min = j;
                }
            }

            Pakuri rand = deck[i];
            deck[i] = deck[min];
            deck[min] = rand;
        }
    }

    // Adds species to the Pakudex; if successful, return true, and false otherwise
    public boolean addPakuri(String species) {
        boolean test = true;
        capacity += 1;

        if (capacity > deck.length - 1) {
            test = false;
            capacity--;
            System.out.println("Error: Pakudex is full!");
        }

        if (test) {
            for (int i = 0; i < deck.length; i++) {
                if ((deck[i] != null) && species.equals(deck[i].getSpecies())) {
                    test = false;
                    capacity--;
                    System.out.println("Error: Pakudex already contains this species!");
                }
            }
        }

        if (test) {
            Pakuri pakuri = new Pakuri(species);
            deck[capacity] = pakuri;
            System.out.println("Pakuri species " + species + " successfully added!");
        }
        return test;
    }

    // Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
    public boolean evolveSpecies(String species) {
        boolean test = false;

        for (int i = 0; i < deck.length; i++) {
            if ((deck[i] != null) && species.equals(deck[i].getSpecies())) {
                deck[i].evolve();
                test = true;
            }
        }
        return test;
    }

    public void printMenu() {
        // display menu
        System.out.println();
        System.out.println("Pakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1.  List Pakuri");
        System.out.println("2.  Show Pakuri");
        System.out.println("3.  Add Pakuri");
        System.out.println("4.  Evolve Pakuri");
        System.out.println("5.  Sort Pakuri");
        System.out.println("6.  Exit\n");

        System.out.print("What would you like to do? ");
    }
}

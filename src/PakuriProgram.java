import java.util.Scanner;       // this is to create Strings

// the driver class
public class PakuriProgram {
    public static void main(String args []) {       // this is the main program that runs
        Scanner input = new Scanner(System.in);     // this is needed to accept Strings

        int capacity = 0;       // this is the number of species the user will input
        boolean confirm = false;        // this is to check that the number entered is valid

        // Display a welcome message
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");

        do {
            if (input.hasNextInt()) {
                capacity = input.nextInt();

                // check if user entered a valid capacity; this loop will keep running until a valid answer is entered
                if (capacity > 0) {
                    confirm = true;
                }
                else {
                    System.out.println("Please enter a valid size.");
                    System.out.print("Enter max capacity of the Pakudex: ");
                    capacity = input.nextInt();
                }
            }
            else if (input.hasNext()) {
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                input.next();
            }

            else {
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                input.next();
            }
        } while (!confirm);


        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");

        Pakudex pakudex = new Pakudex(capacity);            // create a pakudex
        String choice = "";                                 // initialize the user's choice

        while (!choice.equals("6")) {

            pakudex.printMenu();
            choice = input.next();

            // while not any of the valid answer choices, display error message
            while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6"))) {
                System.out.println("Unrecognized menu selection!");
                pakudex.printMenu();
                choice = input.next();
            }
            switch (choice) {
                case "1":     // Listing Pakuri
                    String[] list = pakudex.getSpeciesArray();

                    if (list == null) {
                        System.out.println("No Pakuri in Pakudex yet!");
                    }

                    else {
                        System.out.println("Pakuri In Pakudex:");

                        for (int i = 0; i < list.length; i++) {
                            System.out.println((i + 1) + ". " + list[i]);
                        }
                    }
                    break;
                case "2":     // Show Pakuri
                    System.out.print("Enter the name of the species to display: ");
                    String species = input.next();
                    int[] statistics = pakudex.getStats(species);
                    if (statistics == null) {
                        System.out.println("Error: No such Pakuri!");
                    }
                    else {
                        System.out.println();
                        System.out.println("Species: " + species);
                        System.out.println("Attack: " + statistics[0]);
                        System.out.println("Defense: " + statistics[1]);
                        System.out.println("Speed: " + statistics[2]);
                    }
                    break;
                case "3":     // Adding
                    if (pakudex.getCapacity() == pakudex.getSize()) {
                        System.out.println("Error: Pakudex is full!");
                    }
                    else {
                        System.out.print("Enter the name of the species to add: ");
                        species= input.next();
                        pakudex.addPakuri(species);
                    }
                    break;
                case "4":     // Evolve Pakuri
                    System.out.print("Enter the name of the species to evolve: ");
                    species = input.next();
                    if (pakudex.evolveSpecies(species)) {
                        System.out.println(species + " has evolved!");
                    }
                    else {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case "5":     // Sort Pakuri
                    pakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;
                case "6":     // Exit
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);
                    break;
            }
        }

    }
}

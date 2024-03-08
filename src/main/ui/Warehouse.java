package main.ui;

import main.model.Inventory;

import java.util.Scanner;

//represents the warehouse
public class Warehouse {

    Inventory inventory;
    Scanner scanner;

    public Warehouse() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    //MODIFIES: this
    //EFFECT: outputs the menu and takes the user input, after which
    //it calls the function to handle the user input
    public void menu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Display the inventory (with IDs)");
        System.out.println("2. Display the inventory (without IDs)");
        System.out.println("3. Add an item to the inventory");
        System.out.println("4. Remove an item from the inventory");
        System.out.println("5. Save current warehouse status");
        System.out.println("6. Quit application");
        int choice = scanner.nextInt();
        choiceHandler(choice);
    }

    //MODIFIES: this
    //EFFECT: handles the choice entered by the user on the menu screen by
    //carrying out the appropriate action.
    public void choiceHandler(int choice) {
        switch (choice) {
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid choice.");
        }
    }

    //MODIFIES: this
    //EFFECT: adds an item to the inventory if possible, and provides
    //the relevant explanation
    public void addItem() {

    }

    //MODIFIES: this
    //EFFECT: removes an item from the inventory if possible, and provides
    //the relevant explanation
    public void removeItem() {

    }

    //EFFECT: displays the current items in the inventory with all their
    //relevant details
    public void displayInventory(boolean includeIDs) {

    }

}

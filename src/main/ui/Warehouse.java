package main.ui;

import main.model.*;
import java.util.*;

//represents the warehouse
public class Warehouse {

    Inventory inventory;
    Scanner scanner;

    public Warehouse() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
        menu();
    }

    //MODIFIES: this
    //EFFECT: outputs the menu and takes the user input, after which
    //it calls the function to handle the user input
    public void menu() {
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("Note: Enter ! to return to the menu at any point of time");
            System.out.println("1. Display the inventory (with IDs)");
            System.out.println("2. Display the inventory summary (without IDs)");
            System.out.println("3. Add an item to the inventory");
            System.out.println("4. Remove an item from the inventory (identifying with ID)");
            System.out.println("5. Change an item's information (identifying with ID)");
            System.out.println("6. Save current warehouse status");
            System.out.println("7. Quit application");
            int choice = Integer.parseInt(scanner.next());
            choiceHandler(choice);
        }
    }

    //MODIFIES: this
    //EFFECT: handles the choice entered by the user on the menu screen by
    //carrying out the appropriate action.
    public void choiceHandler(int choice) {
        if (choice == 1) {
            displayInventory(false);
        } else if (choice == 2) {
            displayInventory(true);
        } else if (choice == 3) {
            addItem();
        } else if (choice == 4) {
            removeItem();
        } else if (choice == 7) {
            scanner.close();
            System.exit(0);
        } else {
            System.out.println("Please enter a valid choice.");
        }
    }

    //EFFECT: Displays the inventory's contents.
    public void displayInventory(boolean isSummary) {
        List<Item> items = inventory.getItems();
        if (items.size() == 0) {
            System.out.println("The inventory is currently empty.");
            return;
        }
        if (!isSummary) {
            for (Item i : items) {
                String out = "Name: " + i.getName() + ", ID: " + i.getID();
                out = out + "\nDescription: " + i.getDescription();
                System.out.println(out);
            }
        } else {
            Map<String, Integer> counts = new HashMap<>();
            for (Item i : items) {
                List<String> names = (List<String>) counts.keySet();
                if (!names.contains(i.getName())) {
                    counts.put(i.getName(), 1);
                } else {
                    int count = counts.get(i.getName()) + 1;
                    counts.put(i.getName(), count);
                }
            }
            List<String> keys = (List<String>) counts.keySet();
            for (String key : keys) {
                String out = key + " x " + counts.get(key);
            }
        }
    }

    //MODIFIES: this
    //EFFECT: adds an item to the inventory if possible, and provides
    //the relevant explanation
    public void addItem() {
        System.out.println("Please enter the name of the item you would like to add:");
        String name = scanner.next();
        checkMenu(name);
        System.out.println("Please enter the ID of the item you would like to add:");
        String id = scanner.next();
        checkMenu(id);
        while (inventory.findItemByID(id) != null) {
            System.out.println("ERROR: An item with this ID already exists.");
            System.out.println("Please re-enter the ID of the item you would like to add:");
            id = scanner.next();
            checkMenu(id);
        }
        System.out.println("Please enter the description of the item you would like to add:");
        String description = scanner.next();
        checkMenu(description);
        boolean added = inventory.addItem(new Item(id, name, description));
        if (!added) {
            System.out.println("ERROR: The item was not added to the inventory.");
        } else {
            System.out.println("The item was successfully added to the inventory!");
        }
    }

    //MODIFIES: this
    //EFFECT: removes an item from the inventory if possible, and provides
    //the relevant explanation
    public void removeItem() {
        if (inventory.getItemsCount() == 0) {
            System.out.println("There are no items to remove.");
            return;
        }
        System.out.println("Please enter the ID of the item you would like to remove from the inventory:");
        String id = scanner.next();
        checkMenu(id);
        boolean isRemoved = inventory.removeItem(id);
        while (isRemoved != true) {
            System.out.println("No item with this ID exists.");
            System.out.println("Please re-enter the ID of the item you would like to remove:");
            id = scanner.next();
            checkMenu(id);
            isRemoved = inventory.removeItem(id);
        }
        System.out.println("Item has been successfully removed!");
    }

    //EFFECT: checks if the user wants to go back to the main menu, and
    //responds accordingly.
    public void checkMenu(String input) {
        if (input == "!") {
            menu();
        }
    }
}

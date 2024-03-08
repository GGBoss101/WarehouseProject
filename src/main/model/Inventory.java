package main.model;

import java.util.*;

//represents the inventory for the warehouse

public class Inventory {

    ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECT: adds an item to the inventory and return true if successfully added,
    //and false if it was not added because an item with the same id already exists
    public boolean addItem(Item item) {
        Item i = findItemByID(item.getID());
        if (i != null) {
            return false;
        } else {
            items.add(item);
            return true;
        }
    }

    //MODIFIES: this
    //EFFECT: attempts to remove an item from the inventory and returns 0 if
    //there is no item to remove, 1 if the item does not exist in the inventory
    //and 2 if the item has been successfully removed
    public int removeItem(String id) {
        Item itemToRemove = findItemByID(id);
        if (items.size() == 0) {
            return 0;
        } else if (itemToRemove != null) {
            return 1;
        } else {
            items.remove(itemToRemove);
            return 2;
        }
    }

    //EFFECT: Searches for the item with the given ID and returns it
    //if found, and null otherwise
    public Item findItemByID(String id) {
        Item item = null;
        for (Item i : items) {
            if (item.getID() == id) {
                item = i;
            }
        }
        return item;
    }
}

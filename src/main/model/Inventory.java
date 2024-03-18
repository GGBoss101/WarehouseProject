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
            this.items.add(item);
            return true;
        }
    }

    //MODIFIES: this
    //EFFECT: attempts to remove an item from the inventory and returns true if
    //the item is successfully removed and false if not.
    public boolean removeItem(String id) {
        Item itemToRemove = findItemByID(id);
        if (itemToRemove != null) {
            int i = 0;
            for (Item item : this.items) {
                if (item.equals(itemToRemove)) {
                    this.items.remove(i);
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    //EFFECT: Searches for the item with the given ID and returns it
    //if found, and null otherwise
    public Item findItemByID(String id) {
        for (Item i : this.items) {
            if (i.getID().equals(id)) {
                return i;
            }
        }
        return null;
    }

    //EFFECT: returns the items currently stored in the inventory
    //as an array list
    public List<Item> getItems() {
        return this.items;
    }

    public int getItemsCount(){
        return items.size();
    }
}

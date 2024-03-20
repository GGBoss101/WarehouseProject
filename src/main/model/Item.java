package main.model;

//represents an item which can be stored in the warehouse inventory
public class Item {
    private String id;
    private String name;
    private String description;

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.description = desc;
    }

    //MODIFIES: this
    //EFFECT: changes the description of the item
    public void setDescription(String description) {
        this.description = description;
    }

    //MODIFIES: this
    //EFFECT: changes the name of the item
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES: this
    //EFFECT: sets the ID of the item and returns true or false if it was set
    //successfully or not respectively.
    public boolean setID(Inventory inventory, String id) {
        Item item = inventory.findItemByID(id);
        if (item != null) {
            return false;
        } else {
            this.id = id;
            return true;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }
}

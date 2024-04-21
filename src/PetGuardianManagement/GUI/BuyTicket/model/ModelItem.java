package PetGuardianManagement.GUI.BuyTicket.model;

public class ModelItem {

    private int itemID;
    private String itemName;
    private long price;

    public ModelItem(int itemID, String itemName, long price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
    }

    public ModelItem() {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}

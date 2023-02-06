import java.util.ArrayList;
public class Item {
    private int itemID;
    private String description;

    ArrayList<Item> itemList = new ArrayList<Item>();

    public Item() {}

    public Item(int itemID, String description) {
        this.itemID = itemID;
        this.description = description;
    }
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
    public void AddItem(Item item){
        itemList.add(item);
    }
    public void Remove(Item item){
        itemList.remove(item);
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", description='" + description + '\'' +
                '}';
    }


}

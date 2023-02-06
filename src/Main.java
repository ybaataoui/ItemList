import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Item> itemList; //Declare a list of Items

    static Item item = new Item(); // Create an instance of Item class.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("\n******** To Do List Application ********");
        System.out.println("----------------------------------------\n");
        System.out.println("What would you like to do?");

        while(choice != 5) {
            // call the menu function
            System.out.println();
            choice = Menu();

            itemList = item.getItemList();

            switch (choice){
                case 1:
                    PrintItemsList(itemList);
                    break;
                case 2:
                    CreateNewItem(itemList);//Add the new item created by CreateNewItem function to the list of to do items.
                    break;
                case 3:
                    Item deleteItem = DeleteItem(itemList);
                    item.Remove(deleteItem); //Delete a car from the list
                    System.out.println("Item " + deleteItem.getDescription() + " is deleted");
                    break;
                case 4:
                    UpdateToDoItem(itemList);
                    break;
                default:
                    System.out.println("Your choice is incorrect Please select a valid number from the list.");
                    break;
            }

        }

    }

    //Method that display a menu, take user input, check if the input is a number and return the number.
    public static int Menu() {
        int choice = 0;
        boolean isInteger = false;

        while(!isInteger){
            Scanner sc = new Scanner(System.in);
            System.out.println("1. View list.");
            System.out.println("2. Add  to list.");
            System.out.println("3. Remove item from list.");
            System.out.println("4. Update item in the list.");
            System.out.println("5. Exit.");
            System.out.print("   Choose an option: ");

            if(sc.hasNextInt()) { // check if the user entry is a number
                choice = sc.nextInt();
                isInteger = true;
            }
        }
        return choice;
    }
    //Display all items in the list
    public static void PrintItemsList(ArrayList<Item> itemList) {
        if(itemList.size() == 0){
            System.out.println("There is no item int the list.");
        }else{
            System.out.println("    ----------------------");
            for(Item item1 : itemList){
                System.out.println("    " + item1.getItemID() + ".  " + item1.getDescription() +"");
            }
            System.out.println("");
        }
    }

    //Create a new Item.
    public static void CreateNewItem(ArrayList<Item> itemList){
        Scanner sc = new Scanner(System.in);
        int ID;
        String description;
        boolean isZero = true;
        System.out.print("   Enter 0 to return. \n");
        System.out.print("   Enter Item and click enter: ");
        while(isZero){
            description = sc.nextLine();
            if(description.equals("0")){
                isZero = false;
            }else{
                if(itemList.size() == 0) {
                    ID = 1;
                } else{
                    ID = itemList.size() + 1;
                }
                Item newItem = new Item(ID, description);
                item.AddItem(newItem);
            }

        }
    }
    //Delete an item from the list.
    public static Item DeleteItem(ArrayList<Item> itemList){
        Scanner sc = new Scanner(System.in);
        Item item = new Item();

        if(itemList.size() == 0) { // check is the list is empty
            System.out.println("There is no item in the list.");
        } else{
            System.out.println("    Select item from the List to delete:");
            for(Item item1 : itemList){
                System.out.println("    " + item1);
            }
            int userInput = sc.nextInt();
            for(int i = 0; i < itemList.size(); i++){
                if(itemList.get(i).getItemID() == userInput){
                    item = itemList.get(i);
                }
            }
        }
        return item;
    }
    //Update an item in the list
    public static void UpdateToDoItem(ArrayList<Item> itemList) {
        Scanner sc = new Scanner(System.in);

        if(itemList.size() == 0) { // check is the list is empty
            System.out.println("There is no item in the list.");
        } else{
            for(Item item1 : itemList){
                System.out.println("    " + item1);
            }
            System.out.println("\nPlease select an item from the list:");
            int updateID = sc.nextInt();
            for(int i = 0; i < itemList.size(); i++){
                if(itemList.get(i).getItemID() == updateID){ // check if the id entered by the user is on the list.
                    System.out.println("Enter new Item");
                    String newDescription = sc.next();
                    itemList.get(i).setDescription(newDescription);
                }
            }

        }

    }

}
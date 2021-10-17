package UI;

import Dto.Change;
import Dto.Item;
import java.util.List;
import java.util.Scanner;

public class UserConsoleInterface implements IUserInterface{

    private Scanner console = new Scanner(System.in);

    @Override
    public void showItems(List<Item> items){
        showMessage("Here are the Items:");
        for (Item item : items) {
            String inventory = String.format("%s | Cost: £%s | Stock: %s",
                    item.getName(),
                    item.getCost(),
                    item.getStock());
            showMessage(inventory);
        }
        showMessage("");
    }

    @Override
    public String putAmount() {
        String amount = readString("Please put your amount in the machine:");
        return amount;
    }

    @Override
    public String selectItem() {
        String name = readString("Please select the item through the name:");
        return name;
    }

    @Override
    public void showChange(Change change) {
        String message = String.format("Take the change:\n Quarters: %s \n Dimes: %s \n Nickels: %s \n Pennies: %s",
                change.getQuarters() ,
                change.getDimes(),
                change.getNickels(),
                change.getPennies());
        showMessage(message);
    }


    @Override
    public void showMessage(String message){
        System.out.println(message);
    }

    private String readString(String message) {
        System.out.println(message);
        return console.nextLine();
    }
}

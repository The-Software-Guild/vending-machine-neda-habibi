package UI;

import Dto.Change;
import Dto.Item;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserConsoleInterface implements IUserInterface{

    private Scanner console = new Scanner(System.in);

    @Override
    public void showItems(List<Item> items){
        for (Item item : items) {
            String inventory = String.format("Name: %s | Cost: %s | Stock: %s",
                    item.getName(),
                    item.getCost(),
                    item.getStock());
            showMessage(inventory);
        }
        System.out.println("");
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
        String message = String.format("Quarters: %s | Dimes: %s | Nickels: %s | Pennies: %s",
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

    private LocalDate readDate(String msgPrompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean invalidInput = true;
        LocalDate releaseDate = null;
        do{
            try {
                String date = readString(msgPrompt);
                releaseDate = LocalDate.parse(date, formatter);
                invalidInput = false;

            } catch (DateTimeException e) {
                showMessage("Input error. Please try again.");
            }

        } while(invalidInput);

        return releaseDate;
    }
}

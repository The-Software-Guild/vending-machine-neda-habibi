package Controller;

import Dao.IItemDao;
import Dto.Change;
import Dto.Enums.Coin;
import Dto.Item;
import UI.IUserInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ItemController {

    private IItemDao itemDao;
    private IUserInterface userInterface;

    public ItemController(IUserInterface userInterface, IItemDao itemDao) {
        this.userInterface = userInterface;
        this.itemDao = itemDao;
    }

    public void run() throws IOException {
        boolean exit = false;
        List<Item> items =  itemDao.getAllItems();
        while(!exit) {
            List<Item> StockItems = items.stream().filter(p -> p.getStock() > 0).toList();
            userInterface.showItems(StockItems);
            String input = userInterface.putAmount();
            float amount;

            try{
                amount = Float.parseFloat(input);
            }
            catch (Exception ex){
                userInterface.showMessage("Invalid amount!");
                continue;
            }

            String itemName = userInterface.selectItem();

           Item selectedItem =  itemDao.getItem(itemName.toLowerCase(Locale.ROOT));

           if(selectedItem == null){
               userInterface.showMessage("Invalid item!");
               continue;
           }

           if (selectedItem.getCost() > amount){
               userInterface.showMessage("Insufficient Amount!");
               userInterface.showMessage("Here is your amount: £" + amount);
               continue;
           }

           itemDao.updateStock(selectedItem.getName(),selectedItem.getStock() - 1);
           userInterface.showChange(getChange(amount,selectedItem.getCost()));
        }
    }

    Change getChange(float amount, float cost) {
        int remainingInPence = (int)((amount - cost)*100);
        if (remainingInPence <= 0){
            return new Change();
        }

        Change change = new Change();;
        change.setQuarters(remainingInPence / Coin.QUARTER.value());
        remainingInPence = remainingInPence % Coin.QUARTER.value();
        if(remainingInPence == 0){
            return  change;
        }
        change.setDimes(remainingInPence / Coin.DIME.value());
        remainingInPence = remainingInPence % Coin.DIME.value();
        if(remainingInPence == 0){
            return  change;
        }
        change.setNickels(remainingInPence / Coin.NICKLE.value());
        remainingInPence = remainingInPence % Coin.NICKLE.value();
        if(remainingInPence == 0){
            return  change;
        }
        change.setPennies(remainingInPence);
        return  change;
    }
}

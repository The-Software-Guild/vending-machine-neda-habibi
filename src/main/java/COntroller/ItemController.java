package Controller;

import Dao.IItemDao;
import Dto.Change;
import Dto.Item;
import UI.IUserInterface;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

public class ItemController {

    private IItemDao itemDao;
    private IUserInterface userInterface;

    public ItemController(IUserInterface userInterface, IItemDao itemDao) {
        this.userInterface = userInterface;
        this.itemDao = itemDao;
    }

    public void run() throws FileNotFoundException {
        boolean exit = false;
        List<Item> items =  itemDao.getAllItems();
        while(!exit) {
            userInterface.showItems(items);
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
               continue;
           }

           userInterface.showChange(getChange(amount,selectedItem.getCost()));
        }
    }
    Change getChange(float amount, float cost) {
        return new Change();
    }
}

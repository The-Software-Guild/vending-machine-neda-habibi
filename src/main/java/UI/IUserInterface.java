package UI;

import Dto.Change;
import Dto.Item;
import java.util.List;

public interface IUserInterface {

    void showItems(List<Item> items);

    void showMessage(String message);

    String putAmount();

    void showChange(Change change);

}

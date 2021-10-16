package Dao;

import Dto.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IItemDao {

    boolean updateStock(String name, int stock) throws IOException;

    List<Item> getAllItems() throws FileNotFoundException;

    Item getItem(String name);
}

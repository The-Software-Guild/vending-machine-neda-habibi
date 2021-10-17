package Dao;

import Dto.Item;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ItemDao implements IItemDao{

    private static final String FILE_NAME = "Items.txt";
    private static final String SEPARATOR = "::";
    private List<Item> items = new ArrayList<Item>();

    @Override
    public boolean updateStock(String name, int stock) throws IOException {
        Item item = getItem(name);
        boolean found = items.remove(item);

        if(!found){
            return  false;
        }

        item.setStock(stock);
        items.add(item);
        writeToFile();
        return true;
    }

    @Override
    public List<Item> getAllItems() throws FileNotFoundException {
        readAll();
        return items;
    }

    @Override
    public Item getItem(String name) {
        return items.stream().filter(p -> p.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }

    private void writeToFile() throws IOException {
        PrintWriter out;

        out = new PrintWriter(new FileWriter(FILE_NAME));

        for (Item item : items) {
            String serializedObject = marshall(item);
            out.println(serializedObject);
            out.flush();
        }

        out.close();
    }

    private void readAll() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));
        items.clear();
        while (scanner.hasNextLine()) {
            String serializedDvd = scanner.nextLine();
            Item item = unmarshall(serializedDvd);
            items.add(item);
        }

        scanner.close();
    }

    private String marshall(Item item){
        String serializedObject = item.getName() + SEPARATOR;
        serializedObject += item.getCost() + SEPARATOR;
        serializedObject += item.getStock() + SEPARATOR;

        return serializedObject;
    }

    private Item unmarshall(String serializedDvd){
        String[] splitedItem = serializedDvd.split(SEPARATOR);
        Item dvdFromFile = new Item(splitedItem[0],
                                    Float.parseFloat( splitedItem[1]),
                                    Integer.parseInt(splitedItem[2])
                                    );

        return dvdFromFile;
    }
}

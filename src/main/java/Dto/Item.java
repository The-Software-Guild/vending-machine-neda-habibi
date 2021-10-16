package Dto;

public class Item {
    private String name;
    private int stock;
    private float cost;

    public Item(String name, float cost, int stock) {
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public float getCost() {
        return cost;
    }
}

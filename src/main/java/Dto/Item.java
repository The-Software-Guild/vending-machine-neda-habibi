package Dto;

import java.math.BigDecimal;

public class Item {
    private String name;
    private int stock;
    private BigDecimal cost;

    public Item(String name, BigDecimal cost, int stock) {
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getCost() {
        return cost;
    }
}

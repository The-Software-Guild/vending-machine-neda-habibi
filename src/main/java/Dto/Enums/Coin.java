package Dto.Enums;

public enum Coin {
    QUARTER(25),
    DIME(10),
    NICKLE(5),
    PENNY(1);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int value() { return value; }
}

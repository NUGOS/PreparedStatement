package ua.goit.preparedstatement.model;

public class PrintProjectPrice {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PrintProjectPrices{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

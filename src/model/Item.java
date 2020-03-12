package model;

import java.util.Objects;

public class   Item {

    private int id;
    private int price;


    public Item(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item - " +
                "Id=" + id +
                ", price=" + price ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                price == item.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}

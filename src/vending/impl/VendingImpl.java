package vending.impl;

import config.Config;
import exception.ItemNotFoundException;
import exception.InsertedMoneyNotEnoughException;
import model.Item;
import vending.api.Vending;

import java.util.List;

public class VendingImpl implements Vending {

    private Config config;
    private List<Item> items;

    public VendingImpl( ) {

        this.config = new Config();
        this.items = config.getItems();
    }

    @Override
    public void printItem() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
        System.out.println();
    }

    @Override
    public Integer getItem(Integer itemId, Integer coin) throws InsertedMoneyNotEnoughException, ItemNotFoundException {
        Item item = getItem(itemId);
        if (item.getPrice() > coin) {
            throw new InsertedMoneyNotEnoughException("Inserted money is not enough for that particular product!");
        }
        takeYourItem();
        return coin - item.getPrice();
    }

    public void takeYourItem() {
        System.out.println("Take your product");
    }

    private Item getItem(Integer itemId) throws ItemNotFoundException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == itemId) {
                return items.get(i);
            }
        }
        throw new ItemNotFoundException("Product not found");

    }
}

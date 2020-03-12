package vending.api;


import exception.InsertedMoneyNotEnoughException;
import exception.ItemNotFoundException;

public interface Vending {

    void printItem();

    Integer getItem(Integer itemId, Integer coin) throws InsertedMoneyNotEnoughException, ItemNotFoundException;

    void takeYourItem();
}

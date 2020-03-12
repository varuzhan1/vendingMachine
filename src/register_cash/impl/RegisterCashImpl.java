package register_cash.impl;

import registerCash.api.RegisterCash;

import config.Config;
import exception.CoinIsNotValidException;
import java.util.List;

public class RegisterCashImpl implements RegisterCash {

    private Integer balance;
    private Config config;
    private List<Integer> coins;


    public RegisterCashImpl() {
        this.balance = 0;
        this.config = new Config();
        this.coins = config.getCoin();
        ;
    }

    @Override
    public void takeYourChange() {
        System.out.println("Take your change- " + balance);
        balance = 0;
    }

    @Override
    public void takeYourCoin() {
        System.out.println("Take your coin- " + balance);
        balance = 0;
    }

    @Override
    public void isCoinValid(Integer coin) throws CoinIsNotValidException {
        boolean isCoinValid = false;
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).equals(coin)) {
                isCoinValid = true;
            }
        }
        if (isCoinValid == true) {
            balance = coin;
        } else {
            throw new CoinIsNotValidException("Coin is not accepted");
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


}

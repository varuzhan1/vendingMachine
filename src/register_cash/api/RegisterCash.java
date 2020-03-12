package registerCash.api;

import exception.CoinIsNotValidException;

public interface RegisterCash {

    void takeYourChange();

    void takeYourCoin();

    void isCoinValid(Integer coin) throws CoinIsNotValidException;

    void setBalance(Integer change);
}

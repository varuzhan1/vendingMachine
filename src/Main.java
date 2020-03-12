import config.Config;
import exception.CoinIsNotValidException;
import exception.InsertedMoneyNotEnoughException;
import exception.ItemNotFoundException;
import register_cash.impl.RegisterCashImpl;
import java.util.Scanner;
import vending.api.Vending;
import vending.impl.VendingImpl;

public class Main {

    private static Config config = new Config();
    private static Scanner scanner = new Scanner(System.in);
    private static Vending vending = new VendingImpl(config.getItems());
    private static registerCash.api.RegisterCash registerCash = new RegisterCashImpl(config.getCoin());



    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            vending.printItem();
            System.out.println("Enter the amount");
            String coin = scanner.nextLine();
            try {
                registerCash.isCoinValid(Integer.parseInt(coin));
                System.out.println("Enter the item Id");
                String itemId = scanner.nextLine();
                try {
                    Integer change = vending.getItem(Integer.parseInt(itemId), Integer.parseInt(coin));
                    registerCash.setBalance(change);
                    registerCash.takeYourChange();
                } catch (InsertedMoneyNotEnoughException e) {
                    System.err.println(e.getMessage());
                    registerCash.takeYourCoin();
                } catch (ItemNotFoundException e) {
                    System.err.println(e.getMessage());
                    registerCash.takeYourCoin();
                }
            } catch (CoinIsNotValidException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

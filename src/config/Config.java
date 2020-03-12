package config;

import model.Item;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Config {

    private String fileName;


    public Config(   ) {
        this.fileName =  "src\\resources\\config.properties";
    }
    public Config(String fileName) {
        this.fileName = fileName;
    }

    public String getProperty(String key) {
        Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        List<String> property = Arrays.asList(getProperty("items").split(";"));
        for (int i = 0; i < property.size(); i++) {
            List<String> value = Arrays.asList(property.get(i).split(","));
            items.add(new Item(Integer.parseInt(value.get(0)), Integer.parseInt(value.get(1))));
        }
        return items;
    }

    public List<Integer> getCoin() {
        List<Integer> coins = new ArrayList<>();
        List<String> property = Arrays.asList(getProperty("coin").split(","));
        for (int i = 0; i < property.size(); i++) {
            coins.add(Integer.parseInt(property.get(i)));
        }
        return coins;
    }

}
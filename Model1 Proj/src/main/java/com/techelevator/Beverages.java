package com.techelevator;

public class Beverages extends Product{
    public Beverages(String name, double price, int items_quantity) {
        super(name, price, items_quantity);
    }
    @Override
    public String displayMessage() {
        return "Glug Glug,Yum!";

    }


}

package com.techelevator;

public class Gum extends Product{
    public Gum(String name, double price, int items_quantity) {
        super(name, price, items_quantity);
    }

    @Override
    public String displayMessage() {
        return "Chew Chew, Yum!";
    }

}

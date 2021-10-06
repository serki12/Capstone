package com.techelevator;

public class Candy extends Product{
    public Candy(String name, double price, int items_quantity) {
        super(name, price, items_quantity);
    }

    @Override
    public String displayMessage() {
        return "Munch Munch, Yum!";
    }

}

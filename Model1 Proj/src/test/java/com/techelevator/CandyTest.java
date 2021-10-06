package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

    @Test

    public void displayCorrectMessage() {

        Candy testCandy = new Candy("Kitkat", .99, 5);
        String expectedValue = "Munch Munch, Yum!";
        String actualValue = testCandy.displayMessage();

        Assert.assertEquals("Incorrect message", expectedValue,actualValue);







    }

}


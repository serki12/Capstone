package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class BeveragesTest {

    @Test

    public void displayCorrectMessage() {

        Beverages testBeverages = new Beverages("Water",.99,5);

        String expectedValue = "Glug Glug,Yum!";
        String actualValue = testBeverages.displayMessage();

        Assert.assertEquals("Incorrect Message", expectedValue,actualValue);
    }
}

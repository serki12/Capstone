package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {

    @Test

    public void displayCorrectMessage() {
        Chips testChips = new Chips("Cheetos", .99, 5);

        String expectedValue = "Crunch Crunch, Yum!";
        String actualValue = testChips.displayMessage();

        Assert.assertEquals("Incorrect message", expectedValue,actualValue);
    }
}

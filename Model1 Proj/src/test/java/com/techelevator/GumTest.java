package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {

    @Test

    public void GumCorrectMessage() {

        Gum testGum = new Gum("JuiceFruit", 1.12, 5);
        String expectedValue = "Chew Chew, Yum!";
        String actualValue = testGum.displayMessage();

        Assert.assertEquals ("Incorrect Message", expectedValue, actualValue);
    }
}

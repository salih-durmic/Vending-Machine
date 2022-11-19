package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
private Item itemtest;

@Before
    public void setup() {itemtest = new Item("A1","U-Chews", 1.65, "Gum");}

    @Test
    public void assert_itemtest_returns_correct_slot(){
        String expectedResult = "A1";
        String actualResult = itemtest.getSlot();
        Assert.assertEquals("itemtest should return getter", expectedResult, actualResult);
    }

    @Test
    public void assert_itemtest_returns_correct_name(){
        String expectedResult = "U-Chews";
        String actualResult = itemtest.getName();
        Assert.assertEquals("itemtest should return getter", expectedResult, actualResult);
    }

    @Test
    public void assert_itemtest_returns_correct_price(){
        double expectedResult = 1.65;
        double actualResult = itemtest.getPrice();
        Assert.assertEquals("itemtest should return getter", expectedResult, actualResult, 0.0000009);
    }

    @Test
    public void assert_itemtest_returns_correct_type(){
        String expectedResult = "Gum";
        String actualResult = itemtest.getType();
        Assert.assertEquals("itemtest should return getter", expectedResult, actualResult);
    }

}

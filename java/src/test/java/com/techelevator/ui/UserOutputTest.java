package com.techelevator.ui;

import com.techelevator.models.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserOutputTest {
    private UserOutput useroutputtest;

    @Before
    public void setup() {useroutputtest = new UserOutput();}

    @Test
    public void assert_useroutputtest_returns_correct_change(){
        UserInput.setMoney(43.50);
        String expectedResult = "Your change is 0.0 hundred dollar bills, 0.0 fifty dollar bills, 2.0 twenty dollar bills, 0.0 ten dollar bills, 0.0 five dollar bills, 3.0 one dollar bills, 2.0 quarters, 0.0 dimes, and 0.0 nickels.";
        String actualResult = useroutputtest.moneyReturn();
        Assert.assertEquals("useroutputtest should return 2 twenties, 3 singles, and 2 quarters", expectedResult, actualResult);
    }
}

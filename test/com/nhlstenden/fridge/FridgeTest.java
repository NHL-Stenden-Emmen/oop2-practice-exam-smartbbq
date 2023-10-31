package com.nhlstenden.fridge;

import com.nhlstenden.food.Sausage;
import com.nhlstenden.food.Corn;
import com.nhlstenden.food.Hamburger;
import com.nhlstenden.food.BellPepper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FridgeTest
{
    @BeforeEach
    void setup()
    {
        // Because we are dealing with a so-called singleton you need to empty the fridge before each test
        Fridge.getInstance().clear();
    }

    @Test
    void getNextMeat_twoHamburgers_shouldGetCorrectHamburger() throws NoMoreFoodException, FridgeIsEmptyException
    {
        Hamburger hamburger = new Hamburger();

        Fridge.getInstance().addFood(new BellPepper());
        Fridge.getInstance().addFood(hamburger);
        Fridge.getInstance().addFood(new Corn());
        Fridge.getInstance().addFood(new Hamburger());

        assertEquals(hamburger, Fridge.getInstance().getNextMeat());
    }

    @Test
    void getNextMeat_oneSausage_shouldGetSausage() throws NoMoreFoodException, FridgeIsEmptyException
    {
        Sausage sausage = new Sausage();

        Fridge.getInstance().addFood(new BellPepper());
        Fridge.getInstance().addFood(new Corn());
        Fridge.getInstance().addFood(sausage);
        Fridge.getInstance().addFood(new Hamburger());

        assertEquals(sausage, Fridge.getInstance().getNextMeat());
    }
}
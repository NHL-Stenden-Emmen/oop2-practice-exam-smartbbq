package com.nhlstenden;

import com.nhlstenden.food.meat.Hamburger;
import com.nhlstenden.food.meat.Meat;
import com.nhlstenden.food.meat.Sausage;
import com.nhlstenden.food.vegetable.BellPepper;
import com.nhlstenden.food.vegetable.Corn;
import com.nhlstenden.fridge.FridgeIsEmptyException;
import com.nhlstenden.fridge.NoMoreFoodException;
import com.nhlstenden.fridge.Fridge;
import com.nhlstenden.thermometer.Thermometer;

public class Main
{
    public static void main(String[] args)
    {
        SmartBBQ bbq = new SmartBBQ();
        Thermometer thermometer = new Thermometer();
        Meat meat;

        Fridge.getInstance().addFood(new Hamburger());
        Fridge.getInstance().addFood(new Sausage());
        Fridge.getInstance().addFood(new Hamburger());
        Fridge.getInstance().addFood(new Sausage());
        Fridge.getInstance().addFood(new Sausage());
        Fridge.getInstance().addFood(new Corn());
        Fridge.getInstance().addFood(new Corn());
        Fridge.getInstance().addFood(new Corn());
        Fridge.getInstance().addFood(new BellPepper());
        Fridge.getInstance().addFood(new BellPepper());

        try
        {
            meat = Fridge.getInstance().getNextMeat();

            bbq.addFood(meat);
            bbq.addFood(Fridge.getInstance().getNextMeat());
            bbq.turnOn(180);

            thermometer.measure(meat);
            bbq.setTemperature(200);
            thermometer.measure(meat);
        }
        catch (FridgeIsEmptyException e)
        {
            System.out.println("There is no more food in the fridge!");
        }
        catch (NoMoreFoodException e)
        {
            System.out.println("There is no more meat in the fridge!");
        }
    }
}

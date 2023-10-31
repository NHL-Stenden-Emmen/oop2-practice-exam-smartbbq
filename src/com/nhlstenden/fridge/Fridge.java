package com.nhlstenden.fridge;

import com.nhlstenden.food.Food;
import com.nhlstenden.food.Meat;
import com.nhlstenden.food.Vegetable;
import com.nhlstenden.thermometer.Measurable;

import java.util.ArrayList;

public class Fridge implements Measurable
{
    private enum FoodType
    {
        MEAT,
        VEGETABLE
    }

    private static Fridge instance;
    private int temperature;
    private final ArrayList<Food> foodInFridge;

    private Fridge()
    {
        this.temperature = 8;
        this.foodInFridge = new ArrayList<>();
    }

    public static Fridge getInstance()
    {
        if (null == instance)
        {
            instance = new Fridge();
        }

        return instance;
    }

    @Override
    public double getTemperature()
    {
        return this.temperature;
    }

    public ArrayList<Food> getFoodInFridge()
    {
        return this.foodInFridge;
    }

    public void addFood(Food food)
    {
        this.foodInFridge.add(food);
    }

    public Meat getNextMeat() throws FridgeIsEmptyException, NoMoreFoodException
    {
        return (Meat) getNextItem(FoodType.MEAT);
    }

    public Vegetable getNextVegetable() throws FridgeIsEmptyException, NoMoreFoodException
    {
        return (Vegetable) getNextItem(FoodType.VEGETABLE);
    }

    private Food getNextItem(FoodType type) throws FridgeIsEmptyException, NoMoreFoodException
    {
        // Check if there is any food in fridge
        if (this.foodInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException();
        }

        for (int i = 0; i < this.foodInFridge.size(); i++)
        {
            Food food = this.foodInFridge.get(i);
            switch (type)
            {
                case MEAT:
                    if (food instanceof Meat)
                    {
                        // Remove the meat from the fridge and return it
                        return this.foodInFridge.remove(i);
                    }
                    break;
                case VEGETABLE:
                    if (food instanceof Vegetable)
                    {
                        return this.foodInFridge.remove(i);
                    }
                    break;
                default:
                    break;
            }

        }

        throw new NoMoreFoodException(type.name());
    }

    /**
     * For Unit testing.
     */
    public void clear()
    {
        this.foodInFridge.clear();
    }
}

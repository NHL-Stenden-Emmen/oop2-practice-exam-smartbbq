package com.nhlstenden.fridge;

public class NoMoreFoodException extends Throwable
{
    public NoMoreFoodException(String type)
    {
        super("There is no food of type " + type + "...");
    }
}

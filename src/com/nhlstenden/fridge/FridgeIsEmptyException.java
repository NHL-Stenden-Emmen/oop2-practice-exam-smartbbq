package com.nhlstenden.fridge;

public class FridgeIsEmptyException extends Throwable
{
    public FridgeIsEmptyException()
    {
        super("The fridge is empty....");
    }
}

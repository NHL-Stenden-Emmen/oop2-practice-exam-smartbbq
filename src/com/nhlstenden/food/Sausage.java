package com.nhlstenden.food;

public class Sausage extends Meat
{
    public Sausage()
    {
        super(MeatType.PIG, 80.0, 0.05);
    }

    @Override
    public String toString()
    {
        return "Sausage";
    }
}

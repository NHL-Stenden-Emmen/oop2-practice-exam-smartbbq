package com.nhlstenden.food;

public class Hamburger extends Meat
{
    public Hamburger()
    {
        super(MeatType.COW, 100.0, 0.06);
    }

    @Override
    public String toString()
    {
        return "Hamburger";
    }
}

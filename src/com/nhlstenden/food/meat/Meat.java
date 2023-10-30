package com.nhlstenden.food.meat;

import com.nhlstenden.food.Food;

public abstract class Meat extends Food
{
    protected double currentCookedPercentage;
    protected double cookedFactor;
    protected MeatType type;

    public Meat(MeatType type, double cookedFactor, double browningFactor)
    {
        super(browningFactor);
        this.currentCookedPercentage = 0.0;
        this.cookedFactor = cookedFactor;
        this.type = type;
    }

    public double getCurrentCookedPercentage()
    {
        return this.currentCookedPercentage;
    }

    public MeatType getType()
    {
        return this.type;
    }

    @Override
    public void grill(double temperature)
    {
        this.currentBrownPercentage += this.browningFactor * (temperature / 100);
        this.currentCookedPercentage += (1 / (this.cookedFactor * Math.PI) * temperature);
    }
}

package com.nhlstenden.food;

import com.nhlstenden.thermometer.Measurable;

public abstract class Food implements Measurable
{
    protected double currentTemperature;
    protected double currentBrownPercentage;
    protected double browningFactor;

    public Food(double browningFactor)
    {
        this.currentBrownPercentage = 0.0;
        this.browningFactor = browningFactor;
    }

    public double getCurrentTemperature()
    {
        return this.currentTemperature;
    }

    public double getCurrentBrownPercentage()
    {
        return this.currentBrownPercentage;
    }

    @Override
    public double getTemperature()
    {
        return this.currentTemperature;
    }

    public abstract void grill(double temperature);
}

package com.nhlstenden;

import com.nhlstenden.food.Food;
import com.nhlstenden.thermometer.Measurable;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SmartBBQ extends TimerTask implements Measurable
{
    private final ArrayList<Food> food;
    private int temperature;
    private Timer timer;

    public SmartBBQ()
    {
        this.food = new ArrayList<>();
        this.temperature = 0;
    }

    public double getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        if (temperature > 250)
        {
            this.temperature = 250;
            return;
        }

        this.temperature = temperature;
    }

    public ArrayList<Food> getFood()
    {
        return this.food;
    }

    public void addFood(Food food)
    {
        this.food.add(food);
    }

    public void turnOn(int temperature)
    {
        this.temperature = temperature;
        this.timer = new Timer();
        this.timer.schedule(this, 0, 1000);
    }

    public void turnOff()
    {
        this.temperature = 0;
        this.timer.cancel();
        this.timer = null;
    }

    @Override
    public void run()
    {
        for (Food food : this.food)
        {
            food.grill(this.temperature);
        }
    }
}

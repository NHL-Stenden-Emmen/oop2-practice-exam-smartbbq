package com.nhlstenden.thermometer;

public class Thermometer
{
    public ThermometerResult measure(Measurable measurable)
    {
        return new ThermometerResult(measurable.getTemperature());
    }
}

package com.nhlstenden.thermometer;

public class ThermometerResult
{
    private final double temperature;

    public ThermometerResult(double temperature)
    {
        this.temperature = temperature;
    }

    public String getTemperature()
    {
        return "I measured a temperature of " + this.temperature + " degrees Celsius.";
    }

    public TemperatureClassification getTemperatureClassification()
    {
        if (this.temperature < 10.0) {
            return TemperatureClassification.COLD;
        } else if (this.temperature > 10 && this.temperature < 70) {
            return TemperatureClassification.MEDIUM;
        } else {
            return TemperatureClassification.HOT;
        }
    }
}

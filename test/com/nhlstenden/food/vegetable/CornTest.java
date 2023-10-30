package com.nhlstenden.food.vegetable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CornTest
{
    @Test
    void getMoistPercentage_grill180_expectDecrease()
    {
        Corn corn = new Corn();
        corn.grill(180.0);

        assertEquals(91.0, corn.getMoistPercentage());

        corn.grill(180.0);
        assertEquals(82.0, corn.getMoistPercentage());
    }
}
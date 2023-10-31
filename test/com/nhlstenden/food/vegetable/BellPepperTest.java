package com.nhlstenden.food.vegetable;

import com.nhlstenden.food.BellPepper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellPepperTest
{
    @Test
    void getMoistPercentage_grill180twice_expectDecrease()
    {
        BellPepper bellPepper = new BellPepper();
        bellPepper.grill(180.0);

        assertEquals(82.0, bellPepper.getMoistPercentage());

        bellPepper.grill(180.0);
        assertEquals(64.0, bellPepper.getMoistPercentage());
    }
}
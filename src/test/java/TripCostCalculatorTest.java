import org.junit.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TripCostCalculatorTest {


    @org.junit.jupiter.api.Test
    void testCalculateTripCost() {
        assertEquals(10.0, TripCostCalculator.calculateTripCost(100, 2, 5));
        assertEquals(20.0, TripCostCalculator.calculateTripCost(200, 2, 5));
        assertEquals(30.0, TripCostCalculator.calculateTripCost(300, 2, 5));
    }

}
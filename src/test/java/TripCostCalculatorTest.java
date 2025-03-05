import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripCostCalculatorTest {

    @Test
    public void calculateTripCost(){
        assertEquals(19, TripCostCalculator.calculateTripCost(19 ,1, 1));
    }
}
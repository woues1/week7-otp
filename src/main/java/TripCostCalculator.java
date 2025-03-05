public class TripCostCalculator {
    public static double calculateTripCost(double km, double fuelPrice, double fuelConsumption){
        double fuelNeeded = (km / 100) * fuelConsumption;
        return fuelNeeded * fuelPrice;


    }
}

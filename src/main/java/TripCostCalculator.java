import java.util.Scanner;

public class TripCostCalculator {
    public static double calculateTripCost(double km, double fuelPrice, double fuelConsumption){
        double fuelNeeded = (km / 100) * fuelConsumption;
        return fuelNeeded * fuelPrice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance in km: ");
        double km = sc.nextDouble();
        System.out.println("Enter the fuel price: ");
        double fuelPrice = sc.nextDouble();
        System.out.println("Enter the fuel consumption per 100 km: ");
        double fuelConsumption = sc.nextDouble();
        System.out.println("The cost of the trip is: " + calculateTripCost(km, fuelPrice, fuelConsumption));

    }
}

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TripCostCalculator {
    public static double calculateTripCost(double km, double fuelPrice, double fuelConsumption){
        double fuelNeeded = (km / 100) * fuelConsumption;
        return fuelNeeded * fuelPrice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select" +
                " language: 1 - farsi, " +
                "2 - Japanese" +
                "3 - Finnish");
        Locale locale;
        int lang = sc.nextInt();
        switch (lang){
            case 1:
                locale = new Locale("fa", "IR");
                break;
            case 2:
                locale = new Locale("ja", "JP");
                break;
            case 3:
                locale = new Locale("fi", "FI");
            default:
                locale = new Locale("fi", "FI");
        }

        ResourceBundle rb = null;
        try{
            rb = ResourceBundle.getBundle("messages", locale);
        }
        catch(Exception e){
            System.out.println("invalid selection");
            ResourceBundle.getBundle("messages", new Locale("fi", "FI"));
        }


        System.out.println(rb.getString("kilo"));
        double km = sc.nextDouble();
        System.out.println(rb.getString("price"));
        double fuelPrice = sc.nextDouble();
        System.out.println(rb.getString("price_KM"));
        double fuelConsumption = sc.nextDouble();
        String total = MessageFormat.format(rb.getString("total"), calculateTripCost(km, fuelPrice, fuelConsumption));
        System.out.println(total);
        //System.out.println("The cost of the trip is: " + calculateTripCost(km, fuelPrice, fuelConsumption));
    }
}

import java.util.Scanner;

/**
 * Created by artam on 12.05.2017.
 */
public class Main {

    public static double d;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Choose between DMS and decimal coordinates. If DMS press y. Type another symbol" +
                " for entering decimal coordinates. \n");

        String dmsCheck = console.nextLine();

        if (dmsCheck.equals("y")) {

            System.out.print("Enter Latitude Degrees A: ");
            double degLatA = console.nextDouble();

            System.out.print("Enter Latitude Minutes A: ");
            double minLatA = console.nextDouble();

            System.out.print("Enter Latitude Seconds A: ");
            double secLatA = console.nextDouble();

            System.out.print("Enter Longitude Degrees A: ");
            double degLongA = console.nextDouble();

            System.out.print("Enter Longitude Minutes A: ");
            double minLongA = console.nextDouble();

            System.out.print("Enter Longitude Seconds A: ");
            double secLongA = console.nextDouble();

            System.out.print("Enter Latitude Degrees B: ");
            double degLatB = console.nextDouble();

            System.out.print("Enter Latitude Minutes B: ");
            double minLatB = console.nextDouble();

            System.out.print("Enter Latitude Seconds B: ");
            double secLatB = console.nextDouble();

            System.out.print("Enter Longitude Degrees B: ");
            double degLongB = console.nextDouble();

            System.out.print("Enter Longitude Minutes B: ");
            double minLongB = console.nextDouble();

            System.out.print("Enter Longitude Seconds B: ");
            double secLongB = console.nextDouble();

            String lattitudeA = String.valueOf(dmsToDecimal(degLatA, minLatA, secLatA));
            String longitudeA = String.valueOf(dmsToDecimal(degLongA, minLongA, secLongA));
            String lattitudeB = String.valueOf(dmsToDecimal(degLatB, minLatB, secLatB));
            String longitudeB = String.valueOf(dmsToDecimal(degLongB, minLongB, secLongB));

            dmsToDecimal(degLongA, minLongA, secLongA);

            dmsToDecimal(degLatB, minLatB, secLatB);
            dmsToDecimal(degLongB, minLongB, secLongB);

            calcDistance(dmsToDecimal(degLatA, minLatA, secLatA), dmsToDecimal(degLongA, minLongA, secLongA),
                    dmsToDecimal(degLatB, minLatB, secLatB),
                    dmsToDecimal(degLongB, minLongB, secLongB));

            System.out.println("The distance between the two GPS coordinates (" + lattitudeA + ", " + longitudeA
                    + "; " + lattitudeB + ", " + longitudeB + ") is " +
                    d + " m");

        } else {

            System.out.println("Enter the Latitude and Longitude of 2 GPS coordinates (A, B) to calculate a distance.\n");

            //Entering initial values for latitudes and longitudes of two geo locations
            System.out.print("Enter a Latitude A (in degrees): ");
            double lat1 = console.nextDouble();

            System.out.print("Enter a Longitude A (in degrees): ");
            double lon1 = console.nextDouble();

            System.out.print("Enter a Latitude B (in degrees): ");
            double lat2 = console.nextDouble();

            System.out.print("Enter a Longitude B (in degrees): ");
            double lon2 = console.nextDouble();

            calcDistance(lat1, lon1, lat2, lon2);
            System.out.println("The distance between the two GPS coordinates (" + lat1 + ", " + lon1
                    + "; " + lat2 + ", " + lon2 + ") is " +
                    d + " m");
        }
    }

    //Calculation a distance between two GPS coordinates using haversine formula
    public static double calcDistance(double lat1, double lng1, double lat2, double lng2) {

        int R = 6371000;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        d = R * c;


        return d;
    }

    public static double dmsToDecimal(double d, double m, double s) {
        double dd = Math.signum(d) * (Math.abs(d) + (m / 60.0) + (s / 3600.0));

        return dd;
    }
}

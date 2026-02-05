import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class coordinatesDistance {
    //compute the distance between two coordinates in km
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    //convert degrees to radians
    public static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    //convert radians to degrees
    public static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    //main method
    public static void main(String[] args) {
        //test distance method

        //input coordinates using bufferedreader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the latitude of the first coordinate: ");
            double lat1 = Double.parseDouble(br.readLine());
            System.out.println("Enter the longitude of the first coordinate: ");
            double lon1 = Double.parseDouble(br.readLine());
            System.out.println("Enter the latitude of the second coordinate: ");
            double lat2 = Double.parseDouble(br.readLine());
            System.out.println("Enter the longitude of the second coordinate: ");
            double lon2 = Double.parseDouble(br.readLine());
            System.out.println("The distance between the two coordinates is " + distance(lat1, lon1, lat2, lon2) + " km.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

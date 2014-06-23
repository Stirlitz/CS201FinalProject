/*

Peter Fajner
2014-06-10

This is the main class.

*/

import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JTable;

/** Helps with physics labs by converting distance-time to velocity-time to acceleration-time.
*/
public class PhysicsLabSolver {

    public static void main(String[] args) {
        
        Scanner kInputInt = new Scanner(System.in);
        Scanner kInput = new Scanner(System.in);
        TablePrinter tablePrinter = new TablePrinter();
        MotionTypeIncreaser motionTypeIncreaser = new MotionTypeIncreaser();
        int numberOfPoints;

        // Acquire info about how many points there will be and what they should be rounded to
        System.out.print("How many data points will you be entering? ");
        numberOfPoints = kInputInt.nextInt();
        System.out.print("How many decimal places should the time values be rounded to? ");
        int timeDecimalPlaces = kInputInt.nextInt();
        System.out.print("How many decimal places should the motion values be rounded to? ");
        int motionDecimalPlaces = kInputInt.nextInt();

        // This is the principal array that stores time and distance values
        Double[][] distanceTimeArray = new Double[numberOfPoints][2];

        // Fill the array with time and distance values
        System.out.println("Press C to return to previous point.");
        for(int i = 0; i < numberOfPoints; i++) {
            System.out.print("Enter time for point #" + (i + 1) + ": ");
            String localInput = kInput.nextLine();
            // Check for the sentinel value; if not present, parse the Double and write it to the array as a time value
            if(localInput.toLowerCase().equals("c")) {
                i -= 2;
                continue;
            }
            else{
                distanceTimeArray[i][0] = new Double(Double.parseDouble(localInput));
            }
            // Check for the sentinel value; if not present, parse the Double and write it to the array as a distance value
            System.out.print("Enter distance for point #" + (i + 1) + ": ");
            localInput = kInput.nextLine();
            if(localInput.toLowerCase().equals("c")) {
                i -= 2;
                continue;
            }
            else{
                distanceTimeArray[i][1] = new Double(Double.parseDouble(localInput));
            }
        }

        tablePrinter.printTable(distanceTimeArray, "Distance", timeDecimalPlaces, motionDecimalPlaces); // Create and print distance table

        Double[][] velocityTimeArray = motionTypeIncreaser.increaseMotionType(distanceTimeArray); // Convert distance to velocity
        tablePrinter.printTable(velocityTimeArray, "Velocity", timeDecimalPlaces, motionDecimalPlaces); // Create and print velocity table

        Double[][] accelerationTimeArray = motionTypeIncreaser.increaseMotionType(velocityTimeArray); // Convert velocity to acceleration
        tablePrinter.printTable(accelerationTimeArray, "Acceleration", timeDecimalPlaces, motionDecimalPlaces); // Create and print acceleration table
    }
}
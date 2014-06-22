/*

Peter Fajner
2014-06-10

This is the main class.

*/

import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JTable;
/** Helps with physics labs by convert distance-time to velocity-time to acceleration-time.
*/
public class PhysicsLabSolver {

    public static void main(String[] args) {
        
        Scanner kInputInt = new Scanner(System.in);
        Scanner kInput = new Scanner(System.in);
        TablePrinter tablePrinter = new TablePrinter();
        MotionTypeIncreaser motionTypeIncreaser = new MotionTypeIncreaser();
        int numberOfPoints;

        System.out.print("How many data points will you be entering? ");
        numberOfPoints = kInputInt.nextInt();
        System.out.print("How many decimal places should the time values be rounded to? ");
        int timeDecimalPlaces = kInputInt.nextInt();
        System.out.print("How many decimal places should the motion values be rounded to? ");
        int motionDecimalPlaces = kInputInt.nextInt();
        System.out.println("Press C to return to previous point.");

        Double[][] distanceTimeArray = new Double[numberOfPoints][2];

        for(int i = 0; i < numberOfPoints; i++) {
            System.out.print("Enter time for point #" + (i + 1) + ": ");
            String localInput = kInput.nextLine();
            if(localInput.toLowerCase().equals("c")) {
                i -= 2;
                continue;
            }
            else{
                distanceTimeArray[i][0] = new Double(Double.parseDouble(localInput));
            }
            System.out.print("Enter value for point #" + (i + 1) + ": ");
            localInput = kInput.nextLine();
            if(localInput.toLowerCase().equals("c")) {
                i -= 2;
                continue;
            }
            else{
                distanceTimeArray[i][1] = new Double(Double.parseDouble(localInput));
            }
        }

        tablePrinter.printTable(distanceTimeArray, "Distance", timeDecimalPlaces, motionDecimalPlaces);

        Double[][] velocityTimeArray = motionTypeIncreaser.increaseMotionType(distanceTimeArray);
        tablePrinter.printTable(velocityTimeArray, "Velocity", timeDecimalPlaces, motionDecimalPlaces);

        Double[][] accelerationTimeArray = motionTypeIncreaser.increaseMotionType(velocityTimeArray);
        tablePrinter.printTable(accelerationTimeArray, "Acceleration", timeDecimalPlaces, motionDecimalPlaces);
    }
}
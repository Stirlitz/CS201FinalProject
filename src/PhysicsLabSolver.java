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
        int numberOfPoints;

        System.out.print("How many data points will you be entering? ");
        numberOfPoints = kInputInt.nextInt();
        System.out.print("How many decimal places should the time values be rounded to? ");
        int decimalsForTime = kInputInt.nextInt();
        System.out.print("How many decimal places should the motion values be rounded to? ");
        int decimalsForMotion = kInputInt.nextInt();

        Double[][] distanceTimeArray = new Double[numberOfPoints][2];

        for(int i = 0; i < numberOfPoints; i++) {
            System.out.print("Enter time for point #" + (i + 1) + ": ");
            distanceTimeArray[i][0] = new Double(kInput.nextDouble());
            System.out.print("Enter value for point #" + (i + 1) + ": ");
            distanceTimeArray[i][1] = new Double(kInput.nextDouble());

        }

        TablePrinter distanceTable = new TablePrinter(distanceTimeArray, "Distance");
        distanceTable.printTable();

        //System.out.println(Arrays.deepToString(distanceTimeArray));




    }
}
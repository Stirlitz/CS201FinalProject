/*

Peter Fajner
2014-06-16

*/

import javax.swing.*; 
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/** Prints out motion vs time table.
*/
public class TablePrinter {

    /** Rounds a time-motion array to a certain number of decimal places, and pads numbers with zeroes if necessary.
        @param inputArray time-motion array
        @param timeDecimalPlaces number of decimal places to round time values to
        @param motionDecimalPlaces number of decimal places to round motion values to
        @return the rounded time-motion array
    */
    public static String[][] round(Double[][] inputArray, int timeDecimalPlaces, int motionDecimalPlaces) {
        // New String[][] array, same size as input array
        String[][] outputArray = new String[inputArray.length][inputArray[0].length];
        // Rounds or pads time values, converting them into Strings
        for(int i = 0; i < outputArray.length; i++) {
            outputArray[i][0] = String.format("%." + timeDecimalPlaces + "f", inputArray[i][0]);
        }
        // Rounds or pads motion values, converting them into Strings
        for(int i = 0; i < outputArray.length; i++) {
            outputArray[i][1] = String.format("%." + motionDecimalPlaces + "f", inputArray[i][1]);
        }
        return outputArray;
    }

    /** Initializes table printer.
    */
    public TablePrinter() {};

    /** Prints table.
        @param motionTimeData motion-time array
        @param motionName motion type
        @param timeDecimalPlaces amount of decimal places to round or pad time to
        @param motionDecimalPlaces amount of decimal places to round or pad motion to
    */
    public void printTable(Double[][] motionTimeData, String motionName, int timeDecimalPlaces, int motionDecimalPlaces) {

        String[] columnNames = new String[]{"Time", motionName};
        Object[][] motionTimeRounded = round(motionTimeData, timeDecimalPlaces, motionDecimalPlaces);

        //Create and set up a window
        JFrame frame = new JFrame("Time vs " + motionName + " Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a table from the data
        JTable motionTimeTable = new JTable(motionTimeRounded, columnNames);

        // Necessary window operations for displaying table, courtesy of Oracle docs
        JScrollPane scrollPane = new JScrollPane(motionTimeTable);
        motionTimeTable.setFillsViewportHeight(true);
        frame.getContentPane().add(scrollPane);

        //Display the window
        frame.pack();
        frame.setVisible(true);

    }
}
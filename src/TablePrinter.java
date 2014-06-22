/*

Peter Fajner
2014-06-16

*/

import javax.swing.*; 
import java.math.BigDecimal;
import java.math.RoundingMode;

/** Prints out motion vs time tables.
*/
public class TablePrinter {

    private String[] columnNames;
    private Object[][] motionTimeData;
    private String motionName;

    public static Double[][] round(Double[][] inputArray, int timeDecimalPlaces, int motionDecimalPlaces) {
        Double[][] outputArray = inputArray;
        // Time
        for(int i = 0; i < outputArray.length; i++) {
            BigDecimal tempBigDecimal = new BigDecimal(outputArray[i][0]);
            tempBigDecimal = tempBigDecimal.setScale(timeDecimalPlaces, RoundingMode.HALF_UP);
            outputArray[i][0] = tempBigDecimal.doubleValue();
        }
        // Motion
        for(int i = 0; i < outputArray.length; i++) {
            BigDecimal tempBigDecimal = new BigDecimal(outputArray[i][1]);
            tempBigDecimal = tempBigDecimal.setScale(motionDecimalPlaces, RoundingMode.HALF_UP);
            outputArray[i][1] = tempBigDecimal.doubleValue();
        }
        return outputArray;
    }

    public TablePrinter(Double[][] motionTimeData, String motionName, int timeDecimalPlaces, int motionDecimalPlaces) {
        this.columnNames = new String[]{"Time", motionName};
        this.motionTimeData = round(motionTimeData, timeDecimalPlaces, motionDecimalPlaces);
        this.motionName = motionName;
    }

    public TablePrinter(Double[][] motionTimeData, String motionName) {
        this.columnNames = new String[]{"Time", motionName};
        this.motionTimeData = motionTimeData;
        this.motionName = motionName;
    }

    public void printTable() {

        //Create and set up the window.
        JFrame frame = new JFrame("Time vs " + motionName + " Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a table from the data
        JTable motionTimeTable = new JTable(motionTimeData, columnNames);

        // Necessary window operations
        JScrollPane scrollPane = new JScrollPane(motionTimeTable);
        motionTimeTable.setFillsViewportHeight(true);
        frame.getContentPane().add(scrollPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
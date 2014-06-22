/*

Peter Fajner
2014-06-16

*/

import javax.swing.*;

/** Prints out motion vs time tables.
*/
public class TablePrinter {

    private String[] columnNames;
    private Object[][] motionTimeData;
    private String motionName;

    public TablePrinter(Double[][] motionTimeData, String motionName) {
        this.columnNames = new String[]{"Time", motionName};
        this.motionTimeData = motionTimeData;
        this.motionName = motionName;

    }

    public void printTable() {

        //Create and set up the window.
        JFrame frame = new JFrame("Time vs " + motionName + " Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        //JLabel label = new JLabel("Hello World");
        //frame.getContentPane().add(label);

        JTable motionTimeTable = new JTable(motionTimeData, columnNames);
        JScrollPane scrollPane = new JScrollPane(motionTimeTable);
        motionTimeTable.setFillsViewportHeight(true);
        frame.getContentPane().add(scrollPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
/*

Peter Fajner
2014-06-15

*/

import javax.swing.JTable;
public class GraphDrawer {

    private double[] motionTimeArrayInitial;
    private String motionName;

    public GraphDrawer(double[] motionTimeArrayInitial, int decimalsForMotion, int decimalsForTime, String motionName) {
        this.motionTimeArrayInitial = new double[]{motionTimeArrayInitial};
        this.motionName = motionName;
    }

}
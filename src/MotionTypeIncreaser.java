/*

Peter Fajner
2014-06-10

*/

/** Changes Displacement into Velocity or Velocity into Acceleration.
*/
public class MotionTypeIncreaser {

    private double[] initialTimeArray, initialMotionArray;
    public MotionTypeIncreaser(double[] timeArrayInput, double[] motionArrayInput) {
        this.initialTimeArray = new double[]{timeArrayInput};
        this.initialMotionArray = new double[]{motionArrayInput};
    }
}
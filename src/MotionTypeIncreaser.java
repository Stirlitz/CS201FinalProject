/*

Peter Fajner
2014-06-10

*/

/** Changes Displacement into Velocity or Velocity into Acceleration.
*/
public class MotionTypeIncreaser {

    public MotionTypeIncreaser() {};

    public Double[][] increaseMotionType(Double[][] start) {
        Double[][] fin = new Double[start.length - 1][2];
        for(int i = 0; i < (start.length - 1); i++) {
            fin[i][0] = (start[i+1][0] + start[i][0]) / 2; // midtime = (t₁ + t₂) / 2
            fin[i][1] = (start[i+1][1] - start[i][1]) / (start[i+1][0] - start[i][0]); // v = (d₂ - d₁) / (t₂ - t₁) OR a = (v₂ - v₁) / (t₂ - t₁)
        }
        return fin;
    }
}
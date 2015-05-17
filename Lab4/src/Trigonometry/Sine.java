/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// sin()
public class Sine extends Cosine{
    public double Calc(double arg)
    {
        double r = super.Calc(Math.PI/2 - arg);
        if(Double.isNaN(r))
        {
            return Double.NaN;
        }
        else
        {
            return r; // //cos(pi/2-x)
        }
    }
}

/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// tan()

public class Tangent extends Cosine {
    public double Calc(double arg)
    {
        double r1 = super.Calc(Math.PI/2 - arg);
        double r2 = super.Calc(arg);
        if(Double.isNaN(r1) || Double.isNaN(r2))
        {
            return Double.NaN;
        }
        else
        {
            return r1/r2; //sin(x)/cos(x)=cos(pi/2-x)/cos(x)
        }
    }
}

/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// cot()
public class Cotangent extends Cosine {
    public double Calc(double arg)
    {
        double r1 = super.Calc(arg);
        double r2 = super.Calc(Math.PI/2 - arg);
        if(Double.isNaN(r1) || Double.isNaN(r2))
        {
            return Double.NaN;
        }
        else
        {
            return r1/r2; // cos(x)/sin(x)=cos(x)/cos(pi/2-x)
        }
    }
}

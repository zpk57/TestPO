/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// csc()
public class Cosecant extends Cosine{
    public double Calc(double arg)
    {
        double r = super.Calc(Math.PI/2 - arg);
        if(Double.isNaN(r))
        {
            return Double.NaN;
        }
        else
        {
            return (double)1/r; // 1/sin(x)=1/cos(pi/2-x)
        }
    }
}

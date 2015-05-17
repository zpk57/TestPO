/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// sec()
public class Secant extends Cosine{
    public double Calc(double arg)
    {
        double r = super.Calc(arg);
        if(Double.isNaN(r))
        {
            return Double.NaN;
        }
        else
        {
            return (double)1/r; // 1/cos(x)
        }
    }
}

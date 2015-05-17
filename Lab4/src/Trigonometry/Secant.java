/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;

import Sources.FakeSettings;

// sec()
public class Secant extends Cosine{
    boolean fake;
    public Secant()
    {
        fake = FakeSettings.fakeCosecant;
    }
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

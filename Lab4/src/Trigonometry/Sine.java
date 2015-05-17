/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;

import Sources.FakeSettings;

// sin()
public class Sine extends Cosine{
    boolean fake;
    public Sine()
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
            return Math.sqrt(1-r*r); // sqrt(1-cos(x)^2)
        }
    }
}

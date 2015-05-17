/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;

import Sources.FakeSettings;

// cot()
public class Cotangent extends Cosine {
    boolean fake;
    public Cotangent()
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
            return r/Math.sqrt(1-r*r); // cos(x)/sin(x)=cos(x)/sqrt(1-cos(x)^2)
        }
    }
}

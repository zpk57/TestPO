/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// tan()

import Sources.FakeSettings;

public class Tangent extends Cosine {
    boolean fake;
    public Tangent()
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
            return Math.sqrt(1-r*r)/r; //sin(x)/cos(x)=sqrt(1-cos(x)^2)/cos(x)
        }
    }
}

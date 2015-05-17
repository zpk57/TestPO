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
    public double calcFuncTan(double arg)
    {
        double r = super.Calc(arg);
        if (Double.isNaN(r))
        {
            return Double.NaN;
        } else
        {
            return Math.sqrt(1 - r * r) / r; //sin(x)/cos(x)=sqrt(1-cos(x)^2)/cos(x)
        }
    }

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFakeTan(x);
        }
        else
        {
            return calcFuncTan(x);
        }
    }

    public double calcFakeTan(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 10381.32742;
        if (arg == 0.0001)  result = 0.0001;
        if (arg == 1.5706)  result = 5093.548171;
        if (arg == 0.5)     result = 0.5463024898;
        if (arg == 1.0)     result = 1.557407725;
        if (arg == 1.3)     result = 3.602102448;
        return result;
    }
}

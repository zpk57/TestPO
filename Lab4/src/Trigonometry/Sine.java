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
    public double calcFuncSin(double arg)
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

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFakeSin(x);
        }
        else
        {
            return calcFuncSin(x);
        }
    }

    public double calcFakeSin(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 0.999999954;
        if (arg == 0.0001)  result = 0.000009999999;
        if (arg == 1.5706)  result = 0.9999999807;
        if (arg == 0.5)     result = 0.4794255386;
        if (arg == 1.0)     result = 0.8414709848;
        if (arg == 1.3)     result = 0.9635581854;
        return result;
    }
}

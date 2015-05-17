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
    public double calcFuncSecant(double arg)
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

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFakeSecant(x);
        }
        else
        {
            return calcFuncSecant(x);
        }
    }

    public double calcFakeSecant(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 10381.32747;
        if (arg == 0.0001)  result = 1.0;
        if (arg == 1.5706)  result = 5093.54827;
        if (arg == 0.5)     result = 1.139493927;
        if (arg == 1.0)     result = 1.850815718;
        if (arg == 1.3)     result = 3.738334127;
        return result;
    }
}

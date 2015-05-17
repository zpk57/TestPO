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
    public double calcFuncCot(double arg)
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

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFakeCot(x);
        }
        else
        {
            return calcFuncCot(x);
        }
    }

    public double calcFakeCot(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 1/10381.32742;
        if (arg == 0.0001)  result = 1/0.0001;
        if (arg == 1.5706)  result = 1/5093.548171;
        if (arg == 0.5)     result = 1/0.5463024898;
        if (arg == 1.0)     result = 1/1.557407725;
        if (arg == 1.3)     result = 1/3.602102448;
        return result;
    }
}

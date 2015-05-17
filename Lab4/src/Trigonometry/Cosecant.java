/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
import Sources.FakeSettings;

// csc()
public class Cosecant extends Cosine{
    boolean fake;
    public Cosecant()
    {
        fake = FakeSettings.fakeCosecant;
    }
    public double calcFuncCosecant(double arg)
    {
        double r = super.Calc(arg);
        if(Double.isNaN(r))
        {
            return Double.NaN;
        }
        else
        {
            return (double)1/Math.sqrt(1-r*r); // 1/sin(x)=1/sqrt(1-cos(x)^2)
        }
    }

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFakeCosecant(x);
        }
        else
        {
            return calcFuncCosecant(x);
        }
    }

    public double calcFakeCosecant(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 1.0;
        if (arg == 0.0001)  result = 10000.0;
        if (arg == 1.5706)  result = 1.0;
        if (arg == 0.5)     result = 2.085829643;
        if (arg == 1.0)     result = 1.188395106;
        if (arg == 1.3)     result = 1.037820046;
        return result;
    }
}

/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;

import Sources.CalculationIface;
import Sources.FakeSettings;

public class TrigFunction implements CalculationIface {
    Cosine cos;
    Sine sin;
    Tangent tan;
    Cotangent cot;
    Secant sec;
    Cosecant csc;
    boolean fake;
    public TrigFunction()
    {
        cos = new Cosine();
        sin = new Sine();
        tan = new Tangent();
        cot = new Cotangent();
        sec = new Secant();
        csc = new Cosecant();
        fake = FakeSettings.fakeCosecant;
    }

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFake(x);
        }
        else
        {
            return calcFunc(x);
        }
    }


    public double calcFunc(double x)
    {
        //(((((csc(x) + cot(x)) + tan(x)) * cot(x)) + (csc(x) / (cos(x) ^ 2))) * (sin(x) * ((sec(x) * sin(x)) + cot(x))))
        return (((((csc.Calc(x) + cot.Calc(x)) + tan.Calc(x)) * cot.Calc(x)) + (csc.Calc(x) / (cos.Calc(x) * cos.Calc(x))))
                * (sin.Calc(x) * ((sec.Calc(x) * sin.Calc(x)) + cot.Calc(x))));
    }

    public double calcFake(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 1.1188e12;
        if (arg == 0.0001)  result = 2.0001e8;
        if (arg == 1.5706)  result = 1.3214e11;
        if (arg == 0.5)     result = 12.3944;
        if (arg == 1.0)     result = 11.5605;
        if (arg == 1.3)     result = 59.3231;
        return result;
    }
}

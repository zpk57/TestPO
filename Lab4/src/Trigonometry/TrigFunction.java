/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;

import Fake.FakeSettings;

public class TrigFunction {
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
        //(((((csc(x) + cot(x)) + tan(x)) * cot(x)) + (csc(x) / (cos(x) ^ 2))) * (sin(x) * ((sec(x) * sin(x)) + cot(x))))
        return (((((csc.Calc(x) + cot.Calc(x)) + tan.Calc(x)) * cot.Calc(x)) + (csc.Calc(x) / (cos.Calc(x) * cos.Calc(x))))
                * (sin.Calc(x) * ((sec.Calc(x) * sin.Calc(x)) + cot.Calc(x))));
    }
}

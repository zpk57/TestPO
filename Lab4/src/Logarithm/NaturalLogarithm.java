
package Logarithm;


import Sources.CalculationIface;
import Sources.FakeSettings;

public class NaturalLogarithm implements CalculationIface
{
    private long N = 45;
    private static final double MAX_ARG = 3;
    private static final double MIN_ARG = 2;
    private static final double LN2 = 0.6931471806;
    boolean fake;
    public NaturalLogarithm()
    {
        fake = FakeSettings.fakeCosecant;
    }

    public double Calc(double arg)
    {
        if(this.fake)
        {
            return calcFake(arg);
        }
        else
        {
            return Ln(arg);
        }
    }

    public double Ln(double arg)
    {
        double result;
        if ((arg >= MIN_ARG) && (arg <= MAX_ARG)) {
            result = LN2;
            for (long i = 1; i < N; i++) {
                result -= Math.pow((((double) -1) / ((double) 2)), i) * Math.pow((arg - 2), i) / i;
            }
        } else {
            result = Double.NaN;
        }
        return result;
    }

    private double calcFake(double arg)
    {
        double result = Double.NaN;
        if (arg == 2.0) result = 0.6931471806;
        if (arg == 3.0) result = 1.098612289;
        if (arg == 2.01) result = 0.6981347221;
        if (arg == 2.98) result = 1.091923301;
        if (arg == 2.2) result = 0.7884573604;
        if (arg == 2.5) result = 0.9162907319;
        if (arg == 2.8) result = 1.029619417;
        return result;
    }
}
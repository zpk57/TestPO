package Logarithm;

import Sources.CalculationIface;
import Sources.FakeSettings;

public class LogFunction implements CalculationIface {
    NaturalLogarithm Ln;
    MainLogarithm Log2;
    MainLogarithm Log3;
    MainLogarithm Log5;
    MainLogarithm Log10;
    boolean fake;

    public LogFunction()
    {
        Ln = new NaturalLogarithm();
        Log2 = new MainLogarithm(2);
        Log3 = new MainLogarithm(3);
        Log5 = new MainLogarithm(5);
        Log10 = new MainLogarithm(10);
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
            return LogFunc(x);
        }
    }

    private double LogFunc(double x)
    {
        //(((((log_3(x) / ln(x)) / log_3(x)) + log_10(x)) + log_5(x)) + (log_3(x) * ((log_5(x) / log_2(x)) / log_10(x))));
        return (((((Log3.Calc(x) / Ln.Calc(x)) / Log3.Calc(x)) + Log10.Calc(x)) + Log5.Calc(x)) + (Log3.Calc(x) * ((Log5.Calc(x) / Log2.Calc(x)) / Log10.Calc(x))));
    }

    private double calcFake(double arg)
    {
        double result = Double.NaN;

        if (arg == 2.0) result = 3.077001;
        if (arg == 3.0) result = 2.972605;
        if (arg == 2.01) result = 3.07202;
        if (arg == 2.98) result = 2.97114;
        if (arg == 2.2) result = 3.00327;
        if (arg == 2.5) result = 2.96128;
        if (arg == 2.8) result = 2.96079;

        return result;
    }
}
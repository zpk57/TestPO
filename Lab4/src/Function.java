/**
 * Created by Petr on 17.05.2015.
 */
import Sources.CalculationIface;
import Sources.FakeSettings;
import Trigonometry.*;
import Logarithm.*;
public class Function  implements CalculationIface {
    TrigFunction trigF;
    LogFunction logF;
    boolean fake;
    public Function()
    {
        trigF = new TrigFunction();
        logF = new LogFunction();
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

    private double calcFunc(double x)
    {
        if(x < 2)
        {
            return trigF.Calc(x);
        }
        else
        {
            return logF.Calc(x);
        }
    }

    private double calcFake(double arg)
    {
        double result = Double.NaN;
        if(arg < 2)
        {
            if (arg == 1.5707)  result = 1.1188e12;
            if (arg == 0.0001)  result = 2.0001e8;
            if (arg == 1.5706)  result = 1.3214e11;
            if (arg == 0.5)     result = 12.3944;
            if (arg == 1.0)     result = 11.5605;
            if (arg == 1.3)     result = 59.3231;
        }
        else
        {
            if (arg == 2.0) result = 3.077001;
            if (arg == 3.0) result = 2.972605;
            if (arg == 2.01) result = 3.07202;
            if (arg == 2.98) result = 2.97114;
            if (arg == 2.2) result = 3.00327;
            if (arg == 2.5) result = 2.96128;
            if (arg == 2.8) result = 2.96079;
        }
        return result;
    }
}

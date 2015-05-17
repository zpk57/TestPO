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
        if(x < 2)
        {
            return trigF.Calc(x);
        }
        else
        {
            return logF.Calc(x);
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
        double result;
        if(arg < 2)
        {
            result = 0;
        }
        else
        {
            if((arg == 2.0) || (arg == 3.0))
            {
                if (arg == 2.0)
                {
                    result = 0.3010299957;
                }
                else
                {
                    result = 0.4771212547;
                }
            }
            else
            {
                if((arg == 2.01) || (arg == 2.98))
                {
                    if(arg == 2.01) result = 3.07202;
                    else return 2.97114;
                }
                else
                {
                    if((arg == 2.2) || (arg == 2.5) || (arg == 2.8))
                    {
                        if(arg == 2.2) result = 0.3424226808;
                        else
                        {
                            if (arg == 2.5) result = 0.3979400087;
                            else result = 0.4471580313;
                        }

                    }
                    else
                    {
                        result = Double.NaN;
                    }
                }
            }
        }
        return result;
    }
}

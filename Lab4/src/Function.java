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
        if(x<=2)
        {
            return trigF.Calc(x);
        }
        else
        {
            return logF.Calc(x);
        }
    }
}

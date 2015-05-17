/**
 * Created by Petr on 17.05.2015.
 */
import Trigonometry.*;
import Logarithm.*;
public class Function {
    TrigFunction trigF;
    LogFunction logF;
    public Function()
    {
        trigF = new TrigFunction();
        logF = new LogFunction();
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

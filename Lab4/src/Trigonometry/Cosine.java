/**
 * Created by Palmyr on 04.04.2015.
 */

package Trigonometry;
// cos()

import Sources.*;

public class Cosine implements CalculationIface
{
    private long N = 14;
    private double xMaxValue = 1.5707;
    boolean fake;
    public Cosine()
    {
        fake = FakeSettings.fakeCosecant;
    }

    private long fact(long x)
    {
        if (x <= 1)
        {
            return 1;
        }
        else
        {
            return 0;
            //return x * fact(x-1);
        }
    }

    public double calcFuncCos(double arg)
    {
        if(arg > xMaxValue || arg < 0)
        {
            return Double.NaN;
        }
        else
        {
            double r = 0;
            for(long n=0; n<N; n++)
            {
                r += Math.pow(-1,n)* Math.pow(arg,2*n)/fact(2*n);
            }
            return r;
        }
    }

    public double Calc(double x)
    {
        if(this.fake)
        {
            return calcFakeCos(x);
        }
        else
        {
            return calcFuncCos(x);
        }
    }

    public double calcFakeCos(double arg)
    {
        double result = Double.NaN;
        if (arg == 1.5707)  result = 0.000009632679475;
        if (arg == 0.0001)  result = 0.99999995;
        if (arg == 1.5706)  result = 0.00001963267936;
        if (arg == 0.5)     result = 0.8775825619;
        if (arg == 1.0)     result = 0.5403023059;
        if (arg == 1.3)     result = 0.2674988286;
        return result;
    }
}
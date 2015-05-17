/**
 * Created by Palmyr on 04.04.2015.
 */

package Trigonometry;
// cos()

import Fake.FakeSettings;

public class Cosine
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
            return x * fact(x-1);
        }
    }

    public double Calc(double arg)
    {
        if(Math.abs(arg) > xMaxValue)
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
}
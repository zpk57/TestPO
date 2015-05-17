

/**
 * Created by Palmyr on 04.04.2015.
 */
public class Cosinus
{
    private long N = 14;
    private double xMaxValue = 1.5707;

    long fact(long x)
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


/*    public Double BinominalNewtonFactor(long n, long k)
    {
        return 1.0 * fact(n)/fact(k)/fact(n-k);
    }*/


    double CosCalculate(double arg)
    {
        double r = 0;
        for(long n=0; n<N; n++)
        {
            r += Math.pow(-1,n)* Math.pow(arg,2*n)/fact(2*n);
        }
        return r;
    }
}
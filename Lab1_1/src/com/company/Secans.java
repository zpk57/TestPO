package com.company;

/**
 * Created by Palmyr on 04.04.2015.
 */
public class Secans
{
    private long N = 14;
    private double xMaxValue = 1.5707;

/*    public Double СalculateEuler(long eulerNumber, boolean flag)
    {
        if (eulerNumber == 0) return 1.0;
        if (flag)
        {
            if (eulerNumber%2 == 1) return 0.0;
            eulerNumber /= 2;
        }
        double res=0;
        for (long j = 0; j <= eulerNumber-1; j++)
        {
            res += BinominalNewtonFactor(2 * eulerNumber, 2 * j) * СalculateEuler(j, false);
        }
        return -res;
    }*/

    //it's better to use iterative version...
    //but nobody cares
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

    double SecansCalculate(double arg)
    {
        /*
        double r = 1;
        for(long n=1; n < N; n++)
        {
            r += Math.abs(СalculateEuler(2*n, true))/fact(2*n) * Math.pow(arg, 2*n);
        }
        return r;
        */
        if(Math.abs(arg) > xMaxValue)
        {
            return Double.NaN;
        }
        else
        {
            return (1.0 / CosCalculate(arg));
        }
    }

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
package com.company;

public class Main {

    public static void main(String[] args)
    {
        double xArg = 1.57;
        Secans SecansInst = new Secans();
        System.out.println("MySecans, X= " + xArg + "\nResult = " + SecansInst.SecansCalculate(xArg));
        System.out.println("RealSecans, X= " + xArg + "\nResult = " + (1.0/Math.cos(xArg)));

//        System.out.println("Hello World!");
    }
}

class Secans
{
    private long N = 12;

    public Double СalculateEuler(long eulerNumber, boolean flag)
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
    }

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


    public Double BinominalNewtonFactor(long n, long k)
    {
        return 1.0 * fact(n)/fact(k)/fact(n-k);
    }

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
        return (1.0/CosCalculate(arg));
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
package com.company;

public class Main {
    private static double epsilon = 0.0001;

    public static void AssertME(double val1, double val2)
    {
        if (val1 >= val2)
        {
            System.out.println("passed");
        }
        else
        {
            System.out.println("not passed");
        }
    }

    public static void Assert(double val1, double val2)
    {
        if(Double.isNaN(val1))
        {
            if (Double.isNaN(val1))
            {
                System.out.println("passed");
            }
            else
            {
                System.out.println("not passed");
            }
        }
        else
        {
            if (Math.abs(val1 - val2) < epsilon)
            {
                System.out.println("passed");
            }
            else
            {
                System.out.println("not passed");
            }
        }
    }

    public static double NativeSec(double arg)
    {
        return 1/Math.cos(arg);
    }

    public static void main(String[] args)
    {
        double xArg;
        Secans SecansInst = new Secans();

        //Граничное тестирование
        //sec(0) = 1;
        Assert(SecansInst.SecansCalculate(0.0), 1.0);
        //sec(x) = NaN, if x > Pi/2 or x < Pi/2
        Assert(SecansInst.SecansCalculate(1.5708),  Double.NaN);
        Assert(SecansInst.SecansCalculate(-1.5708), Double.NaN);

        //классы эквивалентности
        //X belongs to [MIN_INTERVAL; MAX_INTERVAL], sec(x) >= 1
        AssertME(SecansInst.SecansCalculate(-1.5707), 1);
        AssertME(SecansInst.SecansCalculate(1.5707), 1);
        AssertME(SecansInst.SecansCalculate(0), 1);
        //X not belongs to [MIN_INTERVAL; MAX_INTERVAL], sec(x) = NAN
        Assert(SecansInst.SecansCalculate(1.6),  Double.NaN);
        Assert(SecansInst.SecansCalculate(-1.6), Double.NaN);

        //таблица значений, сравнение с эталоном
        //if X belongs to [MIN_INTERVAL; MAX_INTERVAL], TestSec(x) ~~ NativeSec(x)
        Assert(SecansInst.SecansCalculate(-1.5707), NativeSec(-1.5707));
        Assert(SecansInst.SecansCalculate(-0.9), NativeSec(-0.9));
        Assert(SecansInst.SecansCalculate(-0.2), NativeSec(-0.2));
        Assert(SecansInst.SecansCalculate(0.0), NativeSec(0.0));
        Assert(SecansInst.SecansCalculate(0.2), NativeSec(0.2));
        Assert(SecansInst.SecansCalculate(0.9), NativeSec(0.9));
        Assert(SecansInst.SecansCalculate(1.5707), NativeSec(1.5707));
    }
}
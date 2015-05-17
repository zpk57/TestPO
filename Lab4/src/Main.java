import Trigonometry.*;

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
        Cosine SecansInst = new Cosine();

        //Граничное тестирование
        //sec(0) = 1;
        Assert(SecansInst.Calc(0.0), 1.0);
    }
}
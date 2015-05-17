
package Logarithm;


public class NaturalLogarithm
{
    private long N = 25;
    private static final double MAX_ARG = 3;
    private static final double MIN_ARG = 2;
    private static final double LN2 = 0.6931471806;
    public double ln(double arg)
    {
        double result;
        if((arg >= MIN_ARG) && (arg <= MAX_ARG))
        {
//            for (long i = 1; i < N; i++)
//            {
//                result += Math.pow(-1, (i - 1)) * Math.pow((arg - 1), i) / i;
//            }
            result = LN2;
            for (long i = 1; i < N; i++)
            {
                result += Math.pow((-1/2), (i - 2)) * Math.pow((arg - 1), i) / i;
            }
        }
        else
        {
            result = Double.NaN;
        }
        return result;
    }
}
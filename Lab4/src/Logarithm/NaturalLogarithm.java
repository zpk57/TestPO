
package Logarithm;


public class NaturalLogarithm
{
    private long N = 25;
    public double ln(double arg)
    {
        double result = 0;
        for (long i = 1; i < N; i++)
        {
            result += Math.pow(-1,(i-1))*Math.pow((arg - 1), i)/i;
        }
        return result;
    }
}
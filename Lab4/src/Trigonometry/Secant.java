/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// sec()
public class Secant extends Cosine{
    public double Calc(double arg)
    {
        return (double)1/super.Calc(arg); // 1/cos(x)
    }
}

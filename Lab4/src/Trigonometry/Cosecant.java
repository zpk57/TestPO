/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// csc()
public class Cosecant extends Cosine{
    public double Calc(double arg)
    {
        return (double)1/super.Calc(Math.PI/2 - arg); // 1/sin(x)=1/cos(pi/2-x)
    }
}

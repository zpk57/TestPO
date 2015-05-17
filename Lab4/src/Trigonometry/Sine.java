/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// sin()
public class Sine extends Cosine{
    public double Calc(double arg)
    {
        return super.Calc(Math.PI/2 - arg); //cos(pi/2-x)
    }
}

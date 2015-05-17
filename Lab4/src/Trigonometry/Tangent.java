/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// tan()

public class Tangent extends Cosine {
    public double Calc(double arg)
    {
        return super.Calc(Math.PI/2 - arg)/super.Calc(arg); //sin(x)/cos(x)=cos(pi/2-x)/cos(x)
    }
}

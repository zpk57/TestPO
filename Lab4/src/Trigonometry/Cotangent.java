/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
// cot()
public class Cotangent extends Cosine {
    public double Calc(double arg)
    {
        return super.Calc(arg)/super.Calc(Math.PI/2 - arg); //cos(x)/sin(x)=cos(x)/cos(pi/2-x)
    }
}

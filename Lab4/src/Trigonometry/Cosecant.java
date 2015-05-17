/**
 * Created by Petr on 17.05.2015.
 */
package Trigonometry;
import Fake.FakeSettings;

// csc()
public class Cosecant extends Cosine{
    boolean fake;
    public Cosecant()
    {
        fake = FakeSettings.fakeCosecant;
    }
    public double Calc(double arg)
    {
        double r = super.Calc(arg);
        if(Double.isNaN(r))
        {
            return Double.NaN;
        }
        else
        {
            return (double)1/Math.sqrt(1-r*r); // 1/sin(x)=1/sqrt(1-cos(x)^2)
        }
    }
}

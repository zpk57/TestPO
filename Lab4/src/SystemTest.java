/**
 * Created by Petr on 17.05.2015.
 */
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SystemTest extends TestCase
{
    private final static double delta = 0.0001;
    public static void testSystem(Function func, String head)
    {
        //________log__________
        assertEquals(head+"border: ", 3.0770, func.Calc(2), delta);
        assertEquals(head+"border: ", 2.9726, func.Calc(3), delta);

        assertEquals(head+"near border: ", 3.0720, func.Calc(2.01), delta);
        assertEquals(head+"near border: ", 2.9711, func.Calc(2.98), delta);

        assertEquals(head+"inside: ", 3.0032, func.Calc(2.2), delta);
        assertEquals(head+"inside: ", 2.9612, func.Calc(2.5), delta);
        assertEquals(head+"inside: ", 2.9607, func.Calc(2.8), delta);

        assertEquals(head+"outside: ", Double.NaN, func.Calc(6), delta);
        assertEquals(head+"outside: ", Double.NaN, func.Calc(4), delta);

        //________trig_________
        assertEquals(head+"border: ", Double.NaN, func.Calc(0), delta);
        assertEquals(head+"border: ", 1.1188, func.Calc(1.5707), delta);

        assertEquals(head+"near border: ", 2.0001, func.Calc(0.0001), delta);
        assertEquals(head+"near border: ", 1.3214, func.Calc(1.5706), delta);

        assertEquals(head+"inside: ", 12.3944, func.Calc(0.5), delta);
        assertEquals(head+"inside: ", 11.5606, func.Calc(1), delta);
        assertEquals(head+"inside: ", 59.3231, func.Calc(1.3), delta);

        assertEquals(head+"outside: ", Double.NaN, func.Calc(1.5708), delta);
        assertEquals(head+"outside: ", Double.NaN, func.Calc(-1), delta);
        System.out.println(head+"done");
    }
}

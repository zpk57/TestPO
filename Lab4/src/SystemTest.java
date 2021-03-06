/**
 * Created by Petr on 17.05.2015.
 */
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SystemTest extends TestCase
{
    private final static double delta = 0.0001;
    public static void testSystem(Function func, String head)
    {
        try {
            //________log__________
            Assert.assertEquals(head + "border: ", 3.0770, func.Calc(2), delta);
            Assert.assertEquals(head + "border: ", 2.9726, func.Calc(3), delta);

            Assert.assertEquals(head + "near border: ", 3.0720, func.Calc(2.01), delta);
            Assert.assertEquals(head + "near border: ", 2.9711, func.Calc(2.98), delta);

            Assert.assertEquals(head + "inside: ", 3.0032, func.Calc(2.2), delta);
            Assert.assertEquals(head + "inside: ", 2.9612, func.Calc(2.5), delta);
            Assert.assertEquals(head + "inside: ", 2.9607, func.Calc(2.8), delta);

            Assert.assertTrue(head + "outside: at 6 not NAN", Double.isNaN(func.Calc(6)));
            Assert.assertTrue(head + "outside: at 4 not NAN", Double.isNaN(func.Calc(4)));

            //________trig_________
            Assert.assertTrue(head + "border: ", Double.isNaN(func.Calc(0)));
            Assert.assertEquals(head + "border: ", 1.1188e12, func.Calc(1.5707), 1.1188e12 * delta);

            Assert.assertEquals(head + "near border: ", 2.0001e8, func.Calc(0.0001), 2.0001e8 * delta);
            Assert.assertEquals(head + "near border: ", 1.3214e11, func.Calc(1.5706), 1.3214e11 * delta);

            Assert.assertEquals(head + "inside: ", 12.3944, func.Calc(0.5), delta);
            Assert.assertEquals(head + "inside: ", 11.5605, func.Calc(1), delta);
            Assert.assertEquals(head + "inside: ", 59.3231, func.Calc(1.3), delta);

            Assert.assertTrue(head + "outside: at 1.5708 not NAN", Double.isNaN(func.Calc(1.5708)));
            Assert.assertTrue(head + "outside: at -1 not NAN", Double.isNaN(func.Calc(-1)));
            System.out.println(head + "done");
        }
        catch (java.lang.AssertionError e){
            System.out.println(head+"failed");
        }
    }
}

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
        assertEquals(head+"", 0, func.Calc(0), delta);
    }
}

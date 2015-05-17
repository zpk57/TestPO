package Tests;
import Trigonometry.*;

/**
 * Created by Petr on 17.05.2015.
 */
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class CosineTest extends TestCase{
    private Cosine cos;

    @Before
    protected void setUp() throws Exception
    {
        cos = new Cosine();
    }

    @After
    protected void tearDown() throws Exception
    {
        assertTrue("WTF", cos.Calc(0) == 1);
        assertTrue("WTF", cos.Calc(1) == 1);
    }

    @Test
    public void testCosine() {

    }
}

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Logout {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
//        selenium = new DefaultSelenium("localhost", 4444, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "http://www.yandex.ru/");
        selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
        selenium.start();
    }

    @Test
    public void testLogout() throws Exception {
        //selenium.open("/home");
        selenium.click("//*[@id=\"header-account-menu\"]/a");
        selenium.click("//*[@id=\"header-account-menu\"]/div/ul/li[4]/a");
        selenium.waitForPageToLoad("30000");
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }

    public void runTest()
    {
        try {
            setUp();
            Main.login(selenium);
            testLogout();
            Main.assertImpl("[can'not logout]", selenium.isElementPresent("//*/form[1]/div[4]/button[@type='submit']"));
            System.out.println("Logout: test successfully completed");
        }
        catch (Exception e) {
            System.out.println("Logout: test failed");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        try {
            tearDown();
        }catch (Exception e) {
            System.out.println("Logout: tearDown failed");
        }
    }
}

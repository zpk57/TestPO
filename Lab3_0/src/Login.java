import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Login {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
//        selenium = new DefaultSelenium("localhost", 4444, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "http://www.yandex.ru/");
        selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
        selenium.start();
    }

    @Test
    public void testLogin() throws Exception {
        selenium.open("/");
        selenium.click("//*[@id='sign-in']/a");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[2]/div[2]/input", "qwerty12345");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[1]/div[2]/input", "zpk57@ya.ru");
        selenium.click("//*[@id=\"sign-in-form-inner\"]/form[1]/div[4]/button");
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
            testLogin();
            Main.assertImpl("[uncorrect account]", selenium.isElementPresent("//*[@id='header-account-menu']/a"));
            System.out.println("Login: test successfully completed");
        }
        catch (Exception e) {
            System.out.println("Login: test failed");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        try {
            tearDown();
        }catch (Exception e) {
            System.out.println("Login: tearDown failed");
        }
    }
}


import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;


public class Main {

    public static String browser = "*firefox G:\\firefox\\firefox.exe";
    //public static String browser = "*chrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

    public static void main(String[] args) {
        SeleniumServer serv;
        RemoteControlConfiguration rc;
        System.out.println("passed");
        rc = new RemoteControlConfiguration();
        try
        {
            serv = new SeleniumServer(rc);
            serv.start();
        } catch (Exception e)
        {
            System.out.println("Error on server start; abort");
            return;
        }
        System.out.println("Server started");

        Login log = new Login();
        log.runTest();
        Find find = new Find();
        find.runTest();
        Logout logout = new Logout();
        logout.runTest();
        Find2 find2 = new Find2();
        find2.runTest();
        Download download = new Download();
        download.runTest();
        serv.stop();
    }

    public static void login(Selenium selenium) throws Exception
    {
        selenium.open("/");
        selenium.click("//*[@id='sign-in']/a");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[2]/div[2]/input", "qwerty12345");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[1]/div[2]/input", "zpk57@ya.ru");
        selenium.click("//*[@id=\"sign-in-form-inner\"]/form[1]/div[4]/button");
        selenium.waitForPageToLoad("30000");
        Main.assertImpl("[can'not login]", selenium.isElementPresent("//*[@id='header-account-menu']/a"));
    }

    public static void assertImpl(String message, boolean condition) throws Exception
    {
        if(!condition)
        {
            throw new Exception(message);
        }
    }
}

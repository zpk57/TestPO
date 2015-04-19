/**
 * Created by Petr on 18.04.2015.
 */
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

public class Main {

    public static void main(String[] args)
    {
        SeleniumServer serv;
        RemoteControlConfiguration rc;
        System.out.println("passed");
        yandex red = new yandex();
        try {
            rc = new RemoteControlConfiguration();
            serv = new SeleniumServer(rc);
            serv.start();
            red.setUp();
            red.testYandex();
            Thread.sleep(10000);
            red.tearDown();
            serv.stop();
        }
        catch (Exception e) {
            System.out.print("Oups i did it again\n");
            System.out.print(e.getMessage());
            System.out.print(e.getCause());
        }
    }
}

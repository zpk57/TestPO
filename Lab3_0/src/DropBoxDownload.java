import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class DropBoxDownload {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
//        selenium = new DefaultSelenium("localhost", 4444, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "http://www.yandex.ru/");
		selenium = new DefaultSelenium("localhost", 4444, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "https://www.dropbox.com/");
		selenium.start();
	}

    //do not use
	@Test
	public void testDropBoxDownload() throws Exception {
//		selenium.open("/");
//        selenium.click("//html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr/td[1]/span/span[1]/input");
//        selenium.click("id=text");
//        selenium.type("id=text", "qwerty");
//        selenium.click("//button[@type='submit']");
//        selenium.waitForPageToLoad("30000");


        selenium.open("/");
        selenium.click("link=Войдите");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[2]/div[2]/input", "qwerty12345");
//        selenium.waitForPageToLoad("30000");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[1]/div[2]/input", "zpk57@ya.ru");
//        selenium.click("//*[@id="login-or-register-page-content"]/div/div/div[1]/div[2]/form[1]/div[4]/div[2]/label");
//        selenium.waitForPageToLoad("30000");
        selenium.click("//*[@id=\"sign-in-form-inner\"]/form[1]/div[4]/button");
        selenium.waitForPageToLoad("30000");
        selenium.click("//*[@id=\"header-account-menu\"]/a");
        selenium.click("//*[@id=\"header-account-menu\"]/div/ul/li[4]/a");
//        selenium.click("link=Выйти");
        selenium.waitForPageToLoad("30000");
	}

    @Test
    public void testLogin() throws Exception {
        selenium.open("/");
        selenium.click("link=Войдите");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[2]/div[2]/input", "qwerty12345");
        selenium.type("//*[@id=\"sign-in-form-inner\"]/form[1]/div[1]/div[2]/input", "zpk57@ya.ru");
//        selenium.click("//*[@id="login-or-register-page-content"]/div/div/div[1]/div[2]/form[1]/div[4]/div[2]/label");
        selenium.click("//*[@id=\"sign-in-form-inner\"]/form[1]/div[4]/button");
        selenium.waitForPageToLoad("30000");
    }

    @Test
    public void testLogout() throws Exception {
        selenium.open("/home");
        selenium.click("//*[@id=\"header-account-menu\"]/a");
        selenium.click("//*[@id=\"header-account-menu\"]/div/ul/li[4]/a");
        selenium.waitForPageToLoad("30000");
    }

    @Test
    public void testDownload() throws Exception {
        selenium.open("/home");                      //not necessary to use
        selenium.click("//*[@id=\"browse-files\"]/li/div[1]");
        selenium.click("//*[@id=\"file-viewer-container\"]/div[1]/div[2]/button[2]");
        selenium.waitForPageToLoad("30000");
    }

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

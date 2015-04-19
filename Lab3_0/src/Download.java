
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Download {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
		selenium.start();
	}

	@Test
	public void testDownload() throws Exception {
		//selenium.open("/home");
		selenium.click("link=Mozilla Firefox.lnk");
		selenium.click("//div[@id='file-viewer-container']/div[2]/div[4]/button[2]");
		//selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//img[contains(@src,'https://cf.dropboxstatic.com/static/images/icons/icon_spacer-vflN3BYt2.gif')])[26]");
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
			testDownload();
			Thread.sleep(1000);
			//???Main.assertImpl("[some files founded]", !selenium.isElementPresent("//*/li/div[1]/a[@class='filename-link']"));
			System.out.println("Download: test successfully completed");
		}
		catch (Exception e) {
			System.out.println("Download: test failed");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			tearDown();
		}catch (Exception e) {
			System.out.println("Download: tearDown failed");
		}
	}
}

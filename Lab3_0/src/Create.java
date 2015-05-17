
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.regex.Pattern;

public class Create {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
		selenium.start();
	}

	@Test
	public void testCreate() throws Exception {
		//selenium.open("/home");
		Thread.sleep(1000);
		selenium.click("//*/ul/li[2]/label/a");
		selenium.type("name=value", "new_dir");
		selenium.refresh();
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		//selenium.click("//*[@id='browse-files']/li[1]/div[1]/img");
		//Thread.sleep(1000);
		selenium.click("//*/ol/li[3]/div[@class='filename-col']");
		Thread.sleep(1000);
		selenium.click("id=move_action_button");
		Thread.sleep(2000);
		selenium.click("//*[@id='copy-move-treeview']/div[2]/div/a[2]");
		Thread.sleep(1000);
		selenium.click("//*[@id='folder-pick']/div[2]/input[1]");
		Thread.sleep(5000);
		selenium.click("//*/ol/li[1]/div/a");
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
			testCreate();
			Thread.sleep(1000);
			Main.assertImpl("[file not found]", selenium.isElementPresent("//*/li/div[1]/a[@class='filename-link']"));
			Thread.sleep(2000);
			selenium.click("//*/ol/li[1]/div[@class='filename-col']");
			Thread.sleep(1000);
			selenium.click("id=move_action_button");
			Thread.sleep(2000);
			selenium.click("//*[@id='first-treeview-link']/span");
			Thread.sleep(1000);
			selenium.click("//*[@id='folder-pick']/div[2]/input[1]");
			Thread.sleep(4000);
			System.out.println("Create and move: test successfully completed");
		}
		catch (Exception e) {
			System.out.println("Create and move: test failed");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			tearDown();
		}catch (Exception e) {
			System.out.println("Create and move: tearDown failed");
		}
	}
}

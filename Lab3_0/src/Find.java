

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Find {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
		selenium.start();
	}

	@Test
	public void testFind() throws Exception {
		selenium.open("/search");
		selenium.type("id=browse-search-input", "b.test");
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
			testFind();
			Thread.sleep(5000);
			Main.assertImpl("[file not found]", selenium.isElementPresent("//*/li/div[1]/a[@class='filename-link']"));
			System.out.println("Find: test successfully completed");
		}
		catch (Exception e) {
			System.out.println("Find: test failed");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			tearDown();
		}catch (Exception e) {
			System.out.println("Find: tearDown failed");
		}
	}
}

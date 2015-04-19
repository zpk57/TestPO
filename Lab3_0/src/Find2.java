import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Find2 {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
		selenium.start();
	}

	@Test
	public void testFind() throws Exception {
		selenium.open("/search");
		selenium.type("id=browse-search-input", "blablabla");
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
			Thread.sleep(1000);
			Main.assertImpl("[some files founded]", !selenium.isElementPresent("//*/li/div[1]/a[@class='filename-link']"));
			System.out.println("Find2: test successfully completed");
		}
		catch (Exception e) {
			System.out.println("Find2: test failed");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			tearDown();
		}catch (Exception e) {
			System.out.println("Find2: tearDown failed");
		}
	}
}

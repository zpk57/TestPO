
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.file.Files;

public class UpLoad {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, Main.browser, "https://www.dropbox.com/");
		selenium.start();
	}

	@Test
	public void testFind() throws Exception {
		
		String from = "H:\\HardCorePorno\\Git_work\\TestPO\\Lab3_0\\src\\Logout.java";
        String to = "C:\\Users\\Petr\\Dropbox\\Logout2.java";

        File From = new File(from);
        File To = new File(to);

        if (!From.exists()) 
		{
            System.out.println(from + " does not exist!");
        }
		else
		{

			try 
			{
				Files.copy(From.toPath(), To.toPath());
			}
			catch (Exception e) {}
			
			
			Thread.sleep(10000);
		}
	
	
		selenium.open("/search");
		selenium.type("id=browse-search-input", "Logout2");
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
			Main.assertImpl("[file not uploaded]", selenium.isElementPresent("//*/li/div[1]/a[@class='filename-link']"));
			System.out.println("UpLoad: test successfully completed");
		}
		catch (Exception e) {
			System.out.println("UpLoad: test failed");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			tearDown();
		}catch (Exception e) {
			System.out.println("UpLoad: tearDown failed");
		}
	}
}

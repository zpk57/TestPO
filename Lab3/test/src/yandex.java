
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class yandex {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox G:\\firefox\\firefox.exe", "http://www.yandex.ru/");
		selenium.start();
	}

	@Test
	public void testYandex() throws Exception {
		selenium.open("/");
		selenium.click("id=text");
		selenium.type("id=text", "ололо");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Смотрите картинки по запросу «ололо»");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

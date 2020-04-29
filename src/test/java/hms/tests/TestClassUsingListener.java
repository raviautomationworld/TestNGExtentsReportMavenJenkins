package hms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClassUsingListener {

	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\soft\\RestAssuredJars\\chromedriver_win32_81_44_69\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.get("http://www.seleniumbymahesh.com/HMS/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}

	@Test
	public void testSuccessfull() {

		System.out.println("Executing Successfull Test Method");
	}

	@Test
	public void testFailed() {
		System.out.println("Executing Failed Test Method");

		Assert.fail("Executing Fail Method");

	}

	@Test
	public void testSkipped() {

		System.out.println("Executing Skipped Test Method");
		throw new SkipException("Executing Skip Method");

	}

}

package Project_K.com.Package;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.HomePageElements;
import pageObjects.LoginPage;
import pageObjects.LoginPageElements;
import resources.BaseClass;

public class LoginPageTest extends BaseClass {

	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	void setUp() throws Exception {
		driver = initializeDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}

	@Test
	void login() throws IOException, InterruptedException {
		NavigatetobaseUrl(driver);
		homePage.clickSignIn();
		String pageHandle = driver.getWindowHandle();
		loginPage.switchToLoginPageFrame();
		loginPage.enterUserName();
		loginPage.clickContinue();
		loginPage.enterPassword();
		loginPage.clickContinue();

	}

	@AfterTest
	void tearDown() {
		driver.close();
	}

}

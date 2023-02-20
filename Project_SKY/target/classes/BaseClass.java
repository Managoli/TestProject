package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageElements;

public class BaseClass implements HomePageElements {

	public WebDriver driver = null;
	String path = System.getProperty("user.dir");
	Date today = new Date();

	public String getConfigFromPropFile(String property) throws IOException {

		
		FileInputStream fis = new FileInputStream(path + "//src//main//java//resources//config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(property);
	}

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws Exception {
		try {
			switch (getConfigFromPropFile("browser")) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "//Users//vedant//Desktop//Project_SKY//drivers//chromedriver.exe");
				driver = new ChromeDriver();
				
				break;

			case "fireFox":
				System.setProperty("webdriver.fireFox.driver", "C:\\downloads\\firefoxdriver.exe");
				driver = new FirefoxDriver();
				break;

			default:
				throw new Exception("Invalid browser name");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(Long.parseLong(getConfigFromPropFile("timeOut")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void NavigatetobaseUrl(WebDriver driver) throws IOException, InterruptedException{
		driver.get(getConfigFromPropFile("baseUrl"));
		String pageHandle = driver.getWindowHandle();
		driver.switchTo().frame(driver.findElement(By.xpath(ACCEPT_ALL_FRAME_XPATH)));
		waitForElement(ACCEPT_ALL_BUTTON_XPATH);
		driver.findElement(By.xpath(ACCEPT_ALL_BUTTON_XPATH)).click();
		driver.switchTo().window(pageHandle);
		waitForElement(SIGN_IN_XPATH);
	
		}
	
	public void waitForElement(String elementXpath){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
	}
	
	
}

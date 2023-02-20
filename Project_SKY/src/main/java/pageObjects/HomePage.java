package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BaseClass;

public class HomePage extends BaseClass implements HomePageElements {
	
	public WebDriver driver;
	 public HomePage(WebDriver driver){
		 this.driver = driver;
	 }
	 
	 public void clickSignIn(){
		 driver.findElement(By.xpath(SIGN_IN_XPATH)).click();
	 }

}

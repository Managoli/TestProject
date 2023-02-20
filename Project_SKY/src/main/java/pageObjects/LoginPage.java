package pageObjects;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BaseClass;

public class LoginPage extends BaseClass implements LoginPageElements {
	
	public WebDriver driver;
	 public LoginPage(WebDriver driver){
		 this.driver = driver;
	 }
	 
	 public void switchToLoginPageFrame(){
		 
		 driver.switchTo().frame(driver.findElement(By.xpath(SIGN_IN_FRAME_XPATH)));
		
		 
	 }
	 
	 public void enterUserName() throws IOException{
		 driver.findElement(By.id(USERNAME_ID)).sendKeys(getConfigFromPropFile("username"));
	 }
	 
	 public void enterPassword() throws IOException{
		 driver.findElement(By.id(PASSWORD_ID)).sendKeys(getConfigFromPropFile("password"));
	 }
	 
	 public void clickContinue(){
		 driver.findElement(By.xpath(CONTINUE_XPATH)).click();
	 }

}

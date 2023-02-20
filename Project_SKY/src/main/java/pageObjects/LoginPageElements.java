package pageObjects;

public interface LoginPageElements {
	
	String USERNAME_ID = "username";
	String PASSWORD_ID = "current-password";
	String CONTINUE_XPATH = "//*[@type='button' and text()='Continue']";
	String SIGN_IN_FRAME_XPATH = "//*[contains(@name,'sign_in_iframe')]";

}

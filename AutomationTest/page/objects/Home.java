package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	
	public static final String URL = "http://localhost/izlet/index.php";
	private static final String GALERIJA = "//nav[@class='main-nav']//a[@class='a_bold'][contains(text(),'Galerija')]";
	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USER = "//form[@action='processregister.php']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASS = "//form[@action='processregister.php']//input[@name='password']";
	private static final String REGISTER = "//input[@id='blue_btn']";
	private static final String USERNAME = "//input[@placeholder='username']";
	private static final String PASSWORD = "//input[@placeholder='password']";
	private static final String LOGIN = "//input[@value='Log in']";
	
	
	public static void openPage(WebDriver dr) {
		dr.get(URL);
	}
	
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(URL);
	}
	
	
	public static WebElement getGalerija(WebDriver dr) {
		WebElement wel=dr.findElement(By.xpath(GALERIJA));
		return wel;
	}
	
	public static void clickGalerija(WebDriver dr) {
		getGalerija(dr).click();
	}
	

	public static WebElement getFirstName(WebDriver dr) {
		WebElement wel= dr.findElement(By.xpath(FIRST_NAME));
		return wel;
	}
	
	public static void clickFirstName(WebDriver dr) {
		getFirstName(dr).click();
	}
	
	public static void sendKeysFirstName(WebDriver dr, String info) {
		getFirstName(dr).sendKeys(info);
	}
	
	public static WebElement getLastName(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(LAST_NAME));
		return wel;
	}
	
	public static void clickLastName(WebDriver dr) {
		getLastName(dr).click();
	}
	public static void sendKeysLastName(WebDriver dr, String info) {
		getLastName(dr).sendKeys(info);
	}
	
	public static WebElement getUser(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(USER));
		return wel;
	}
	
	public static void clickUser(WebDriver dr) {
		getUser(dr).click();
	}
	
	public static void sendKeysUser(WebDriver dr, String info) {
		getUser(dr).sendKeys(info);
	}
	public static WebElement getEmail(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(EMAIL));
		return wel;
	}
	
	public static void clickEmail(WebDriver dr) {
		getEmail(dr).click();
	}
	
	public static void sendKeysEmail(WebDriver dr, String info) {
		getEmail(dr).sendKeys(info);
	}
	
	public static WebElement getPass(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(PASS));
		return wel;
	}
	
	public static void clickPass(WebDriver dr) {
		getPass(dr).click();
	}
	
	public static void sendKeysPass(WebDriver dr, String info) {
		getPass(dr).sendKeys(info);
	}
	
	public static WebElement getRegister(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(REGISTER));
		return wel;
	}
	
	public static void clickRegister(WebDriver dr) {
		getRegister(dr).click();
	}
	
	public static WebElement getUserName(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(USERNAME));
		return wel;
	}
	
	public static void clickUserName(WebDriver dr) {
		getUserName(dr).click();
	}
	
	public static void sendKeysUserName(WebDriver dr, String info) {
		getUserName(dr).sendKeys(info);
	}
	
	public static WebElement getPassword(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(PASSWORD));
		return wel;
	}
	
	public static void clickPassword(WebDriver dr) {
		getPassword(dr).click();
	}
	
	public static void sendKeysPassword(WebDriver dr, String info) {
		getPassword(dr).sendKeys(info);
	}
	public static WebElement getLogin(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(LOGIN));
		return wel;
	}
	
	public static void clickLogin(WebDriver dr) {
		getLogin(dr).click();
	}
	
	
}

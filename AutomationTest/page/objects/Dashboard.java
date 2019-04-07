package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dashboard {

	public static final String DASHBOARD_URL = "http://localhost/izlet/dashboard.php";
	public static final String MAKE_POST = "//div[2]//div[3]";
	public static final String NAZIV_POSTA = "//input[@placeholder='Naziv']";
	public static final String LOKACIJA = "//input[@placeholder='Lokacija']";
	public static final String BROWSE = "//label[contains(text(),'Browse...')]";
	public static final String WAY = "//div[@class='popupPost']//select[@name='transport']";
	public static final String OPIS = "//textarea[@placeholder='Opis']";
	public static final String POST_BUTTON = "//div[@class='popupPost']//input[@value='Post']";
	public static final String LOGOUT = "//a[@id='logoutBtn']";

	public static final By MENUP = By.className("fa-ellipsis-v");
	public static final By DELETEP = By.className("fa-trash-alt");
	public static final By EDITP = By.className("fa-edit");
	
	
	public static void openPage(WebDriver dr) {
		dr.get(DASHBOARD_URL);
	}

	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(DASHBOARD_URL);
	}

	public static WebElement getMakePost(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(MAKE_POST));
		return wel;
	}

	public static void clickMakePost(WebDriver dr) {
		getMakePost(dr).click();
	}

	public static WebElement getNazivPosta(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(NAZIV_POSTA));
		return wel;
	}

	public static void clickNazivPosta(WebDriver dr) {
		getNazivPosta(dr).click();
	}

	public static void sendKeysNazivPosta(WebDriver dr, String str) {
		getNazivPosta(dr).sendKeys(str);
	}

	public static WebElement getLokacija(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(LOKACIJA));
		return wel;
	}

	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}

	public static void sendKeysLokacija(WebDriver dr, String str) {
		getLokacija(dr).sendKeys(str);
	}

	public static void setWay(WebDriver dr, String str) {
		Select Way = new Select(dr.findElement(By.xpath(WAY)));
		Way.selectByVisibleText(str);
	}

	public static WebElement getOpis(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(OPIS));
		return wel;
	}

	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void sendKeysOpis(WebDriver dr, String str) {
		getOpis(dr).sendKeys(str);
	}

	public static WebElement getPost(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(POST_BUTTON));
		return wel;
	}

	public static void clickPost(WebDriver dr) {
		getPost(dr).click();
	}

	// metoda za selektovanje tri tackice
	public static WebElement getMenu(WebDriver dr, int i) {
		List<WebElement> menu = dr.findElements(MENUP);
		WebElement wel = menu.get(i);
		return wel;
	}

	public static void clickMenu(WebDriver dr, int i) {
		getMenu(dr, i).click();
	}

	// metoda za editovanje posta
	public static WebElement getEdit(WebDriver dr, int i) {
		List<WebElement> edit = dr.findElements(EDITP);
		WebElement wel = edit.get(i);
		return wel;
	}
	

	public static void clickEdit(WebDriver dr, int i) {
		getEdit(dr, i).click();
	}
	

	// metoda za brisanje posta
	public static WebElement getDelete(WebDriver dr, int i) {
		List<WebElement> delete = dr.findElements(DELETEP);
		WebElement wel = delete.get(i);
		return wel;
	}

	public static void clickDelete(WebDriver dr, int i) {
		getDelete(dr, i).click();
	}
	
	public static WebElement getLogout(WebDriver dr) {
		WebElement wel = dr.findElement(By.xpath(LOGOUT));
		return wel;
	}
	
	public static void clickLogout(WebDriver dr) {
		getLogout(dr).click();	}

}

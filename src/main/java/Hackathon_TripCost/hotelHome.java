package Hackathon_TripCost;

import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/* Author name
* Gerald Hadley Brownie
* Prabhu Shanmugam
* Rajesh R 
* Sai Sushmita
* Vinay Vaida
*/

public class hotelHome {

	public static RemoteWebDriver driver;

//calling properties file
	public static String readCon(String prop_name) throws Exception {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\proCon.properties");
		prop.load(ip);
		return prop.getProperty(prop_name);
	}

	// calling browser name to invoke browser
	public void invokeBrowser(String browser) throws Exception {

		if (readCon("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			String Node = "http://192.168.0.5:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), capabilities);

		} else if (readCon("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			String Node = "http://192.168.0.5:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), capabilities);

		} else if (readCon("browser").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			String Node = "http://192.168.0.5:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), capabilities);
			driver.manage().window().maximize();
		}
		driver.manage().window().maximize();
	}

//getting to url
	public void getUrl(String url) throws Exception {
		driver.get(readCon("url"));
	}

//centralizing paths for findElement
	public static WebElement getElement(String locatorKey) {
		WebElement element = null;

		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(readCon(locatorKey)));

			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(readCon(locatorKey)));

			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(readCon(locatorKey)));

			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(readCon(locatorKey)));

			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(readCon(locatorKey)));

			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(readCon(locatorKey)));

			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(readCon(locatorKey)));

			} else {
				System.out.println("Invalid");
			}
		} catch (Exception e) {

			// Fail the TestCase and Report the error
			e.printStackTrace();
		}

		return element;
	}

	// centralizing paths for findElements
	public List<WebElement> getListElement(String locKeyLis) {
		List<WebElement> eleList = null;
		try {
			if (locKeyLis.endsWith("_Xpath")) {
				eleList = driver.findElements(By.xpath(readCon(locKeyLis)));
			} else if (locKeyLis.endsWith("_ClassName")) {
				eleList = driver.findElements(By.className(readCon(locKeyLis)));
			} else if (locKeyLis.endsWith("_CSS")) {
				eleList = driver.findElements(By.cssSelector(readCon(locKeyLis)));
			} else if (locKeyLis.endsWith("_LinkText")) {
				eleList = driver.findElements(By.linkText(readCon(locKeyLis)));
			} else if (locKeyLis.endsWith("_PartialLinkText")) {
				eleList = driver.findElements(By.partialLinkText(readCon(locKeyLis)));
			} else if (locKeyLis.endsWith("_Name")) {
				eleList = driver.findElements(By.name(readCon(locKeyLis)));
			} else if (locKeyLis.endsWith("_Id")) {
				eleList = driver.findElements(By.id(readCon(locKeyLis)));
			} else {
				System.out.println("Invalid");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return eleList;
	}

//entering search location in textfield
	public void searchDestination(String homeSearchBox_Xpath) throws Exception {
		// getting data from excel
		getExcel ge = new getExcel();

		Thread.sleep(5000);

		WebElement ser = getElement(homeSearchBox_Xpath);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// selecting first option from search recommendation
		ser.sendKeys(ge.locName());
		Thread.sleep(3000);
		ser.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		ser.sendKeys(Keys.ENTER);

	}

//clicking button hotel home
	public void selHolHom(String holHom_PartialLinkText) throws Exception {
		Thread.sleep(3000);
		WebElement sel = getElement(holHom_PartialLinkText);
		sel.click();
	}

//giving check in and checkout dates
	public void Check_IN_OUT(String checkIn_Xpath) {
		try {
			WebElement dateObj = getElement(checkIn_Xpath);
			dateObj.click();
			// getting data from excel
			getExcel ge = new getExcel();

			String checkInDateStr = ge.checkIn();

			String checkOutDateStr = ge.checkOut();

			WebElement checkInDate = driver.findElement(By.xpath("//div[@aria-label='" + checkInDateStr + "']"));
			checkInDate.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement checkOutDate = driver.findElement(By.xpath("//div[@aria-label='" + checkOutDateStr + "']"));

			checkOutDate.click();
		} catch (Exception e) {
			System.out.println("Received exception in method Check_IN_OUT" + e);
		}
	}

//selecting number of adults
	public void selAdult(String selAdu_Xpath, String incre_Xpath, String apply_Xpath) {

		WebElement sel1 = getElement(selAdu_Xpath);
		sel1.click();

		WebElement incre = getElement(incre_Xpath);
		incre.click();
		incre.click();
		WebElement aply = getElement(apply_Xpath);
		aply.click();

	}

//selecting sort according to Traveler Rating 
	public void sortTra(String clickSort_Xpath, String clickTra_Xpath) throws Exception {
		Thread.sleep(10000);

		WebElement sel1 = getElement(clickSort_Xpath);

		Actions actions = new Actions(driver);

		actions.moveToElement(sel1).click().perform();

		WebElement sel2 = getElement(clickTra_Xpath);
		sel2.click();
	}

	// Selecting amenities eleveator/lift
	public void selAmenities(String more_Xpath, String amn_Xpath) throws Exception {
		Thread.sleep(5000);
		WebElement sel1 = getElement(more_Xpath);
		sel1.click();
		Thread.sleep(3000);
		WebElement sel2 = getElement(amn_Xpath);
		sel2.click();
	}

//listing the hotel names and price
	public void getHotNamePrice(String hotelName_Xpath, String hotelPrice_Xpath, String hotelPriceTotal_Xpath)
			throws InterruptedException {
		Thread.sleep(5000);

		List<WebElement> s1 = getListElement(hotelName_Xpath);
		List<WebElement> s2 = getListElement(hotelPrice_Xpath);
		List<WebElement> s3 = getListElement(hotelPriceTotal_Xpath);

		for (int i = 0; i <= 2; i++) {
			String str1 = s1.get(i).getText();
			System.out.println("Name of the Hotel: " + str1);
			String str2 = s2.get(i).getText();
			System.out.println("Price per night: " + str2);
			String str3 = s3.get(i).getText();
			System.out.println("Total price: " + str3);
			System.out.print("\n");
		}
	}

	// clicking on cruise link
	public void getCruiseSite(String cruiseLink_Xpath) throws Exception {
		Thread.sleep(5000);
		WebElement sel1 = getElement(cruiseLink_Xpath);
		sel1.click();
	}

}
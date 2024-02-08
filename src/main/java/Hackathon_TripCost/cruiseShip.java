package Hackathon_TripCost;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

/* Author name
* Gerald Hadley Brownie
* Prabhu Shanmugam
* Rajesh R 
* Sai Sushmita
* Vinay Vaida
*/

//extending to hotelHome class
public class cruiseShip extends hotelHome {

	// selecting cruise
	public void selCruiseDet(String cruLine_Xpath, String cruLineSel_Xpath, String searchBut_Xpath) throws Exception {
		WebElement sel1 = getElement(cruLine_Xpath);
		sel1.click();
		Thread.sleep(2000);
		WebElement sel2 = getElement(cruLineSel_Xpath);
		sel2.click();
		Thread.sleep(2000);
		WebElement sel3 = getElement(searchBut_Xpath);
		sel3.click();
//switching to next tab
		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
		// int x = tabHandles.size();
		// System.out.println(x);

		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);

		}

	}

//clicking on languages and listing down the languages available
	public void selLangList(String lanBut_Xpath, String lanList_Xpath) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(10000);
		WebElement sel1 = getElement(lanBut_Xpath);
		sel1.click();
		List<WebElement> s1 = getListElement(lanList_Xpath);
		System.out.println("Languages names in list:");
		for (WebElement ele : s1) {
			System.out.println(ele.getText());
		}

	}

//lisiting number of passengers, crews and year of launch
	public void selPasCreYrList(String passenger_Xpath, String launchYear_Xpath) throws Exception {
		System.out.println("\nPassenger and crew details:");
		WebElement sel1 = getElement(passenger_Xpath);

		WebElement sel3 = getElement(launchYear_Xpath);
		System.out.println(sel1.getText());

		System.out.println("\nLaunch Year:");
		System.out.println(sel3.getText() + "\n");
	}

//exiting browser
	public void exitBrowser() {
		driver.quit();
	}

	// getting time stamp
	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

	// taking screenshot
	public static String screenShot(WebDriver driver) throws Exception {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "\\failScreenshot\\error_" + getTimeStamp() + ".png";
		FileHandler.copy(srcFile, new File(screenshotPath));

		return screenshotPath;
	}

	// taking screenshot
	public static String screenShot1(WebDriver driver) throws Exception {
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='50%'");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-4000)");
		Thread.sleep(2000);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath1 = System.getProperty("user.dir") + "\\screenshot\\output_" + getTimeStamp() + ".png";
		FileHandler.copy(srcFile, new File(screenshotPath1));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
		return screenshotPath1;
	}
}
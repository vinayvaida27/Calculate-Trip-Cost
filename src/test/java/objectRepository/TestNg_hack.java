package objectRepository;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//normal testNg class 
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Hackathon_TripCost.cruiseShip;
import Hackathon_TripCost.hotelHome;

/* Author name
* Gerald Hadley Brownie
* Prabhu Shanmugam
* Rajesh R 
* Sai Sushmita
* Vinay Vaida
*/

public class TestNg_hack extends cruiseShip {

	hotelHome hh = new hotelHome();
	cruiseShip cs = new cruiseShip();
	public ExtentReports report;
	public ExtentTest logger;

	// creating extent reports method
	@BeforeSuite
	public void setUpSuite() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\reports\\" + getTimeStamp() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);

	}
	//executing browser
	@BeforeMethod
	public void beforeTest()  {
		logger = report.createTest("Open Browser");
		try {
			hh.invokeBrowser("browser");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("Starting browser");
		logger.pass("Browser opened successfully");
		

	}

//calling methods to execute
	@Test
	public void Test1() {
		logger = report.createTest("access url");
		try {
			hh.getUrl("url");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("accessing url");
		logger.pass("url working fine");

		logger = report.createTest("entering destination");
		try {
			hh.searchDestination("homeSearchBox_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("searching destination");
		logger.pass("search working fine");

		logger = report.createTest("select Hotel Home");
		try {
			hh.selHolHom("holHom_PartialLinkText");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("clicking on Hotel Home Button");
		logger.pass("clicked");

		logger = report.createTest("enter dates");
		try {
			hh.Check_IN_OUT("checkIn_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("entering dates in checkin and checkout");
		logger.pass("entered");

		logger = report.createTest("select no.of adults");
		try {
			hh.selAdult("selAdu_Xpath", "incre_Xpath", "apply_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("incremented");
		logger.pass("applied");

		logger = report.createTest("sort by traveller rating");
		try {
			hh.sortTra("clickSort_Xpath", "clickTra_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("sorting");
		logger.pass("sorted");

		logger = report.createTest("select amenities Elevator/Lift");
		try {
			hh.selAmenities("more_Xpath", "amn_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("selecting");
		logger.pass("selected");

		logger = report.createTest("select amenities Elevator/Lift");
		try {
			hh.getHotNamePrice("hotelName_Xpath", "hotelPrice_Xpath", "hotelPriceTotal_Xpath");
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("selecting");
		logger.pass("selected");
		try {
			screenShot1(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger = report.createTest("select cruise");
		try {
			hh.getCruiseSite("cruiseLink_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("selecting");
		logger.pass("selected");

		logger = report.createTest("select cruise type");
		try {
			cs.selCruiseDet("cruLine_Xpath", "cruLineSel_Xpath", "searchBut_Xpath");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("selecting");
		logger.pass("selected");

		logger = report.createTest("Print languages");
		try {
			cs.selLangList("lanBut_Xpath", "lanList_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("clicking on language button");
		logger.pass("printed");

		logger = report.createTest("Print no.of passenger, crew & year launch");
		try {
			cs.selPasCreYrList("passenger_Xpath", "launchYear_Xpath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail(e);
		}
		logger.info("locating elements");
		logger.pass("printed");

		try {
			screenShot1(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//quiting browser
	@AfterClass
	public void afterTest() {
		report.flush();
		driver.quit();

	}

//checking if the execution is successful
	@AfterMethod
	public void flush(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());

		}

	}
}

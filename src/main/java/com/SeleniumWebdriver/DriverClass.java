package com.SeleniumWebdriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.SeleniumUtilities.AllureEnvironmentXMLWriter;
import com.SeleniumUtilities.getJsonDataSet;
import com.google.common.collect.ImmutableMap;

public class DriverClass {
	protected static WebDriver driver;
	public static Properties envConfig;
	public long waitTime = 30;
	private static final Logger log = LogManager.getLogger(DriverClass.class);
	public static final String ENV = System.getProperty("env", "Production");

	@BeforeSuite
	@Parameters("browser")
	public void Setup(String browser) throws IOException, ParseException, InterruptedException {
		
		File configDataFile = new File("./src/main/resources/Config.json");
		
		//Creating getJsonDataSet class object.
		getJsonDataSet getJsonDataSetObj = new getJsonDataSet();
		
		//Get dataSet string array
		List<String> dataSet = getJsonDataSetObj.getDataSet(configDataFile);
		
		//write environment.xml for allure report.
		setAllureEnvironment(dataSet);

		if (browser.equalsIgnoreCase("chrome")) {

			//File file = new File("binaries" + File.separator + "chromedriver.exe");
			
			File file = new File("binaries" + File.separator + "chromedriver_125.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Chrome Driver is initialized");

		} else if (browser.equalsIgnoreCase("edge")) {

			File file = new File("binaries" + File.separator + "msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Edge Driver is initialized");
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			
			File file = new File("binaries" + File.separator + "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Firefox is initialized");
				
			}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(dataSet.get(6));
		//driver.get("https://messages.google.com/web/conversations/");
		//Thread.sleep(120000);
		log.info("Url Loaded");

	}

	@AfterSuite
	public void exit() {
		//System.out.println("test done");
		driver.quit();
	}
	//Write allure environment.xml file
	public static void setAllureEnvironment(List<String> dataSet) {
		AllureEnvironmentXMLWriter XmlWriterObj= new AllureEnvironmentXMLWriter();
		XmlWriterObj.allureEnvironmentWriter(
	                ImmutableMap.<String, String>builder()
	                        .put("Browser", dataSet.get(1))
	                        .put("Browser.Version", dataSet.get(4))
	                        .put("Application", dataSet.get(5))
	                        .put("URL", dataSet.get(6))
	                        .build());
	}
	 
}

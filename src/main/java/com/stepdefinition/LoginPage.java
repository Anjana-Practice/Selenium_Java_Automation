package com.stepdefinition;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SeleniumCucumberRunner.WebDriverUtils;

public class LoginPage extends WebDriverUtils {
    WebDriverWait wait;
    public LoginPage() {
    	
    }
    
    @When("I initialize driver")
    public void initializeDriver() {
        File file = new File("binaries" + File.separator + "chromedriver_125.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriverUtils.setDriver(new ChromeDriver());
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Then("open browser")
    public void openBrowser() {
        WebDriver driver = WebDriverUtils.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Given("user is already on Login Page")
    public void user_is_on_login_page() throws Exception {
        System.out.println(driver.getCurrentUrl());
    }
    @Then("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) throws Exception {
        this.wait = new WebDriverWait(driver, 20L);
        WebElement username = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys(new CharSequence[]{Keys.CONTROL + "t"});
        username.clear();
        username.sendKeys(new CharSequence[]{string});
        WebElement password = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@Placeholder='Password']")));
        password.sendKeys(new CharSequence[]{Keys.CONTROL + "t"});
        password.clear();
        password.sendKeys(new CharSequence[]{string2});
    }
    @Then("user clicks on login button")
 public void user_clicks_on_login_button() {
        this.wait = new WebDriverWait(driver, 20L);
        WebElement loginButton = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        loginButton.sendKeys(new CharSequence[]{Keys.CONTROL + "t"});
        loginButton.sendKeys(new CharSequence[]{Keys.ENTER});
    }

    @Then("check whether user is navigated to Home page")
    public void check_whether_user_is_navigated_to_home_page() {
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
            System.out.println("User is navigated to Home page");
        } else {
            System.out.println("User is not navigated to Home page");
        }

    }

    @Then("Close browser")
    public void closeBrowser() {
        driver.close();
    }

    @AfterStep
    public void takeScreenshotOnFaliure(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot Screenshot = (TakesScreenshot)driver;
            File scrshots = (File)Screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(scrshots, new File("./Screenshot/" + scenario.getName() + ".png"));
            } catch (IOException var5) {
                System.out.println("Unable to Capture the screenshot");
            }
        }

    }
}
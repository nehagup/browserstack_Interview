package automate_windows10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;



        // task : 5

public class logging_test {

    public static final String USERNAME = "nehagupta36";
    public static final String AUTOMATE_KEY = "7yrKTos5tS24iozDxxSo";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.browserstack.com");

        WebElement LocationLink = driver.findElement(By.linkText("Sign in"));
        LocationLink.click();

        // task : 3

        driver.findElement(By.id("user_email_login")).sendKeys("neha.gup@icloud.com");
        driver.findElement(By.id("user_password")).sendKeys("nehagupta");
        driver.findElement(By.name("commit")).click();

        // task : 4
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElements(By.linkText("Sign in")).size() , 0);

        driver.quit();

    }


}
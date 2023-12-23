package com.grid.demo.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jay
 */
public class SauceLabsDemo {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("119");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-primecommunity103-36640");
        sauceOptions.put("accessKey", "e61981c7-7887-4269-b369-09f6976bb57a");
        sauceOptions.put("build", "nop commerce 1");
        sauceOptions.put("name", "Login Test");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

    }

    @Test
    public void sauceLabTest() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        System.out.println("title of page is: " + driver.getTitle());
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

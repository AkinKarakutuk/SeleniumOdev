package com.testinium.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public static WebDriver driver;

    @Before
    public  void setup(){
        System.out.println("Selenium Odev");

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");

        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");

        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser","Chrome 12");
        caps.setCapability("os","windows");
        chromeOptions.merge(caps);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.kitapyurdu.com/");


    }

    @After
    public  void teardown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
}

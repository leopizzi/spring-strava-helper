package com.pizzi.stravaHelper.motor;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@org.springframework.context.annotation.Configuration
@Log4j2
public class Configuration {
    private WebDriver driver;
    @Autowired
    private Environment env;

    public WebDriver getWebDriver() {
        log.info("Configuring chrome driver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if(Boolean.parseBoolean(env.getProperty("headless-browser")))
            options.addArguments("--headless");
        driver = new ChromeDriver(options);
        return driver;
    }

    public void loginOnStrava() throws InterruptedException {
        log.info("Login in on Strava");
        driver.get("https://www.strava.com/login");
        driver.findElement(By.id("email")).sendKeys(env.getProperty("login"));
        driver.findElement(By.id("password")).sendKeys(env.getProperty("password"));
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        driver.get("https://www.strava.com/dashboard/following/200");
        Thread.sleep(5000);

    }
}

package com.pizzi.stravaHelper.motor;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@Component
@Log4j2
public class StravaLiker {

    @Autowired
    private Configuration conf;
    @Autowired
    private FileWriter fileWriter;
    private List<WebElement> elements;
    private WebDriver driver;


    @Scheduled(fixedRate = 3600000)
    public void giveLikes() throws IOException, InterruptedException {
        driver = conf.getWebDriver();
        conf.loginOnStrava();

        getElements();

        if (elements.size() != 0) {
            log.info("Giving " + elements.size() + " kudos!");
            giveKudos();
            fileWriter.saveLikesGiven(String.valueOf(elements.size()));
        } else {
            log.info("No kudos to give");
        }

        log.info("Closing web driver");
        driver.close();
    }

    private void getElements() {
        log.info("Getting HTML elements");
        elements = new ArrayList<>(driver.findElements(By.xpath("//*[@title='Give Kudos']")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void giveKudos() {
        for (WebElement w : elements) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", w);
        }
    }
}
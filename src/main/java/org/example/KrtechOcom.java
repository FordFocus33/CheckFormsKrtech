package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;

public class KrtechOcom implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ocom.krtech.ru/");
        try {
            Thread.sleep(1000);
            // Enter login
            WebElement login = driver.findElement(By.xpath("/html/body/main/section[1]/div[2]/div/button[1]"));
            login.click();

            WebElement name = driver.findElement(By.xpath("//*[@id=\"form-name\"]"));
            name.sendKeys("Test");

            WebElement email = driver.findElement(By.id("form-email"));
            email.sendKeys("test@mail.ru");


            WebElement phoneNumber = driver.findElement(By.id("form-phone"));
            phoneNumber.sendKeys("+79780000000");

            WebElement checkBox = driver.findElement(By.id("order-agree"));
            checkBox.click();

            WebElement submit = driver.findElement(By.xpath("/html/body/section/form/button"));
            submit.click();


            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

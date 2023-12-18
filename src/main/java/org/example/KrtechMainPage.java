package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;

public class KrtechMainPage implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://krtech.ru/");
        try {
            Thread.sleep(1000);
            // Enter login
            WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/a"));
            login.click();

            WebElement firstcheck = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div[2]/label[1]/div"));
            firstcheck.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 1000)");

            Thread.sleep(1000);

            WebElement secondcheck = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[3]/div[2]/label[6]/div"));
            secondcheck.click();

            WebElement thirdcheck = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[4]/div[2]/label[1]/div"));
            thirdcheck.click();

            js.executeScript("window.scrollBy(0, 1800)");
            Thread.sleep(1000);

            WebElement name = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[8]/div[2]/input"));
            name.sendKeys("Test Test Test");

            WebElement phone = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[8]/div[4]/div[1]/input"));
            phone.sendKeys("+79780000000");

            WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[8]/div[4]/div[2]/input"));
            email.sendKeys("test@mail.ru");

            js.executeScript("window.scrollBy(0, 500)");
            Thread.sleep(1000);

            WebElement check = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[8]/div[5]/div/label/div"));
            check.click();

            WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[8]/div[6]/input"));
            submit.click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;

public class KrtechDialog implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://dialog.krtech.ru/#");

        try {
            Thread.sleep(1000);


            // Enter login
            WebElement login = driver.findElement(By.xpath("/html/body/div[16]/div[2]/div/div/div/div[2]/div/div/div/div/a"));
            login.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/form/div[3]/div[1]/input")));
            element.sendKeys("Test Test Test");
            // Но можно и вот так...
            //WebElement webElement = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[3]/div[1]/input"));
            //webElement.sendKeys("Привет");

            WebElement phoneNumber = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[3]/div[2]/input"));
            phoneNumber.sendKeys("+79780000000");

            WebElement email = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div[2]/input"));
            email.sendKeys("test@mail.ru");

            WebElement checkBox = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[6]/div/label/div"));
            checkBox.click();

            WebElement submit = driver.findElement(By.xpath("/html/body/div[4]/div/form/a"));
            submit.click();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

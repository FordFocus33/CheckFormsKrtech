package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;
import java.util.Scanner;

public class KrtechEcp implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Подключаемся по ссылке
        driver.get("https://ecp.krtech.ru/");
        try {
            Thread.sleep(3000);
            // Пока с таким костылем в ввиде сканера

            Scanner scanner = new Scanner(System.in);

            WebElement login = driver.findElement(By.xpath("/html/body/main/section[1]/div/div[2]/button[1]"));
            login.click();
            Thread.sleep(3000);

            String id = scanner.nextLine();

            WebElement name = driver.findElement(By.id("form-name" + id));
            name.sendKeys("Test");

            WebElement email = driver.findElement(By.id("form-email" + id));
            email.sendKeys("test@mail.ru");

            WebElement phoneNumber = driver.findElement(By.id("form-phone" + id));
            phoneNumber.sendKeys("+79780000000");

            WebElement checkBox = driver.findElement(By.id("order-agree" + id));
            checkBox.click();

            WebElement submitButton = driver.findElement(By.xpath("/html/body/section[1]/form/button"));
            submitButton.click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

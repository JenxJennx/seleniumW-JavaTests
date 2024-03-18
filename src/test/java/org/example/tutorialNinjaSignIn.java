package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class tutorialNinjaSignIn {
    public static void main(String[] args) {
        //set up system and chromedriver
        WebDriver driver = new ChromeDriver();
        System.setProperty("driver.chrome.driver", "chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //setup page
        driver.get("http://tutorialsninja.com/demo/");

        WebElement myAccountButton = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a > span.hidden-xs.hidden-sm.hidden-md"));
        myAccountButton.click();
        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        logInButton.click();


        //test login
        String title = driver.getTitle();
        System.out.println(title);

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("thecleanestdetective104@gmail.com");

        WebElement emailPassword = driver.findElement(By.id("input-password"));
        emailPassword.sendKeys("Trudy&Monk4L");

        //confirm loginButton is active
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        Boolean isSubmitButtonEnabled = loginButton.isEnabled();
        assertEquals(isSubmitButtonEnabled.booleanValue(), true);

        loginButton.click();





    }
}

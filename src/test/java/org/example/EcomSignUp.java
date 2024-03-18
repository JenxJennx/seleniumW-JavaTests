package org.example;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EcomSignUp {
    public static void main(String[] args) {
        //manage the webdriver and create an instance of chromedriver
        WebDriver driver = new ChromeDriver();
        System.setProperty("driver.chrome.driver", "chromedriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");

        String title = driver.getTitle();
        //System.out.println(title);


        //check if the search button is working
        WebElement searchEnterButton = driver.findElement(By.cssSelector("#id-c9bb61e1-2df8-48c0-98d9-72996b01723d > div > div.input-wrapper.sm0exuu > div.skzcp5r > form > div > div > button"));
//        searchEnterButton.isEnabled();
//        assertEquals(searchEnterButton, true);

        //Confirm the title
        String assumedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        assertEquals(title, assumedTitle);


        WebElement searchBar = driver.findElement(By.id("id-c706dbb1-c6f1-4c26-b46b-fa1bba2f8049"));
        searchBar.click();
        String inputDomain = "www.google.com";
        searchBar.sendKeys(inputDomain);
        searchEnterButton.click();


        driver.quit();










    }
}

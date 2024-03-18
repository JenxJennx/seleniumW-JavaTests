package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class tutorialNinjaRegister {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("driver.chrome.driver", "chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);

        driver.get("http://tutorialsninja.com/demo/");
        String title = driver.getTitle();
        System.out.println("done");

        //Click account test
        WebElement myAccountButton = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a > span.hidden-xs.hidden-sm.hidden-md"));
        boolean isEnabled = myAccountButton.isEnabled();
        assertEquals(isEnabled, true);
        System.out.println(isEnabled);

        //is the dropdown list working when you press account?
        myAccountButton.click();
        WebElement dropDownList = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open"));
        boolean ddlIsDisplayed = dropDownList.isDisplayed();
        System.out.println(ddlIsDisplayed);

        //is Register button working
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        Boolean isRegisterButtonEnabled = registerButton.isEnabled();
        assertEquals(isRegisterButtonEnabled.booleanValue(), true);

        registerButton.click();

        //fill out button
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Adrian");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Monk");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("thecleanestdetective104@gmail.com");

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("972-403-5903");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Trudy&Monk4L");

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("Trudy&Monk4L");

        WebElement checkElement = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        checkElement.click();

        //submit the document
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueButton.click();

        //confirm account is created
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        String actualSuccessMessage = successMessage.getText();
        String expectedSuccess = "Your Account Has Been Created!";
        assertEquals(actualSuccessMessage, expectedSuccess);


    }
}

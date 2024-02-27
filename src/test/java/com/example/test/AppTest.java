package com.example.test;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
WebDriver driver;

 

    @BeforeSuite
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Softwares/ChromeDriver/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origin=*");

        driver = new ChromeDriver(option);

      
    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }

    @Test(priority = 0)
    public void test1()
    {
        driver.get("https://testautomationpractice.blogspot.com/");
        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals( "Automation Testing Practice",title);
    }
@Test(priority = 1)
public void multipleWindow() throws InterruptedException
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@id='sidebar-right-1']//button)[1]")));
    driver.findElement(By.xpath("(//*[@id='sidebar-right-1']//button)[1]")).click();
   Thread.sleep(5000);

    Set<String> windows = driver.getWindowHandles();
    for(String window: windows)
    {
        String parentWindow = driver.getWindowHandle();
        if(!parentWindow.equals(window))
        {
            System.out.println(driver.switchTo().window(window).getTitle());
        }
    }
}
    
}

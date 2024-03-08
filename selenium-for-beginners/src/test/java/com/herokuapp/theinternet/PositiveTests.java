package com.herokuapp.theinternet;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test
	public void loginTest() {
		System.out.println("Test Started");
		//Create Driver
		 System.setProperty("webdriver.chrome.driver", "C:/Users/ismai/eclipse-workspace/learningspace/selenium-for-beginners/src/main/resources/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started");
		sleep(1);
		
//		Open test page
		
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(1);
		
		driver.manage().window().maximize();
		System.out.println("Paged is opened");
		sleep(1);
		
//		enter Username
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		
//		enter Password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		
		
//		click login button
		
		WebElement loginbutton = driver.findElement(By.tagName("button"));
		loginbutton.click();
		
//		
//		Verification:
//			new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl, "Actual is not same as expected");
		
//			successfull message
		WebElement successmsg = driver.findElement(By.cssSelector("#flash"));
		String expectedmsg = "You logged into a secure area!";
		String Actualmsg = successmsg.getText();
		
		//Assert.assertEquals(Actualmsg, expectedmsg, "ActualMsg is not same as expected");
		Assert.assertTrue(Actualmsg.contains(expectedmsg), "ActualMsg is doesnot contain expected msg.\n Actual Message:" + Actualmsg + "\n Expected Msg:" + expectedmsg);
		
		
		//logout button is visible
		WebElement logoutbutton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		
		Assert.assertTrue(logoutbutton.isDisplayed(), "logoutbutton is not displayed");
		
		//logoutbutton.click();
		
		
		driver.close();
		System.out.println("Test Finised");
		
		
	}

	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

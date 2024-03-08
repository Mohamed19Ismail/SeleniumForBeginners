package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	@Test(priority = 1)
	public void InvalidUserNameTest() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/ismai/eclipse-workspace/learningspace/selenium-for-beginners/src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/login");
		sleep(1);

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Invalid");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		sleep(1);

		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
		sleep(1);

		WebElement Invaliddmsg = driver.findElement(By.id("flash-messages"));

		String expectedmsg = "Your username is invalid!";
		String actualmsg = Invaliddmsg.getText();
		System.out.println(actualmsg);
		Assert.assertTrue(actualmsg.contains(expectedmsg), expectedmsg);
		sleep(1);

		driver.quit();

	}
	
	@Test
	public void InvalidPasswordTest() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/ismai/eclipse-workspace/learningspace/selenium-for-beginners/src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/login");
		sleep(1);

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Invalid!");
		sleep(1);

		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
		sleep(1);

		WebElement Invaliddmsg = driver.findElement(By.id("flash-messages"));

		String expectedmsg = "Your password is invalid!";
		String actualmsg = Invaliddmsg.getText();
		System.out.println(actualmsg);
		Assert.assertTrue(actualmsg.contains(expectedmsg), expectedmsg);
		sleep(1);

		driver.quit();

	}

	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

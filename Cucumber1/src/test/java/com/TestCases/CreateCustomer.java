package com.TestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCustomer {
	
	ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		Random r=new Random();
		int num=r.nextInt(1000);
		String actualName="Arun";
		 actualName=actualName+num;
		CreateCustomer cc=new CreateCustomer();
		cc.LaunchBrowser();
		cc.login();
		Thread.sleep(1000);
		String expcustName=cc.CustomerCreation(actualName);
		System.out.println(actualName);
		System.out.println(expcustName);
		
	if(actualName.equals(expcustName)) {
		System.out.println("test case is pass");
	}
	else {
		System.out.println("Test case is failed");
	}
		cc.closeBrowser();
	}
		public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		public void login() {
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		}
		public String CustomerCreation(String actualName) throws InterruptedException {
			driver.findElement(By.id("container_tasks")).click();
			driver.findElement(By.xpath("//div[text()='Add New']")).click();
			driver.findElement(By.className("createNewCustomer")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("newNameField")).sendKeys(actualName);
			driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("customre description");
			driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
			Thread.sleep(2000);
			String resultName=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
			return resultName;
				
		}
		public void closeBrowser() {
			driver.close();
		}
		

}

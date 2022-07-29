package com.wb3.springbootdocker;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PlacesStepsDefinition {

	WebDriver driver;

	@Given("Open the chrome and launch the application")
	public void open_the_chrome_and_launch_the_application() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://places-app.azurewebsites.net/");
	}

	@Then("Application name is displayed")
	public void application_name_is_displayed() {
		String applicationName = driver.findElement(By.id("app-title")).getText();
		assertTrue(applicationName.equals("App Lugares"));
		driver.close();
	}

}
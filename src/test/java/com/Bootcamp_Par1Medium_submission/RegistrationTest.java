
package com.Bootcamp_Par1Medium_submission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
	public WebDriver driver;

	public RegistrationPage registrationPage;



	@BeforeMethod

	public void setUp() {

	driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("tutorialsninja.com/demo/");

	registrationPage = new RegistrationPage(driver);

	registrationPage.openRegistrationPage();

	}



	@Test

	public void testSuccessfulRegistrationWithValidCredentials() {

	registrationPage.enterFirstName("John");

	registrationPage.enterLastName("Doe");

	registrationPage.enterEmail("johnwe.doe@example.com");

	registrationPage.enterTelephone("1234567890");

	registrationPage.enterPassword("password123");

	registrationPage.confirmPassword("password123");

	registrationPage.checkAgreeCheckbox();

	registrationPage.clickContinueButton();



	// Assuming there is a success message after registration

	//String successMessage = "Your account has been created!";

	// Assert.assertTrue(driver.getPageSource().contains(), "Your Account Has Been  Created!");

	

	Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'Congratulations! Your new account has been successfully created!']")).isDisplayed());



	}



	 @AfterMethod

	public void tearDown() {

	driver.quit();

	}

	}





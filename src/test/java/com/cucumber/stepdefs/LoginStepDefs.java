/*
 * Copyright (c) 2022 SAM
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.cucumber.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.BaseConfig;
import com.generic.CrossBrowserCheck;
import com.generic.MasterPageFactory;
import com.util.Flight;
import com.util.HighLighter;
import com.util.ScreenShot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefs {
	BaseConfig BC = new BaseConfig();
	HighLighter highLighter = new HighLighter();
	WebDriver driver;
	
	@Given("Open Browser")
	public void getbrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = CrossBrowserCheck.browserCheck("chrome");
	}

	@Then("go to application URL {string}")
	public void getURL(String url) throws Exception
	{
		driver.get(BC.getValue(url));
		driver.manage().window().maximize();
	}

	@And("put valid username {string}")
	public void getUsername(String user) throws Exception
	{
		MasterPageFactory MPF = new MasterPageFactory(driver);
		//highLighter.getColor(driver, MPF.getUserName(), "Tomato");
		MPF.getUserName().sendKeys(BC.getValue(user));
	}

	@And("put valid password {string}")
	public void getPassword(String pass) throws Exception
	{
		MasterPageFactory MPF = new MasterPageFactory(driver);
		highLighter.getColor(driver, MPF.getPassword(),"Olive");
		MPF.getPassword().sendKeys(BC.getValue(pass));
	}

	@Then("click signin button")
	public void clickSignin() 
	{
		MasterPageFactory MPF = new MasterPageFactory(driver);
		highLighter.getColor(driver,MPF.getSubmit(),"Red");
		MPF.getSubmit().click();
	}

	@Then("login should be successful and showed sign out button") 
	public void checkSigninvalidation() throws Throwable 
	{ 
		MasterPageFactory MPF = new MasterPageFactory(driver);
		ScreenShot.getScreenShot(driver,"Login Test status");
		Assert.assertEquals(MPF.getLoginStatusSuccessMsg().getText(),"Login Successfully");// fail=stop
		Assert.assertTrue(MPF.getSignOffList().get(7).isDisplayed());// stopped here
	 }
	
	@Then("click Fight URL")
	public void Flight() throws Throwable
	{
		Flight flight = new Flight();
		flight.flightBooking(driver);
	}
	 
	@And("close browser")
	public void closeBrowser() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.quit();
	}

}

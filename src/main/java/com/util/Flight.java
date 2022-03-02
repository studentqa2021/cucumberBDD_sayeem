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

package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.generic.BaseConfig;
import com.generic.MasterPageFactory;

public class Flight 
{
	MasterPageFactory MPF;
	BaseConfig BC;
	public void flightBooking(WebDriver driver) throws Throwable
	{
		MPF = new MasterPageFactory(driver);
		BC = new BaseConfig();
		MPF.getSignOffList().get(1).click();
		Thread.sleep(3000);
		if(BC.getValue("triptype").toLowerCase().equals("oneway"))
		{
		MPF.getTripType().get(1).click();
		}
		MPF.getPassCount().sendKeys(BC.getValue("passcount"));
		MPF.getDepartPort().sendKeys(BC.getValue("depart").toLowerCase());
		MPF.getFromMonth().sendKeys(BC.getValue("departMonth"));
		MPF.getFromDay().sendKeys(BC.getValue("departDay"));
		MPF.getArrivePort().sendKeys(BC.getValue("arrive").toLowerCase());
		MPF.getToMonth().sendKeys(BC.getValue("arriveMonth"));
		MPF.getToDay().sendKeys(BC.getValue("arriveday"));
		if(BC.getValue("flightClass").toLowerCase().equals("business class"))
		{
		MPF.getFlightClass().get(1).click();
		}
		else if(BC.getValue("flightClass").toLowerCase().equals("first class"))
		{
		MPF.getFlightClass().get(2).click();
		}
		else
		{
			MPF.getFlightClass().get(0).click();
		}
		MPF.getAirline().sendKeys(BC.getValue("airline"));
		MPF.getFindFlights().submit();
		Thread.sleep(2000);
		if(MPF.getWarning().isDisplayed())
			((JavascriptExecutor)driver).executeScript("alert('No seats Available');");
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		ScreenShot.getScreenShot(driver, "Flight-feature");
		
	}
}

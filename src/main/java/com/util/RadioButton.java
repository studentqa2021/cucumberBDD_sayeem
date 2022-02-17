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

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {
	
	static WebElement radio;
	
	public static void radioButton(WebDriver driver, String value)
	{
		
		if(value.toLowerCase().equals("male"))
		{
			 radio = driver.findElement(By.xpath("//*[@id = 'gender-radio-1']"));
		}
		else if(value.toLowerCase().equals("female"))
		{
			 radio = driver.findElement(By.xpath("//*[@id = 'gender-radio-2']"));
		}
		else
		{
			 radio = driver.findElement(By.xpath("//*[@id = 'gender-radio-3']"));
		}
		//Thread.sleep(7000);
		radio.sendKeys(Keys.SPACE);
		
	}
	
	public static void checkButton(WebDriver driver, String value)
	{
		if(value.toLowerCase().equals("sports"))
		{
			 radio = driver.findElement(By.xpath("//*[@id = 'hobbies-checkbox-1']"));
		}
		else if(value.toLowerCase().equals("reading"))
		{
			 radio = driver.findElement(By.xpath("//*[@id = 'hobbies-checkbox-2']"));
		}
		else
		{
			 radio = driver.findElement(By.xpath("//*[@id = 'hobbies-checkbox-3']"));
		}
		
		radio.sendKeys(Keys.SPACE);
		
	}

}

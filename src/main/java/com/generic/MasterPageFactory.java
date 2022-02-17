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

package com.generic;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class MasterPageFactory {
	
	public MasterPageFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@name = 'userName']")
	private WebElement userName;
	@FindBy(xpath = "//*[@name = 'password']")
	private WebElement password;
	@FindBy(xpath = "//*[@name = 'submit']")
	private WebElement submit;
	@FindBy(xpath = "(//*[@class='mouseOut'])[8]")//1 of 11==>8
	private WebElement signOff;// findElement()
	@FindBy(xpath = "//*[@class='mouseOut']")//1 of 11
	private List<WebElement> signOffList;// findElements() ==> object 8 >> get(7)
	@FindBy(xpath = "//*[text()='Login Successfully']")
	private WebElement loginStatusSuccessMsg;
	
}

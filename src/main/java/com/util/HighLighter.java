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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {
	
	public void getColor (WebDriver driver, WebElement element,String color) 
        {
		
		
            ((JavascriptExecutor)driver).executeScript(
                    "arguments[0].style.border='5px solid "+color+"'", element);
		
			
	}
	public void getColor (WebDriver driver, WebElement element) 
        {
            Map<Integer,String> color = new HashMap<>();
            Random r = new Random();
            int rand;
            color.put(1, "arguments[0].style.border='5px solid red'");
            color.put(2, "arguments[0].style.border='5px solid blue'");
            color.put(3, "arguments[0].style.border='5px solid green'");
            color.put(4, "arguments[0].style.border='5px solid yellow'");
            color.put(5, "arguments[0].style.border='5px solid purple'");
            rand = r.nextInt(5)+1;
		
		
		((JavascriptExecutor)driver).executeScript(
                        ""+color.get((rand)), element);
		
			
	}
}
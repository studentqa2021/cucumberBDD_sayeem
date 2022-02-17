package com.util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String getScreenShot(WebDriver driver,String ScreenShotName) throws Throwable {
		
		File folder = new File("./target/Screen shot");//where & name
		if(!folder.exists()) {// no folder there
			folder.mkdir();//create folder
		}
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;// type casting
		File screenShotfile= ts.getScreenshotAs(OutputType.FILE);
		String destination= "./target//Screen Shot//" +ScreenShotName + ".png";
		FileUtils.copyFile(screenShotfile, new File(destination));
		return destination;
	}


}

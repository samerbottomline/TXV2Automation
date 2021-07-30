package com.bottomline.loging;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.bottomline.common.Base;
import org.apache.commons.io.FileUtils;

public class Screenshot {

	public Screenshot(WebDriver driver) {
		TakesScreenshot sc = ((TakesScreenshot) driver);
		File screenshotFile = sc.getScreenshotAs(OutputType.FILE);
		String today = LocalDate.now().toString();
		String savePath = System.getProperty("user.dir") + "\\Screenshots\\{date}.png".replace("{date}", today);
		File destination = new File(savePath);

		try {

			if (screenshotFile.exists()) {
				screenshotFile.delete();
			}

			FileUtils.moveFile(screenshotFile, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
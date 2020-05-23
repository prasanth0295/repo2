import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowserForSS {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://telugu.greatandhra.com");

		String dateTime = new Date().toString().replace(":", "_").replace(" ", "_");
		String fileName = "Error At " + dateTime;
		String newFile = ".//screenprints/" + fileName + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(newFile));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			driver.quit();
		}
System.out.println("Completed");
		driver.quit();
	}

}

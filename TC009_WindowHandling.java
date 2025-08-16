package pac1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009_WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/window");

		driver.findElement(By.id("home")).click();
		String pwindow = driver.getWindowHandle();
		System.out.println("parent window: "+pwindow);
		System.out.println("url is: "+driver.getCurrentUrl());
		
		driver.findElement(By.id("multi")).click();
		Set<String> mwindow = driver.getWindowHandles();
		
		for(String cwindow:mwindow) {
			driver.switchTo().window(cwindow);
			System.out.println("url is: "+driver.getCurrentUrl());
		}
		
		driver.close();
		driver.quit();
	}

}

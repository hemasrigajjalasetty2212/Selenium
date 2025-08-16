package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println("Title: "+driver.getTitle());
		
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automation testing tools");
		Thread.sleep(3000);
		//search.sendKeys(Keys.ENTER);
		//Thread.sleep(3000);
		search.submit();

		System.out.println("Title: "+driver.getTitle());
		//driver.findElement(By.("PD3zdc")).click();
		
		//Thread.sleep(115000);
		//driver.quit();
		
	}

}

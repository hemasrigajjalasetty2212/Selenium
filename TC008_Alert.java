package pac1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");

		driver.findElement(By.id("accept")).click();
		
		Alert salert = driver.switchTo().alert();
		
		System.out.println("The Message: "+salert.getText());
		salert.accept();
		
		driver.findElement(By.id("confirm")).click();
		Alert calert = driver.switchTo().alert();
		System.out.println("Confirm alert: "+calert.getText());
		calert.dismiss();
		
		driver.findElement(By.id("prompt")).click();
		Alert palert = driver.switchTo().alert();
		System.out.println("Prompt alert: "+palert.getText());
		palert.sendKeys("Hema sri");
		palert.accept();
		
		
		
	}

}

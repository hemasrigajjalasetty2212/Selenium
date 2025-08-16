package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("asdfgh6666@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("asdfgh66");
		
		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		//selecting 25 in show
		WebElement show=driver.findElement(By.id("input-limit"));
		Select sle=new Select(show);
		sle.selectByIndex(1);
		
		//adding first item to cart
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/i")).click();
		
		Thread.sleep(3000);
		//selecting specification
		driver.findElement(By.linkText("Specification")).click();

		//Verifying details present in page
		
		
		
	}

}

package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_L3_L4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		String title = driver.getTitle();   //Lab 4
		if (title.contains("Your Store")) {
			System.out.println("Page title verified.");
		}else {
			System.out.println("Page title not verified.");
		}
		
		// Lab3
		
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();   //Mac (1)
		
		WebElement mac = driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[3]"));
		String macText = mac.getText();
		if (macText.contains("-Mac (1)")) {
			System.out.println("Mac heading verified.");
		} else {
			System.out.println("Mac heading is not verified.");
		}
		
		Thread.sleep(2000);
		WebElement sort = driver.findElement(By.id("input-sort")); //Name (A-Z)
		Select sle = new Select (sort);
		sle.selectByIndex(1);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click(); //add to cart
	
		// Lab 4
		
		driver.findElement(By.name("search")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();   //search button
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-search")).clear();  //clear search 
		Thread.sleep(2000);
		driver.findElement(By.id("input-search")).sendKeys("Monitors");
		driver.findElement(By.name("description")).click();  // click on search in product descriptions
		driver.findElement(By.id("button-search")).click();  // click on search button
		
	}

}

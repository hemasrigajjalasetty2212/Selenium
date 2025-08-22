package pac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12_Configuration {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		Properties prob=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Selenium_Maven\\config.properties");
		prob.load(fis);
		String url=prob.getProperty("url");
		String searchmonitors =prob.getProperty("searchmonitors");
		String searchmobile =prob.getProperty("searchmobile");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		String title = driver.getTitle();   //Lab 4
		if (title.contains("Your Store")) {
			System.out.println("Page title verified.");
		}else {
			System.out.println("Page title not verified.");
		}
		
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
		driver.findElement(By.name("search")).sendKeys(searchmobile);
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();   //search button
		
		driver.findElement(By.id("input-search")).clear();  //clear search 
		Thread.sleep(2000);
		driver.findElement(By.id("input-search")).sendKeys(searchmonitors);
		driver.findElement(By.name("description")).click();  // click on search in product descriptions
		driver.findElement(By.id("button-search")).click();  // click on search button

	
				}
}

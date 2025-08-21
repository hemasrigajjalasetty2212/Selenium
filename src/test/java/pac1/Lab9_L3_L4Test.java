package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Lab9_L3_L4Test {
	WebDriver driver;
	@Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	  }else if (browser.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();	  
	  }
	
	  driver.get("https://tutorialsninja.com/demo/index.php?");
		
  }

  
  @Test(priority=1)
  public void testPageTitle() {
	  String title = driver.getTitle();   //Lab 4
		Assert.assertTrue(title.contains("Your Store"),"Page is not verified");
		System.out.println("page is verified");
		
	  
  }
  
  @Test(priority=2)
  public void testMacSection() throws InterruptedException {
	  driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();   //Mac (1)
		
		WebElement mac = driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[3]"));
		String macText = mac.getText();
		Assert.assertTrue(macText.contains("-Mac (1)"),"Mac heading verified.");
		System.out.println("Mac heading is not verified.");
		
		Thread.sleep(2000);
		WebElement sort = driver.findElement(By.id("input-sort")); //Name (A-Z)
		Select sle = new Select (sort);
		sle.selectByIndex(1);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click(); //add to cart
	
	  
  }
  
  @Test(priority=3)
  public void testSearchFunctionality() throws InterruptedException {
	  driver.findElement(By.name("search")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();   //search button
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-search")).clear();  //clear search 
		
		Thread.sleep(2000);
		driver.findElement(By.id("input-search")).sendKeys("Monitors");
		driver.findElement(By.name("description")).click();  // click on search in product descriptions
		driver.findElement(By.id("button-search")).click();  // click on search button
		
	  
  }
  @AfterClass
  public void afterClass() {
	  if(driver != null) {
		  driver.quit();
	  }
  }

}

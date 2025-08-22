package pac1;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Lab13_repo_xmlTest {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?");
		System.out.println("Before Method");
  }

  @Test(priority=1)
  public void testPageTitle() {
	  String title = driver.getTitle();   //Lab 4
		Assert.assertTrue(title.contains("Your Store"),"Page is not verified");
		System.out.println("page is verified");
		
	  
  }
  
  @Test(priority=2)
  public void testMacSection() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
	  
	  Lab13_repo_xml obj1 = new Lab13_repo_xml(driver);
	  obj1.clickdesktop();
	  obj1.clickmac();
		WebElement mac = driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[3]"));
		String macText = mac.getText();
		Assert.assertTrue(macText.contains("-Mac (1)"),"Mac heading verified.");
		System.out.println("Mac heading is not verified.");
		
		Thread.sleep(2000);
		WebElement sort = driver.findElement(By.id("input-sort")); //Name (A-Z)
		Select sle = new Select (sort);
		sle.selectByIndex(1);
		
		obj1.clickaddcart();
	  
  }
  
  
  @Test(priority=3)
  public void testSearchFunctionality() throws InterruptedException {
	  Lab11_PO obj2 = new Lab11_PO(driver);
	  obj2.entersearchitem("Mobile");
	  obj2.clicksearchbutton();
	 
		Thread.sleep(3000);
		obj2.clearsearch();
		
		Thread.sleep(2000);
		obj2.enteranotheritem("Monitors");
		obj2.clicksearchdescrip();
		obj2.clicksearchbutton();
	  
  }
  @AfterClass
  public void afterClass() {
	  if(driver != null) {
		  driver.quit();
	  }
  }

}

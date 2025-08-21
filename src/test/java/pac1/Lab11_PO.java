package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Lab11_PO {
	WebDriver driver;

	public Lab11_PO(WebDriver driver2) {
		// TODO Auto-generated method stub

		this.driver=driver2;
	}
	By desk = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	By addcart = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]");
	By searchitem = By.name("search");
	By buttonsearch = By.xpath("//*[@id=\"search\"]/span/button");
	By searchitem2 = By.id("input-search");
	By descrip = By.name("description");
	
	public void clickdesktop() {
		driver.findElement(desk).click();
	}
	
	public void clickmac() {
		driver.findElement(mac).click();
	}
	
	public void clickaddcart() {
		driver.findElement(addcart).click();   //add to cart
	}
	
	
	public void entersearchitem(String srch) {
		driver.findElement(searchitem).sendKeys(srch);
	}  	
		
	
	public void clicksearchbutton() {
		driver.findElement(buttonsearch).click();   //search button
	}
	
	public void clearsearch() {
		driver.findElement(searchitem2).clear();  //clear search 
	}
	
	public void enteranotheritem(String srch2) {
		driver.findElement(searchitem2).sendKeys(srch2);
	}
	  
	public void clicksearchdescrip() {
		driver.findElement(descrip).click();   // click on search in product descriptions
	}
	
}

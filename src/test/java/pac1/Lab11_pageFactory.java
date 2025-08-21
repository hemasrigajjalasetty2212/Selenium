package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lab11_pageFactory {
	WebDriver driver;

	//By desk = By.linkText("Desktops");
	@FindBy(linkText = "Desktops")
	WebElement desk;
	
	//By mac = By.linkText("Mac (1)");
	@FindBy(linkText = "Mac (1)")
	WebElement mac;
	
	//By addcart = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]");
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
	WebElement addcart;
	
	//By searchitem = By.name("search");
	@FindBy(name = "search")
	WebElement searchitem;
	
	//By buttonsearch = By.xpath("//*[@id=\"search\"]/span/button");
	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
	WebElement buttonsearch;
	
	//By searchitem2 = By.id("input-search");
	@FindBy(id = "input-search")
	WebElement searchitem2;
	
	//By descrip = By.name("description");
	@FindBy(name = "description")
	WebElement descrip;
	
	public void clickdesktop() {
		desk.click();
	}
	
	public void clickmac() {
		mac.click();
	}
	
	public void clickaddcart() {
		addcart.click();   //add to cart
	}
	
	
	public void entersearchitem(String srch) {
		searchitem.sendKeys(srch);
	}  	
		
	
	public void clicksearchbutton() {
		buttonsearch.click();   //search button
	}
	
	public void clearsearch() {
		searchitem2.clear();  //clear search 
	}
	
	public void enteranotheritem(String srch2) {
		searchitem2.sendKeys(srch2);
	}
	  
	public void clicksearchdescrip() {
		descrip.click();   // click on search in product descriptions
	}
	
}

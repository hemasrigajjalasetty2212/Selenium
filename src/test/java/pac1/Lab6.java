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
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Login")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys("asdfghhhsssshhhaahhh@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("asdfgh66");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();    //clicking on login
		
		Thread.sleep(3000);
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
		WebElement verify = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1"));
		String verifyText = verify.getText();
		System.out.println("Page is about: "+verifyText);
		if (verifyText.contains("Apple Cinema 30\"")) {
			System.out.println("Page verified.");
		}else {
			System.out.println("this is not page you are in.");
		}
		
		//add to wish list
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
		
		WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		String msgText = successMsg.getText();
		if(msgText.contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
			System.out.println("Success msg verified");
		}else {
			System.out.println("Success msg not verified");
		}
		
		driver.findElement(By.name("search")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();  //clicking on search button
		
		Thread.sleep(3000);
		driver.findElement(By.name("description")).click();
		driver.findElement(By.id("button-search")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("HTC Touch HD")).click();
		
		WebElement value = driver.findElement(By.name("quantity"));
		value.clear();
		value.sendKeys("3");
		
		driver.findElement(By.id("button-cart")).click();
		
		WebElement verify2 = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		String verify2Text = verify2.getText();
		if(verify2Text.contains("Success: You have added HTC Touch HD to your  shopping cart!")) {
			System.out.println("Cart added msg verified");
		}else {
			System.out.println("Cart not added msg not verified.");
		}
		
		Thread.sleep(1500);
		driver.findElement(By.id("cart-total")).click();
		
		WebElement verify3 = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[2]/a"));
		String verify3Text = verify3.getText();
		if(verify3Text.contains("HTC Touch HD")) {
			System.out.println("verified: mobile added to cart");
		}else {
			System.out.println("Not verified: mobile not added to cart");
		}
		
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();  // view cart
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();      // checkout
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();   // click on my account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();   // logout
		
		Thread.sleep(1500);
		WebElement verify4 = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String verify4Text = verify4.getText();
		if(verify4Text.contains("Account Logout")) {
			System.out.println("verified: account logout.");
		}else {
			System.out.println("Not verified: account not logout.");
		}
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();   // continue		
	}

}

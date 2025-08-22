package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab14 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		String title = driver.getTitle();   
		if (title.contains("Your Store")) {
			System.out.println("Page title verified.");
		}else {
			System.out.println("Page title not verified.");
		}
		
		//click on my account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
				
		//click on Register
		driver.findElement(By.linkText("Register")).click();
		
		//enter details
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).sendKeys("firstname");
		driver.findElement(By.id("input-lastname")).sendKeys("lastname");
		driver.findElement(By.id("input-email")).sendKeys("email123@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
		driver.findElement(By.id("input-password")).sendKeys("password");
		driver.findElement(By.id("input-confirm")).sendKeys("password");
				
		
		
		//Newsletters
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
			
		driver.findElement(By.name("agree")).click(); 
				
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue
		       
		//verifying success message
		WebElement successMsg =driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String SuccessText = successMsg.getText();
		if (SuccessText.contains("Your Account Has Been Created!")) {
			System.out.println("Account created successfully!");
		}
				
		driver.findElement(By.linkText("Continue")).click();
				
	}

}

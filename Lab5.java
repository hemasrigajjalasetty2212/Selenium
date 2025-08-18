package pac1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		String actualTitle = driver.getTitle();
		System.out.println("The title: "+actualTitle);
		
		if (actualTitle.equals("Your Store")) {
			System.out.println("The Page Title verification passed.");
		}else {
			System.out.println("The page Title verification not passed.");
		}
		
		//click on my account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		
		//click on Register
		driver.findElement(By.linkText("Register")).click();
		
		String actualTitle1 = driver.getTitle();
		System.out.println("The title: "+actualTitle1);
		
		Thread.sleep(3000);
		if (actualTitle1.equals("Register Account")) {
			System.out.println("The Page Title verification passed.");
		}else {
			System.out.println("The page Title verification not passed.");
		}
		
		//click on continue
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
        WebElement warningMsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        String warningMsgText = warningMsg.getText();
        if(warningMsgText.contains("Warning: You must agree to the Privacy Policy!")) {
        	System.out.println("Warning msg verified");
        }else {
        	System.out.println("warning msg not verified");
        }
        
        
	}

}




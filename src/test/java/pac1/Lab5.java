package pac1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
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
		
		if (actualTitle.equals("YourStore")) {
			System.out.println("The Page Title verification passed.");
		}else {
			System.out.println("The page Title verification not passed.");
		}
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("asdfgh");

		driver.findElement(By.id("input-lastname")).sendKeys("gfdsa");
		
		driver.findElement(By.id("input-email")).sendKeys("asdfgh6666@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("987654321");

		driver.findElement(By.id("input-password")).sendKeys("asdfgh66");

		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("asdfgh66");
		
		driver.findElement(By.name("agree")).click();
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




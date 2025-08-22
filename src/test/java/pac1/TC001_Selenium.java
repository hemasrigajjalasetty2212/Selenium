package pac1;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC001_Selenium {
 
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Properties prob=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Selenium_Maven\\login.properties");
		prob.load(fis);
		String url=prob.getProperty("url");
		String username=prob.getProperty("username");
		String password=prob.getProperty("password");

 
 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}
 
}

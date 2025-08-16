package pac1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TC004_findElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
	
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total count: "+alllinks.size());
		
		for (WebElement link : alllinks) {
		
			System.out.println("This Link is: "+link.getAttribute("href"));
			System.out.println("This Link is: "+link.getText());
			
			
		}

	}

}

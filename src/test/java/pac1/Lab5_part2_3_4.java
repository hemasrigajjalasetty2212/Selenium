package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_part2_3_4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		//click on my account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
				
		//click on Register
		driver.findElement(By.linkText("Register")).click();
				
		//first name
		WebElement firstname = driver.findElement(By.id("input-firstname"));
		firstname.sendKeys("asdfghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue

        Thread.sleep(3000);
        WebElement warningMsg = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div"));
        String warningMsgText = warningMsg.getText();

        if(warningMsgText.contains("First Name must be between 1 and 32 characters!")) {
        	System.out.println("First Name error message verified!");
        	
        }else {
        	System.out.println("first name error msg not verified");
        }
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Hemasri");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue
        
      //last name
        Thread.sleep(3000);
     	driver.findElement(By.id("input-lastname")).sendKeys("asdfghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();   //clicking on continue
              
        Thread.sleep(3000);
        WebElement warningmsg1 = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div"));
        String lastNameText = warningmsg1.getText();
        if (lastNameText.contains("Last Name must be between 1 and 32 characters!")) {
          	System.out.println("Last name error message verified.");
        }else {
          	System.out.println("Last name eror message not verified.");
        }
              
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Gajjalasetty");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue
        
              
        //email
        Thread.sleep(2000);
		driver.findElement(By.id("input-email")).sendKeys("asdfghhhsssshhhaahhh@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue
        

		//telephone
		Thread.sleep(3000);
		driver.findElement(By.id("input-telephone")).sendKeys("987654321");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue
        
		
		//part4
		// password
		driver.findElement(By.id("input-password")).sendKeys("asdfgh66");

		//confirm password
		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("asdfgh66");
		
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
		
		//Navigate to order history
		Thread.sleep(3000);
		driver.findElement(By.linkText("View your order history")).click();
		driver.findElement(By.linkText("Continue")).click();
		
		//part3
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[4]")).click();  //clicking on address book
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/a")).click();     // clicking on new address
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).sendKeys("Hemasri");
		driver.findElement(By.id("input-lastname")).sendKeys("Gajjalasetty");
		driver.findElement(By.id("input-address-1")).sendKeys("Palnadu");
		driver.findElement(By.id("input-city")).sendKeys("NRT");
		driver.findElement(By.id("input-postcode")).sendKeys("522601");
		WebElement country = driver.findElement(By.id("input-country"));
		Select sle= new Select(country);
		sle.selectByVisibleText("India");
		
		Thread.sleep(3000);
		WebElement state = driver.findElement(By.id("input-zone"));
		Select sle2= new Select(state);
		sle2.selectByVisibleText("Andhra Pradesh");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
		

	}

}

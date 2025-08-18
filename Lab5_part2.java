package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_part2 {

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
        WebElement warningmsg = driver.findElement(By.xpath("div.text-danger"));
        Thread.sleep(3000);
        if (warningmsg.equals("First Name must be between 1 and 32 characters!")) {
        	System.out.println("First name error message verified.");
        }else {
        	System.out.println("First name eror message not verified.");
        }
        
        firstname.clear();
        firstname.sendKeys("Hemasri");
        
      //last name
     	WebElement lastname = driver.findElement(By.id("input-lastname"));
     	lastname.sendKeys("asdfghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();   //clicking on continue
              
        WebElement warningmsg1 = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div"));
        if (warningmsg1.equals("Last Name must be between 1 and 32 characters!")) {
          	System.out.println("Last name error message verified.");
        }else {
          	System.out.println("Last name eror message not verified.");
        }
              
        lastname.clear();
        lastname.sendKeys("Gajjalasetty");
              
        //email
		driver.findElement(By.id("input-email")).sendKeys("asdfgh6666@gmail.com");

		//telephone
		WebElement telephone = driver.findElement(By.id("input-telephone"));
		telephone.sendKeys("98765432109876543210000316549870");
		driver.findElement(By.xpath("//*[@id=\\\"content\\\"]/form/div/div/input[2]")).click();  //clicking on continue
		
		WebElement warn3 = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div"));
		if (warn3.equals("Telephone must be between 3 and 32 characters!")) {
			System.out.println("Telephone error message is verified.");
		}else {
			System.out.println("Telephone error message is not verified.");
		}
		
		telephone.clear();
		telephone.sendKeys("987654321");
		
		//part4
		// password
		driver.findElement(By.id("input-password")).sendKeys("asdfgh66");

		//confirm password
		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("asdfgh66");
		
		//Newsletters
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		
		driver.findElement(By.name("agree")).click(); 
		
		driver.findElement(By.linkText("Continue")).click();
		/*
		//verifying success message
		WebElement successMsg =driver.findElement(By.xpath(""));
		if (successMsg.equals("Your Account Has Been Created!")) {
			System.out.println("Account created successfully!");
		}
		
		driver.findElement(By.linkText("Continue")).click();
		
		//Navigate to order history*/

	}

}

package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Lab14TestNG {
	WebDriver driver;
	String propath = System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f( String firstname, String lastname, String email, String telephone, String password, String con_password) throws InterruptedException {

	  
	//click on my account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();  //clicking account
				
		//click on Register
		driver.findElement(By.linkText("Register")).click();
		
		//enter details
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(con_password);
		
		
		
		//Newsletters
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
			
		driver.findElement(By.name("agree")).click(); 
				
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //clicking on continue
		       
		//verifying success message
		Thread.sleep(3000);
		WebElement successMsg =driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String SuccessText = successMsg.getText();
		if (SuccessText.contains("Your Account Has Been Created!")) {
			System.out.println("Account created successfully!");
		}
				
		driver.findElement(By.linkText("Continue")).click();
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://tutorialsninja.com/demo/index.php?");
		
	  String title = driver.getTitle();   
	  if (title.contains("Your Store")) {
	  	System.out.println("Page title verified.");
	  }else {
		System.out.println("Page title not verified.");
	  		}
		
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
	  
   String[][] data = new String[6][6];
	  
	  
	  File file2 = new File(propath+ "\\UserDetails.xlsx");
	  FileInputStream fs =new FileInputStream(file2);
	  XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
	  XSSFSheet worksheet1 = workbook1.getSheetAt(0);
	  int rowcount = worksheet1.getPhysicalNumberOfRows();
	  System.out.println("rows: "+rowcount);
	  
	  /*for (int i=0;i<rowcount;i++) {
		  data[i][0]=worksheet1.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=worksheet1.getRow(i).getCell(1).getStringCellValue();
		  data[i][2]=worksheet1.getRow(i).getCell(2).getStringCellValue();
		  data[i][3]=worksheet1.getRow(i).getCell(3);
		  data[i][4]=worksheet1.getRow(i).getCell(4).getStringCellValue();
		  data[i][5]=worksheet1.getRow(i).getCell(5).getStringCellValue();
		  
	  }*/
	  
	  DataFormatter formatter = new DataFormatter();
	  for(int i=0;i<rowcount;i++)
	  {
		  data[i][0] = formatter.formatCellValue(worksheet1.getRow(i).getCell(0)); // First Name
		  data[i][1] = formatter.formatCellValue(worksheet1.getRow(i).getCell(1)); // Last Name
		  data[i][2] = formatter.formatCellValue(worksheet1.getRow(i).getCell(2)); // Email
	        data[i][3] = formatter.formatCellValue(worksheet1.getRow(i).getCell(3)); // Phone
	        data[i][4] = formatter.formatCellValue(worksheet1.getRow(i).getCell(4)); // Password
	        data[i][5] = formatter.formatCellValue(worksheet1.getRow(i).getCell(5)); //cpassword
	  }
	  return data;
   /* return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };*/
  }

}

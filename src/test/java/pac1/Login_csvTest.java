package pac1;
 
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
 

public class Login_csvTest {
WebDriver driver;
String projectpath=System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
  String title=driver.getTitle();
  System.out.println("The Title is:"+title);
  Thread.sleep(3000);
  Login_pagefactory obj=PageFactory.initElements(driver, Login_pagefactory.class);
  obj.enterusername(username);
  obj.enterpassword(password);
  obj.clickonlogin();

}
  @BeforeMethod
  public void beforeMethod() {
System.out.println("Before method");
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @AfterMethod
  public void afterMethod() {
System.out.println("After method");
driver.quit();
  }
 
 
  @DataProvider
  public Object[][] dp() throws IOException, CsvException {
 
String[][] data1=new String[3][2];
/*  
String projectpath=System.getProperty("user.dir")  ;
File file1=new File(projectpath+"\\data.xlsx");
FileInputStream fs=new FileInputStream(file1);
XSSFWorkbook workbook=new XSSFWorkbook(fs);
XSSFSheet worksheet=workbook.getSheetAt(0);
int rowcount=worksheet.getPhysicalNumberOfRows();
System.out.println("rows:"+rowcount);
*/
      String csvFile = projectpath+"\\Data2.csv";  // Path to your CSV file
      CSVReader csvReader= new CSVReader(new FileReader(csvFile));
      List<String[]> data = csvReader.readAll(); // Read all rows
 
      // Iterate over CSV data (skipping header)
      for (int i = 0; i < data.size(); i++) {  // Start from 1 to skip header
          data1[i][0] = data.get(i)[0];  // Get username from the CSV
          data1[i][1] = data.get(i)[1];  // Get password from the CSV
 
      }
 
return data1;
 
/* return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "pooja", "admin123" },
    */
    }
 
 
}
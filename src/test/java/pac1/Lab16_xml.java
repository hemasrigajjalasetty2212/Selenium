package pac1;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Lab16_xml {
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
  public Object[][] dp() throws IOException, CsvException, ParserConfigurationException, SAXException {
	  
   String[][] data1 = new String[2][6];
	  
	  
	  /*String csvFile = propath+"\\UserDetails2.csv";  // Path to your CSV file
      CSVReader csvReader= new CSVReader(new FileReader(csvFile));
      List<String[]> data = csvReader.readAll(); // Read all rows
 
      // Iterate over CSV data (skipping header)
      for (int i = 0; i < data.size(); i++) {  // Start from 1 to skip header
          data1[i][0] = data.get(i)[0];  // Get first name
          data1[i][1] = data.get(i)[1]; 	// get last name
          data1[i][2] = data.get(i)[2];  // Get email
          data1[i][3] = data.get(i)[3]; 	// get telephone
          data1[i][4] = data.get(i)[4];  // Get password
          data1[i][5] = data.get(i)[5]; 	//get confim password
 
      }*/
	
	  File file = new File(propath+"\\UserDetails3.xml");

	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

	  Document doc = dBuilder.parse(file);
	  doc.getDocumentElement().normalize();

	  System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

	  NodeList nList = doc.getElementsByTagName("user");

	  for (int i = 0; i < nList.getLength(); i++) {
	      Node node = nList.item(i);

	      if (node.getNodeType() == Node.ELEMENT_NODE) {
	          Element element = (Element) node;

	         data1[i][0] = element.getElementsByTagName("firstname").item(0).getTextContent();
	         data1[i][1] = element.getElementsByTagName("lastname").item(0).getTextContent();
	         data1[i][2] = element.getElementsByTagName("email").item(0).getTextContent();
	         data1[i][3] = element.getElementsByTagName("telephone").item(0).getTextContent();
	         data1[i][4] = element.getElementsByTagName("password").item(0).getTextContent();
	         data1[i][5] = element.getElementsByTagName("con_password").item(0).getTextContent();
	        
	        
	          System.out.println("firstname: " +  data1[i][0]);
	          System.out.println("lastname: " +  data1[i][1]);
	          
	      }
	  }
	  
	  return data1;
  }

}

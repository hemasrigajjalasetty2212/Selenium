package pac1;
 
import java.io.File;
import java.io.IOException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class Lab13_repo_xml {
	WebDriver driver;
	By desk;
	By mac;
	By searchitem;
	By addcart;
	By searchitem2;
	By buttonsearch;
	By descrip;
	String projectpath=System.getProperty("user.dir");
	public Lab13_repo_xml(WebDriver driver2) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated constructor stub
			this.driver=driver2;

	File file = new File(projectpath+"\\ObjectRepository.xml");
 
	 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 
	 Document d1= dBuilder.parse(file);
	// d1.getDocumentElement().normalize();
	
	// System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
 
	 NodeList nList = d1.getElementsByTagName("user");
 
	 for (int i = 0; i < nList.getLength(); i++) {
		
	     Node node = nList.item(i);
 
	     if (node.getNodeType() == Node.ELEMENT_NODE) {
	         Element element = (Element) node;
 
	     String    desk1  = element.getElementsByTagName("desktopstag").item(0).getTextContent();
	     String    mac1= element.getElementsByTagName("mactag").item(0).getTextContent();
	     String   addcart1= element.getElementsByTagName("addcarttag").item(0).getTextContent();
	     String    searchitem1  = element.getElementsByTagName("searchitemtag").item(0).getTextContent();
	     String    button= element.getElementsByTagName("buttontag").item(0).getTextContent();
	     String   searchitem21= element.getElementsByTagName("searchitem2tag").item(0).getTextContent();
	     String   descrip1= element.getElementsByTagName("descriptag").item(0).getTextContent();
	    	
	     desk = By.linkText(desk1);
	 	mac = By.linkText(mac1);
	 	addcart = By.xpath(addcart1);
	 	searchitem = By.name(searchitem1);
	 	buttonsearch = By.xpath(button);
	 	searchitem2 = By.id(searchitem21);
	 	descrip = By.name(descrip1);
	 	
	 }
	     }
	}
	
	public void clickdesktop() {
		driver.findElement(desk).click();
	}
	
	public void clickmac() {
		driver.findElement(mac).click();
	}
	
	public void clickaddcart() {
		driver.findElement(addcart).click();   //add to cart
	}
	
	
	public void entersearchitem(String srch) {
		driver.findElement(searchitem).sendKeys(srch);
	}  	
		
	
	public void clicksearchbutton() {
		driver.findElement(buttonsearch).click();   //search button
	}
	
	public void clearsearch() {
		driver.findElement(searchitem2).clear();  //clear search 
	}
	
	public void enteranotheritem(String srch2) {
		driver.findElement(searchitem2).sendKeys(srch2);
	}
	  
	public void clicksearchdescrip() {
		driver.findElement(descrip).click();   // click on search in product descriptions
	}
	
}
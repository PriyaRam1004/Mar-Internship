package createlead;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Producttaracking {

	public static void main(String[] args) throws InterruptedException {
ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver=new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://login.salesforce.com");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.xpath("//input[@id='username']")).sendKeys("priyadharshini10041993@gmail.com");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Priya@1004");
driver.findElement(By.xpath("//input[@id='Login']")).click();
driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
driver.findElement(By.xpath("//button[@class='slds-button']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//p[text()='Sales']")).click();
WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
driver.executeScript("arguments[0].click()", opportunity);
driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Testleaf");
driver.findElement(By.xpath("//a[@title='TestLeaf-']")).click();
//WebElement stage = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']"));
//driver.executeScript("arguments[0].click()", stage);
WebElement drop = driver.findElement(By.xpath("//span[text()='Show actions for Products']"));
driver.executeScript("arguments[0].click()", drop);
WebElement add = driver.findElement(By.xpath("//div[@title='Add Products']"));
driver.executeScript("arguments[0].click();", add);
Thread.sleep(1000);
 driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA",Keys.ENTER);
 Thread.sleep(1000);
driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-search inputLookupIcon slds-button_icon-xx-small slds-icon_container']")).click();
WebElement search = driver.findElement(By.xpath("(//table)[2]/thead//th[2]//div[contains(@class,'checkbox')]"));
driver.executeScript("arguments[0].click()", search);
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA"+Keys.ENTER);
Thread.sleep(5000);
driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]")).click();
Thread.sleep(5000);
List<WebElement> colvalue = driver.findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"));
 int productsize = colvalue.size();
   System.out.println("col size is :"+productsize);
for (int i = 0; i < colvalue.size(); i++) {
Thread.sleep(3000);
   String proname = colvalue.get(i).getText();
    System.out.println("the product names for the search results SLA"+proname);
}
driver.findElement(By.xpath("//span[text()='Next']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td")).click();
driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys("2"+Keys.ENTER);
Thread.sleep(1000);
//driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys(Keys.ENTER);
driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td")).click();
driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td//input")).sendKeys("10"+Keys.ENTER);
Thread.sleep(3000);
driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td//input")).sendKeys("1"+Keys.ENTER);

driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td")).click();
driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td//input")).sendKeys("5"+Keys.ENTER);
 Thread.sleep(3000);
driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();	
WebElement viewall = driver.findElement(By.xpath("(//span[@class='view-all-label'])[1]"));
driver.executeScript("arguments[0].click()", viewall);
Thread.sleep(5000);
WebElement table1 = driver.findElement(By.xpath("(//table[@data-aura-class='uiVirtualDataTable'])[2]/tbody"));
List<WebElement> drop1 = driver.findElements(By.xpath("(//table)[2]/tbody/tr/td//div[@data-aura-class='forceVirtualAction']"));
int columnsize=drop1.size();
System.out.println("col size is :"+columnsize);
for(int i=0;i<drop1.size();i++) {
Thread.sleep(8000);
drop1.get(i).click();
Thread.sleep(1000);
WebElement edit = driver.findElement(By.xpath("(//a[@title='Edit'])["+(i+1)+"]"));
edit.click();
//driver.executeScript("arguments[0].click();", edit);

Thread.sleep(3000);
String code = driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.ProductCode']")).getText();
String proname = driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.Product2Id']")).getText();
System.out.println("The product code is :" + code + "   productname is  :"+  proname);
WebElement close = driver.findElement(By.xpath("//span[text()='Close this window']"));
driver.executeScript("arguments[0].click();", close);
Thread.sleep(1000);
}

//List<WebElement> row1 = table1.findElements(By.tagName("tr"));
//System.out.println("Row count: "+row1.size());
//List<WebElement> column1 = table1.findElements(By.tagName("th"));
//System.out.println(column1);
//System.out.println("Column count: "+column1.size());
//System.out.println("The product name:");
//for(int i=1;i<row1.size();i++) {
//	driver.findElement(By.xpath("(//table[@data-aura-class='uiVirtualDataTable'])[2]/tbody//tr["+i+"]/td[6]")).click();
//	WebElement click = driver.findElement(By.xpath("//a[@title='Edit']"));
//	driver.executeScript("arguments[0].click()",click);
//	String productCode = driver.findElement(By.xpath("//span[text()='Product Code']/following::span")).getText();
//	String productName = driver.findElement(By.xpath("(//span[@class='uiOutputText forceOutputLookup'])[2]")).getText();
//	System.out.println("The product code is: "+productCode+" and the Product name is: "+productName);
//	driver.findElement(By.xpath("//span[text()='Close this window']")).click();
}
}


//Login: Log in to the Salesforce account at https://login.salesforce.com.
//
//Navigate: Click on the toggle menu button located in the left corner.
//
//Access Sales App: Select 'View All' and click on 'Sales' from the App Launcher.
//
//Open Opportunities: Navigate to the 'Opportunities' tab.
//
//Search and Open Opportunities: Search for an existing opportunity and open it.
//
//Check Qualification Stage: Ensure that the qualification stage is marked as completed. If not, click 'Mark Stage as Complete'.
//
//Select Price Book: Click on the widget for the product under 'Related', choose 'Choose Price Book', select 'Standard', and click 'Save'.
//
//Add Products: Click on the widget for the product under 'Related', click 'Add Products'.
//
//Search and Display Products: Search for "SLA" in the products search field, display and print all the product names for the search results.
//
//Select Products: Click on 'Select All' checkbox, click 'Next', and enter the quantities for each product type (Platinum - 1, Gold - 2, Silver - 5, Bronze - 10).
//
//Save Products: Click 'Save'.
//
//View All Products: Click on 'View All'.
//
//Retrieve Product Details: For each resulting product, click the widget, click 'Edit', retrieve the product code along with the product name, and close the window.


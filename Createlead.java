package createlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Createlead {

	public static void main(String[] args) throws InterruptedException {
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://login.salesforce.com");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.xpath("//input[@id='username']")).sendKeys("priyadharshini10041993@gmail.com");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Priya@1004");
driver.findElement(By.xpath("//input[@id='Login']")).click();
driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@class='slds-button']")).click();
driver.findElement(By.xpath("//p[text()='Sales']")).click();
WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
driver.executeScript("arguments[0].click()", lead);
driver.findElement(By.xpath("//button[text()='New']")).click();
WebElement drop = driver.findElement(By.xpath("(//button[@role='combobox'])[3]"));
driver.executeScript("arguments[0].click()", drop);
driver.findElement(By.xpath("//span[text()='Mr.']")).click();
driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar");
driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("TestLeaf");
driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
System.out.println(text);
	}

}




//Acceptance Criteria:
//
//Login: Log in to the Salesforce account at https://login.salesforce.com.
//
//Navigate: Click on the toggle menu button located in the left corner.
//
//Access Sales App: Select 'View All' and click on 'Sales' from the App Launcher.
//
//Open Leads: Navigate to the 'Leads' tab.
//
//Create New Lead: Click on the 'New' button.
//
//Provide Details: Set the Salutation to 'Mr'.
//
//Enter Information: Fill in the Last Name as 'Kumar' and Company Name as 'TestLeaf'.
//
//Save Changes: Click 'Save'.
//
//Verification: Confirm that the lead's name is correctly saved and displayed.
//
//This story encompasses the necessary steps to log in, navigate through Salesforce, create a new lead, and verify the successful creation of the lead with specific details.
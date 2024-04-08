package createlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Editlead {

	public static void main(String[] args) throws InterruptedException {
 ChromeOptions options = new ChromeOptions();
 options.addArguments("--disable-notifications");
  ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

driver.get("https://login.salesforce.com");
driver.findElement(By.xpath("//input[@id='username']")).sendKeys("priyadharshini10041993@gmail.com");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Priya@1004");
driver.findElement(By.xpath("//input[@id='Login']")).click();
driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
driver.findElement(By.xpath("//button[@class='slds-button']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//p[text()='Sales']")).click();
WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
driver.executeScript("arguments[0].click()", lead);
Thread.sleep(1000);
driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Kumar");
WebElement search = driver.findElement(By.xpath("(//span[text()='Show Actions'])[1]"));
driver.executeScript("arguments[0].click()", search);
WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']"));
driver.executeScript("arguments[0].click()", edit);

////driver.executeScript("document.getElementById('search').value='Kumar';");
////driver.executeScript("document.getElementById('username').value='demosalesmanager';");
//
//Thread.sleep(2000);
//driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("//div[@title='Edit']")).click();
driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ganesh");
driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();

System.out.println(text);
	}

}
////Login: Log in to the Salesforce account at Login: Log in to the Salesforce account at https://login.salesforce.com.
//
//Navigate: Click on the toggle menu button in the left corner.
//
//Access Sales App: Select 'View All' and click on 'Sales' from the App Launcher.
//
//Open Leads: Navigate to the 'Leads' tab.
//
//Search for Lead: Perform a search for the lead with the last name 'Kumar'.
//
//Edit Lead: Click on the dropdown icon next to the search result and select 'Edit'.
//
//Update Information: Change the First Name to 'Ganesh'.
//
//Modify Lead Status: Set the Lead Status to 'Working-Contacted'.
//
//Save Changes: Click 'Save'.
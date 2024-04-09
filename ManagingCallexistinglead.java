package createlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ManagingCallexistinglead {

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
		driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//a[@title='Kumar'])[1]")).click();
		driver.findElement(By.xpath("(//lightning-button-menu[@class='slds-dropdown-trigger slds-dropdown-trigger_click'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Add Call to To Do List']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Call");
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		driver.findElement(By.xpath("(//span[text()='Log a Call'])[2]")).click();
		driver.findElement(By.xpath("//textarea[@role='textbox']"))
		.sendKeys("Can we discuss working together?");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		Thread.sleep(1000);
		WebElement drop = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border-filled fix-slds-button_icon-border-filled slds-button_last']/following::span[text()='Show more actions'])[1]"));
		driver.executeScript("arguments[0].click()", drop);
		WebElement changestatus = driver.findElement(By.xpath("(//div[text()='Change Status']/following::div[@role='button'])[4]"));
		driver.executeScript("arguments[0].click()", changestatus);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Completed']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	}

}
//Login: Log in to the Salesforce account at https://login.salesforce.com.
//
//Navigate: Click on the toggle menu button located in the left corner.
//
//Access Sales App: Select 'View All' and click on 'Sales' from the App Launcher.
//
//Open Leads: Navigate to the 'Leads' tab.
//
//Search and Open Lead: Search for an existing lead and open it.
//
//Log a Call To-Do: Click on the 'Log a Call' widget, choose subject as 'call', set due date as 'Tomorrow date', and click 'Save'.
//
//View Logged Call: Click on 'Log a Call' under the 'Activity' tab, enter comments ('Can we discuss working together?'), and click 'Save'.
//
//Check Call Status: Click on the 'Call' widget under 'Upcoming & Overdue', click 'Change Status', 
//change status to 'Completed', and save.
//


package createlead;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Updateopportunities {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		  ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		String verification = driver.findElement(By.xpath("(//a[text()='Kumar'])[6]")).getText();
		System.out.println("The Lead Verified By:" +verification);
		if(verification.contains("Kumar")) {
			System.out.println("The Lead Name Verified");
		}else {
			System.out.println("The Lead Name Is Not Verified");
		}
		driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
		driver.findElement(By.xpath("(//a[@role='menuitem'])[1]")).click();
		driver.findElement(By.xpath("//input[@aria-haspopup='listbox']")).sendKeys("Email");
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//span[@part='formatted-rich-text'])[3]")).click();
		driver.findElement(By.xpath("(//a[text()='Not Started'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='In Progress']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		driver.findElement(By.xpath("//span[@value='SendEmail']")).click();
		driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).sendKeys("Oppotunity@testleaf.com");
		driver.findElement(By.xpath("//input[@class='standardField input']")).sendKeys("Opportunity create");
//		driver.switchTo().frame(0);
//		Thread.sleep(1000);
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")).sendKeys("Opportunity Was Created");
//		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		WebElement drop = driver.findElement(By.xpath("(//span[@class='slds-icon_container slds-icon-utility-down'])[3]"));
		driver.executeScript("arguments[0].click()", drop);
		driver.findElement(By.xpath("//a[@title='Change Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@ class='select']")).click();
		driver.findElement(By.xpath("//a[@title='In Progress']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		WebElement clone = driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_icon-border-filled')]//lightning-primitive-icon)[1]"));
		driver.executeScript("arguments[0].click()", clone);
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		driver.executeScript("arguments[0].click()", edit);
		driver.findElement(By.xpath("//button[@aria-label='Stage - Current Selection: Prospecting']")).click();
		WebElement qualification = driver.findElement(By.xpath("//span[@title='Qualification']"));
		driver.executeScript("arguments[0].click()", qualification);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./Snapshot/img2.png");
		FileUtils.copyFile(scr, des);
	}

}
//Login: Log in to the Salesforce account at https://login.salesforce.com.
//
//			Navigate: Click on the toggle menu button located in the left corner.
//
//			Access Sales App: Select 'View All' and click on 'Sales' from the App Launcher.
//
//			Open Opportunities: Navigate to the 'Opportunities' tab.
//
//			Search and Open Opportunity: Search for the opportunity associated with the converted lead by company name.
//
//			Verify Details: Confirm the account name (company name from the lead) at the top left of the webpage and verify the contact (your name) at the right bottom.
//
//			Create New Task: Click on the new task icon under 'Activity', choose subject as 'email', set due date as today's date, and verify correct assignment of contact and related opportunity.
//
//			Update Task Status: Change the task status to 'In Progress' and click 'Save'.
//
//			Send Email: Click on the email icon under 'Activity', compose an email to the opportunity, and click 'Send'.
//
//			Check Email Status: Click on the widget icon for the email under 'Upcoming & Overdue', change status to 'Completed', and save.
//
//			Edit Opportunity Stage: Click on the widget icon for the opportunity at the top right, click 'Edit', change the stage to 'Qualification', and click 'Save'.
//
//			Take Snapshot: Capture a screenshot of the webpage.
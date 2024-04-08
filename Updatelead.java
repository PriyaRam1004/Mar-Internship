package createlead;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Updatelead {

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
		driver.findElement(By.xpath("//div[@title='New']")).click();
        driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//span[@title='Mr.']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("QA");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verificationMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage sld')]")).getText();
		String leadName = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[6]")).getText();

		if(leadName.contains("Kumar")) {
			if(verificationMessage.contains(" was created.")){
				System.out.println("Lead name is correctly saved and displayed");
			}			
		}
		else{
			System.out.println("Lead name is not correctly saved and displayed");
		}
		String leadname = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[6]"))
				.getText();
				System.out.println(leadname);
				String title = driver.findElement(By.xpath("//lightning-formatted-text[text()='QA']")).getText();
				System.out.println("The Lead Title Is: "+title);
				String company = driver.findElement(By.xpath("(//p[contains(@class,'fieldComponent slds-text-body--regular')]//lightning-formatted-text)[2]"))
				.getText();
				System.out.println("The Company Name Is: "+company);
				driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Add Email to To Do List')]")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Email");
				driver.findElement(By.xpath("//label[text()='Due Date']/following::input")).click();
				driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
//			List<WebElement> date= driver.findElements(By.xpath("//span[@class='slds-day']"));
//			for (WebElement q : date) {
//				System.out.println(q.getText());
//			}
			driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
			driver.findElement(By.xpath("//span[@value='SendEmail']")).click();
			driver.findElement(By.xpath("//ul[@aria-label='To']//input")).sendKeys("Kumar@Testleaf.com");			
			driver.findElement(By.xpath("//input[@class='standardField input']")).sendKeys("Compose The Email");
			driver.findElement(By.xpath("(//span[@class=' label bBody'])[3]")).click();
			WebElement drop = driver.findElement(By.xpath("//a[@title='Email']/following::span[text()='Show more actions']"));
			driver.executeScript("arguments[0].click()", drop);
			Thread.sleep(1000);
			WebElement change = driver.findElement(By.xpath("(//a[@title='Change Status'])/following::div[text()='Change Status']"));
			driver.executeScript("arguments[0].click()", change);
			driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
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
//Create New Lead: Click on the 'New' button.
//
//Set Details: Select Salutation ('Mr' or 'Ms'), input Last Name as 'Any Name', Company Name as 'Any Company name', and Title as 'QA'.
//
//Save Lead: Click 'Save'.
//
//Verify Lead Name: Confirm that the lead name is displayed as 'Salutation + Last Name' (e.g., 'Mr. Any Name').
//
//Verify Details: Confirm that the Title ('QA') and Company details are accurate.
//
//Add Email to To-Do List: Click on the email widget, choose subject as 'Email', set due date as 'Tomorrow date', and click 'Save'.
//
//Send Email: Click on the 'Email' under the 'Activity' tab, enter recipient email ('LastName@companyName.com'), set subject, compose the email, and click 'Send'.
//
//Check Email Status: Click on the 'Email' widget under 'Upcoming & Overdue', click 'Change Status', change status to 'Completed', and save.
//
//This story covers the steps to log in, create a new lead with specific details, verify lead information, add an email to the to-do list, send an email, and update the email status to 'Completed'.
 

//a[@title='Show 8 more actions']





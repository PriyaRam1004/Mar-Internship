package createlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Attachementopportunity {

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
		driver.findElement(By.xpath("//span[@value='NewTask']")).click();
		driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).sendKeys("Other",Keys.ENTER);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
//		WebElement file = driver.findElement(By.xpath("//span[@class='slds-file-selector__button slds-button slds-button_neutral']"));
//		driver.executeScript("arguments[0].click()", file);
		Thread.sleep(1000);
		WebElement browse = driver.findElement(By.xpath("//input[@type='file']"));
		browse.sendKeys("D:\\Testleaf\\Internship\\pom.xml");
		String verify = driver.findElement(By.xpath("//span[@title='pom']")).getText();
		if(verify.contains("pom")) {
			System.out.println("The Uploaded The File Is Correct");
		}else {
			System.out.println("The Uploaded The File Is Not Correct");
		}	Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[text()='Details']")).click();
		//driver.executeScript("arguments[0].click()", detail);
		driver.findElement(By.xpath("//button[@title='Edit Stage']")).click();
		Thread.sleep(1000);
		WebElement drop = driver.findElement(By.xpath("(//button[@role='combobox'])[3]"));
		driver.executeScript("arguments[0].click()", drop);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Attachments uploaded successfully.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement stage = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']"));
		driver.executeScript("arguments[0].click()",stage);

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
//Search and Open Opportunity: Search for an existing opportunity and open it.
//
//Create New Task: Click on the new task icon.
//
//Set Task Details: Choose subject as 'Other', enter due date as either today or tomorrow, and click 'Save'.
//
//Upload Sample File: Under 'Notes and Attachments', upload a sample file.
//
//Verify File Name: Confirm that the uploaded file name is displayed under 'Notes and Attachments'.
//
//Navigate to Details: Click on the 'Details' tab.
//
//Update Opportunity Stage: Click on the stage icon for the stage dropdown, change the stage to 'Needs Analysis', and enter the description as "Attachments uploaded successfully."
//
//Save Changes: Click 'Save'.
//
//Check Stage Completion: Confirm that 'Needs Analysis' stage is marked as completed. If not, click 'Mark Stage as Complete'.
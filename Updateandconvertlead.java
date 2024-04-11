package createlead;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Updateandconvertlead {

	public static void main(String[] args) throws InterruptedException, IOException {
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
		driver.executeScript("arguments[0].click()", lead);
		driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//a[@title='Kumar'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement icon = driver.findElement(By.xpath("(//span[@class='inline-edit-trigger-icon slds-button__icon slds-button__icon_hint'])[11]"));
		driver.executeScript("arguments[0].click()", icon);
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Status')]")).click();
		
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		WebElement markstatus = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']"));
		driver.executeScript("arguments[0].click()", markstatus);
		
		driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border-filled fix-slds-button_icon-border-filled slds-button_last'])[1]"))
		.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Convert']")).click();
		WebElement convert = driver.findElement(By.xpath("//button[text()='Convert']"));
		driver.executeScript("arguments[0].click()", convert);
		Thread.sleep(1000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./Snapshot/img1.png");
		FileUtils.copyFile(src, des);
		//driver.close();
		
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
//Edit Lead Status: Click on the 'Details' tab, locate the lead status, click the edit icon, and change the lead status to 'Working - Contacted'.
//
//Save Changes: Click 'Save'.
//
//Check Status Completion: If the lead status 'Working - Contacted' is not marked as completed, click on 'Mark Status as Complete'.
//
//Convert Lead: Click on the widget near 'Submit for Approval', then click 'Convert'.
//
//Snapshot: Take a screenshot of the pop-up window.
//
//Close Pop-up: Close the pop-up window.
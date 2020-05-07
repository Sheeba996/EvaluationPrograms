package EvaluationPrograms;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAzure {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://azure.microsoft.com/en-in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Pricing']")));
		driver.findElement(By.xpath("//a[text()='Pricing']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[contains(text(),'Pricing calculator')]/parent::li")));
		driver.findElement(By.xpath("//a[contains(text(),'Pricing calculator')]/parent::li")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Compute']"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Compute']")));
		driver.findElement(By.xpath("//button[text()='Compute']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[text()='Container Instances'])[2]/parent::span")));
		driver.findElement(By.xpath("(//span[text()='Container Instances'])[2]/parent::span")).click();

		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[text()='Container Instances added.']//a[text()='View']"))));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//div[text()='Container Instances added.']//a[text()='View']"))));
		driver.findElement((By.xpath("//div[text()='Container Instances added.']//a[text()='View']"))).click();

		/*
		 * Actions action=new Actions(driver);
		 * action.moveToElement(driver.findElement(By.
		 * xpath("//div[text()='Container Instances added.']//a[text()='View']"))).click
		 * ().build().perform();
		 */

		WebElement RegionDrpdwnEle = driver.findElement(By.xpath("//select[@name='region']"));
		wait.until(ExpectedConditions.elementToBeClickable(RegionDrpdwnEle));
		Select Regdrpdwn = new Select(RegionDrpdwnEle);
		Regdrpdwn.selectByValue("south-india");

		driver.findElement(By.xpath("//input[@name='seconds']")).clear();
		driver.findElement(By.xpath("//input[@name='seconds']")).sendKeys("180000");

		WebElement MemoryDrpDwnEle = driver.findElement(By.xpath("//select[@name='memory']"));
		Select Memorydrpdwn = new Select(MemoryDrpDwnEle);
		Memorydrpdwn.selectByValue("4");

		driver.findElement(By.xpath("//button[@name='devTestSelected']")).click();

		WebElement CurrencyEle = driver.findElement(By.xpath("//select[@class='select currency-dropdown']"));
		Select CurrentDrpdwn = new Select(CurrencyEle);

		CurrentDrpdwn.selectByValue("INR");

		String MonthlyCost = driver
				.findElement(By.xpath(
						"//h3[text()='Estimated monthly cost']/parent::div/following-sibling::div//div[2]//span//span"))
				.getText();
		String MonthlyCostVal = MonthlyCost.replaceAll("\\D", "");

		System.out.println("The Monthly Cost is" + " " + MonthlyCostVal + " /-");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='calculator-button button-transparent export-button']")));
		driver.findElement(By.xpath("//button[@class='calculator-button button-transparent export-button']")).click();

		/*
		 * HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); //
		 * chromePrefs.put("profile.default_content_settings.popups", 0);
		 * chromePrefs.put("plugins.always_open_pdf_externally", true);
		 * chromePrefs.put("download.default_directory", "C:\\Users\\ssr07\\Downloads");
		 * // chromePrefs.put("safebrowsing.enabled", "false"); ChromeOptions options =
		 * new ChromeOptions(); options.setExperimentalOption("prefs", chromePrefs);
		 */

		/*
		 * File dir = new File("C:\\Users\\ssr07\\Downloads"); File[] dirContents =
		 * dir.listFiles();
		 * 
		 * for (int i = 0; i < dirContents.length; i++) { if
		 * (dirContents[i].getName().equals("ExportedEstimate(2).xlxs")) { // File has
		 * been found, it can now be deleted: dirContents[i].delete();
		 * System.out.println("The File got downloaded"); }
		 * 
		 * else System.out.println("The file wasnt downlaoded"); }
		 */

		/*
		 * File directory = new File("C:\\Users\\ssr07\\Downloads"); boolean
		 * downloadinFilePresence = false; File[] filesList =null; LOOP: while(true) {
		 * filesList = directory.listFiles(); for (File file : filesList) {
		 * downloadinFilePresence = file.getName().contains("ExportedEstimate"); }
		 * if(downloadinFilePresence) { for(;downloadinFilePresence;) {
		 * System.out.println("The file is downloaded"); Thread.sleep(5000);
		 * 
		 * continue LOOP;
		 * 
		 * } }else { break; } }
		 */

		/*
		 * File MyExcel = new
		 * File("C:\\Users\\ssr07\\Downloads\\ExportedEstimate .xlsx"); if
		 * (MyExcel.exists()) {
		 * 
		 * System.out.println("The file is  downlaoded"); } else
		 * System.out.println("The file is not downlaoded");
		 */
		
		
		
		/*
		 * File dir = new File("C:\\Users\\ssr07\\Downloads"); File[] dirContents =
		 * dir.listFiles();
		 * 
		 * for (int i = 0; i < 3; i++) { if
		 * (dirContents[i].getName().equalsIgnoreCase("ExportedEstimate")) {
		 * System.out.println("The file is downloaded"); break; }else {
		 * Thread.sleep(5000); } }
		 */
		
		TestAzure obj=new TestAzure();
		obj.isFileDownloaded("ExportedEstimate");

		WebElement ExampleScenariosEle = driver.findElement(By.xpath("//li[@id='solution-architectures-picker']//a"));

		wait.until(ExpectedConditions.visibilityOf(ExampleScenariosEle));
		wait.until(ExpectedConditions.elementToBeClickable(ExampleScenariosEle));
		Thread.sleep(7000);
		js.executeScript("arguments[0].click()", ExampleScenariosEle);
		// ExampleScenariosEle.click();

		WebElement CICDEle = driver
				.findElement(By.xpath("//span[text()='CI/CD for Containers']/parent::span/parent::button"));
		wait.until(ExpectedConditions.elementToBeClickable(CICDEle));
		js.executeScript("arguments[0].click()", CICDEle);

		WebElement AddToEstimateEle = driver.findElement(By.xpath("//button[text()='Add to estimate']"));
		wait.until(ExpectedConditions.elementToBeClickable(AddToEstimateEle));
		js.executeScript("arguments[0].click()", AddToEstimateEle);
		
		WebElement SuccessMesage = driver.findElement(By.xpath("//span[text()='Estimate added!']/parent::div"));

		WebDriverWait wait2=new WebDriverWait(driver,100); 
		wait.until(ExpectedConditions.visibilityOf(SuccessMesage));
		WebElement CurrencydwpdwnEle = driver.findElement(By.xpath("//select[@class='select currency-dropdown']"));
		wait.until(ExpectedConditions.elementToBeClickable(CurrencydwpdwnEle));
		Select CurrentDrpdwn2 = new Select(CurrencydwpdwnEle);
        CurrentDrpdwn2.selectByValue("INR");

        
        
		WebElement EstimateEle1 = driver.findElement(By.xpath("//button[@name='devTestSelected']"));
		wait.until(ExpectedConditions.elementToBeClickable(EstimateEle1));
		js.executeScript("arguments[0].click()", EstimateEle1);

		
		/*
		 * Actions action=new Actions(driver);
		 * action.moveToElement(ExportEle).click().build().perform();
		 */
		
		
		
				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Export']")));
		WebElement ExportEle = driver.findElement(By.xpath("//button[text()='Export']"));
		js.executeScript("arguments[0].click()", ExportEle);

		
		
		/*
		 * if(wait.until(ExpectedConditions.alertIsPresent()) != null)
		 * 
		 * driver.switchTo().alert().accept();
		 * 
		 * else System.out.println("The Alert is not present")
		 */
		 
		
		 obj.isFileDownloaded("ExportedEstimate (1)");
		 


	}
	
	public static Boolean isFileDownloaded(String fileName) {
        boolean flag = false;
        //paste your directory path below
        //eg: C:\\Users\\username\\Downloads
        String dirPath = "C:\\\\Users\\\\ssr07\\\\Downloads"; 
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println(fileName + " is present");
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }

}

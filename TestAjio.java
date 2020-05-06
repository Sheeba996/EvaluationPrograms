package EvaluationPrograms;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAjio {

	public static void main(String[] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		try
		{
		if(driver.findElement(By.xpath("//div[@class='ic-close-quickview']")).isEnabled())
			
			driver.findElement(By.xpath("//div[@class='ic-close-quickview']")).click();
		System.out.println("The pop up is not enabled");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		WebElement SearchBar = driver.findElement(By.xpath("//div[@class='searchbar-view']//div//input"));
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='searchbar-view']//div//input")));
		SearchBar.sendKeys("bags");
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='searchbar-view']//div//div//div//ul//li[3]//a"))).click().build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='five-grid']")));
		driver.findElement(By.xpath("//div[@class='five-grid']")).click();
		
		
		WebElement Ele = driver.findElement(By.xpath("//div[@class='sort ']//div//select"));
		Select drpdownEle=new Select(Ele);
		drpdownEle.selectByVisibleText("What's New");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='facet-head '])[1]//span[text()='price']")));
		driver.findElement(By.xpath("(//div[@class='facet-head '])[1]//span[text()='price']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='minPrice']")));
		driver.findElement(By.xpath("//input[@name='minPrice']")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@name='maxPrice']")).sendKeys("5000");
		
		driver.findElement(By.xpath("//div[@class='input-price-filter']//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='brands']"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='brands']"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='brands']/parent::div")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='MORE']"))));
		driver.findElement(By.xpath("//div[text()='MORE']")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-Puma']")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='modal-Puma']/parent::label")));
		driver.findElement(By.xpath("//input[@id='modal-Puma']/parent::label")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply']")));
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='Puma Red Shoulder Ferrari LS Shoulder Bag']"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Puma Red Shoulder Ferrari LS Shoulder Bag']")));
		driver.findElement(By.xpath("//img[@alt='Puma Red Shoulder Ferrari LS Shoulder Bag']")).click();
		
		String parentWin = driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();
		for (String string : AllWindows) 
		{
			if(!string.contains(parentWin))
			{
				driver.switchTo().window(string);
			}
			else
				System.out.println("there is no window except parent window");
			
		}
		
		String Code = driver.findElement(By.xpath("//div[@class='promo-title']//br")).getText();
		driver.findElement(By.xpath("//span[contains(text(),'Enter pin-code ')]")).click();
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='pincode']")));
		driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("560043");
		
		driver.findElement(By.xpath("//button[text()='CONFIRM PINCODE']")).click();
		String ExpectedDate = driver.findElement(By.xpath("//li[text()='Expected Delivery: ']//span")).getText();
		
		System.out.println("the Expected Delivery date:" + " " + ExpectedDate);
		
		driver.findElement(By.xpath("//div[text()='Other information']")).click();
		
		String CustomerAddress = driver.findElement(By.xpath("(//span[text()='Customer Care Address']/following-sibling::span)[2]")).getText();
		System.out.println("The Customer Address is" + " " + CustomerAddress );
		
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']/parent::div/parent::div[@class='pdp-addtocart-button']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='GO TO BAG']/parent::div"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='GO TO BAG']/parent::div")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='GO TO BAG']/parent::div")).click();
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Order Total']/following-sibling::span"))));
		String Price = driver.findElement(By.xpath("//span[text()='Order Total']/following-sibling::span")).getText();
		
		String PriceVal = Price.replaceAll("\\D","");
		System.out.println("The value of the Bag" + " " + PriceVal);
		
		if(driver.findElement(By.xpath("//input[@id='couponCodeInput']")).isEnabled())
		{
			driver.findElement(By.xpath("//input[@id='couponCodeInput']")).sendKeys(Code);
			
		}
		else
			System.out.println("The code couldnt be entered");
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		String text = driver.findElement(By.xpath("//p[@class='applied-voucher-message']")).getText();
		
		System.out.println("Code message" + " " + text);
		
		String CouponSavings = driver.findElement(By.xpath("(//span[@class='price-value discount-price'])[2]")).getText();
		String CouponAmtStr = CouponSavings.replaceAll("\\D","");
		Double CouponAmt=Double.parseDouble(CouponAmtStr);
		
		double CouponroundOff = Math.round(CouponAmt*100)/100;
		
		String YouSave = driver.findElement(By.xpath("//p[@class='you-save-text']")).getText();
		String YouSaveStr = YouSave.replaceAll("\\D","");
		
		Double YouSaveAmt=Double.parseDouble(YouSaveStr);
		double YouSaveroundOff = Math.round(YouSaveAmt*100)/100;
		
		if(CouponroundOff==YouSaveroundOff)
		{
			System.out.println("The Coupn Saving matches the You pay Amt");
		}
		else
			System.out.println("The Coupon does not matched the You Pay Amt");
		
		
		driver.findElement(By.xpath("//span[@class='ic-delete navigation-icon']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='delete-btn']")));
		driver.findElement(By.xpath("//div[@class='delete-btn']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='DELETE']")));
		driver.findElement(By.xpath("//div[text()='DELETE']")).click();
		

	}

}

package week4Day2_AssgPart2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*  Nykaa Assignment
	======================
	1) Go to  https://www.nykaa.com/
	2) Mouseover on Brands and Search L'Oreal Paris
	3) Click L'Oreal Paris
	4) Check the title contains L'Oreal Paris(Hint-GetTitle)
	5) Click sort By and select customer top rated
	6) Click Category and click Hair->Click haircare->Shampoo
	7) Click->Concern->Color Protection
	8)check whether the Filter is applied with Shampoo
	9) Click on L'Oreal Paris Colour Protect Shampoo
	10) GO to the new window and select size as 175ml
	11) Print the MRP of the product
	12) Click on ADD to BAG
	13) Go to Shopping Bag 
	14) Print the Grand Total amount
	15) Click Proceed
	16) Click on Continue as Guest
	17) Check if this grand total is the same in step 14
	18) Close all windows
*/

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		Thread.sleep(3000);
		
		//Mouseover on Brands and Search L'Oreal Paris
		WebElement moveToElt = driver.findElement(By.xpath("//a[text()='brands']"));
				
		Actions obj = new Actions(driver);
		obj.moveToElement(moveToElt).perform();
		
		//Click L'Oreal Paris
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'oreal Paris");
		
		driver.findElement(By.xpath("//a[contains(@href,'Oreal Paris')]")).click();
			
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
			System.out.println("The title contains L'Oreal Paris");
		else
			System.out.println("The title doesnot contain L'Oreal Paris");
		
		Thread.sleep(3000);
		//Click sort By and select customer top rated
			
		driver.findElement(By.xpath("//div[@id='filters-listing']//span")).click();		
		driver.findElement(By.xpath("(//div[@id='filters-listing']//span)[5]")).click();
						
		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("(//div[@class='filter-open css-1gdff5r'])[2]")).click();
		
		//Click Hair
		driver.findElement(By.xpath("//li[@class='css-1do4irw']//span")).click();
		
		//Click HairCare
		driver.findElement(By.xpath("(//li[@class='css-1do4irw']//span)[3]")).click();
		
		//Click Shampoo
		driver.findElement(By.xpath("(//li[@class='css-1do4irw']//span)[5]")).click();
				
		//Click->Concern->Color Protection
		driver.findElement(By.xpath("//div[@class='filter-open css-1gdff5r']//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//div[@class='control-value']//span[text()='Color Protection']")).click();
	
		//check whether the Filter is applied with Shampoo
		String  filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println("Filter : "+filter);
		if(filter.equals("Shampoo")) 
			System.out.println("Filter is applied with Shampoo");
		else
			System.out.println("Filter is NOT applied with Shampoo");
		
		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']//ancestor::a")).click();
		
		// GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> links = new ArrayList<String>(windowHandles);
		driver.switchTo().window(links.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']/parent::button")).click();
		
		// Print the MRP of the product
		String text = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("MRP of L'Oreal Paris Colour Protect Shampoo 180ml : "+text);
		
		/*
		12) Click on ADD to BAG
		13) Go to Shopping Bag 
		14) Print the Grand Total amount
		15) Click Proceed
		16) Click on Continue as Guest
		17) Check if this grand total is the same in step 14
		18) Close all windows */
		//driver.findElement(By.xpath("
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']/parent::button")).click();
		
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		
		//14. Print the Grand Total amount
		driver.switchTo().frame(0);
		
		String text2 = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span")).getText();
		System.out.println("Grand Total amount : "+text2);
	
		// Click Proceed		
		driver.findElement(By.xpath("//span[text()='Proceed']//ancestor::button")).click();

		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		//driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		//Close the address window
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']/img")).click();
		
		//Check if this grand total is the same in step 14
		String text3 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		if(text3.equals(text2))
			System.out.println("Grand Total is equal to the amount to be paid");
		else
			System.out.println("Grand Total is NOT EQUAL to the amount to be paid");
		
		//Close all windows
		driver.quit();
	}

}

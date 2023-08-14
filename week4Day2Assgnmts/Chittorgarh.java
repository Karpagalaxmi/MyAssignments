package week4Day2Assgnmts;

import java.time.Duration;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*chittorgarh Assignment
========================
1. Launch the URL https://www.chittorgarh.com/
2. Click on stock market
3. Click on NSE bulk Deals
4. Get all the Security names
5. Ensure whether there are duplicate Security names 
*/

public class Chittorgarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");	
		
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();		
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		String names ="";
		List<WebElement> secList = driver.findElements(By.xpath("//tbody//a"));
		Set<String> secname = new TreeSet<String>();
		System.out.println("\n Count of Security Names including Duplicates : " + (secList.size()-2));
		for(int i =0;i < secList.size()-2; i++) {
			names = secList.get(i).getText();
			secname.add(names);				
		}
		System.out.println("\n\nCount of Security Names Without Duplicates: " +secname.size());
		
			
		if(secList.size() != secname.size()) {
			System.out.println("\n\n\tThere are Duplicate Security Names");
		}
		else {
			System.out.println("\tNO Duplicate Security Names");
		}
		
		
		
			
	}

}

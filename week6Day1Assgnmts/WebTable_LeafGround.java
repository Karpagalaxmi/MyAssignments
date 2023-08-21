package week6Day1Assgnmts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_LeafGround 
{
	public static void main(String[] args) 
	{		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/table.xhtml");
	
		String firstData = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td")).getText();
		System.out.println("Print the 1st Data: "+firstData);
	
		//Print the 2ndRow, 3rd Column
		String rowData = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[2]/td[3]")).getText();
		System.out.println("\nPrint the value in 2ndRow, 3rd Column: " +rowData);
		
		//Row count
		List<WebElement> row = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr"));
		int rowsize = row.size();
		System.out.println("\nRow size : "+rowsize);

		//Column count
		List<WebElement> col = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[1]/td"));
		int colsize = col.size();
		System.out.println("Column size : "+colsize);

		//Print all data inside WebTable
		System.out.println("\nPrint ALL values in the WebTable:");
		System.out.println("==================================");
		for (int i = 1; i <=rowsize; i++) 
		{
			for (int j = 1; j <=colsize; j++) 
			{
				String text = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(text);
			}
		}
		driver.close();
	}

}
package week6Day1Assgnmts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Print values in the table Assignment 
=====================================
1. Launch the URL https://html.com/tags/table/
2. You have to print the respective values based on given Library
(hint: if the library was absolute usage, then print all its value)
*/


public class PrintValuesinTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		//First Table : 'The Three Most Popular JavaScript Libraries'
		List<WebElement> trows = driver.findElements(By.xpath("//div[@class='render']/table/*")); // rtn caption,thead,tbody,tfoot
		int trowSize = trows.size();
		trowSize = trowSize-2; // exclude caption and tbody
		List<WebElement> count_rows_in_tbody = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr")); // get no. of rows in tbody
		trowSize= trowSize + count_rows_in_tbody.size();
		
		List<WebElement> tcols = driver.findElements(By.xpath("//div[@class='render']/table/thead/tr[1]/th"));
		int tcolSize = tcols.size();
				
		for(int i=1;i<= count_rows_in_tbody.size();i++)
		{
			int flag=0;
			for(int j=1;j<= tcolSize;j++)
			{
				String text = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(flag==1 || text.equalsIgnoreCase("Absolute Usage"))
				{
					System.out.println(text);
					flag=1;					
				}				
			}
		}		
		driver.close();
	}

}

package week6Day1Assgnmts;

/*Count No Of rows and columns Assignment
=============================================
1. Launch the URL https://html.com/tags/table/
2. Get the count of number of rows
3. Get the count of number of columns
*/

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountRowsColumns_WebTable {
	public static void main(String[] args) {
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		//First Table : 'The Three Most Popular JavaScript Libraries'
		System.out.println("Table Name:\n==========");
		System.out.println(driver.findElement(By.xpath("//caption")).getText());

		List<WebElement> count_rows_in_tbody = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr")); 
		int trowSize= count_rows_in_tbody.size();
		System.out.println("\nNo. of Rows: "+ trowSize);
		List<WebElement> tcols = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
		int tcolSize = tcols.size();
		System.out.println("No. of Columns: "+ tcolSize);
		
		/*List<WebElement> trows = driver.findElements(By.xpath("//div[@class='render']/table/*")); // rtn caption,thead,tbody,tfoot
		int trowSize = trows.size();
		trowSize = trowSize-2; // exclude caption and tbody
		List<WebElement> count_rows_in_tbody = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr")); // get no. of rows in tbody
		trowSize= trowSize + count_rows_in_tbody.size();
		System.out.println("\nNo. of Rows: "+ trowSize);
				
		List<WebElement> tcols = driver.findElements(By.xpath("//div[@class='render']/table/thead/tr[1]/th"));
		int tcolSize = tcols.size();
		System.out.println("No. of Columns: "+ tcolSize);
		*/
		
		
		//Second Table :'Attributes of Create An HTML Table Quickly & Easily With Our Code Example'
		System.out.println("\n\nTable Name:\n==========");
		System.out.println(driver.findElement(By.xpath("//div[@class='related-pages']/h2")).getText());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		int rowSize = rows.size();
		System.out.println("\nNo. of Rows: "+ rowSize);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[1]/th"));
		int colSize = cols.size();
		System.out.println("No. of Columns: "+ colSize);
		
		driver.close();
	}
	
}

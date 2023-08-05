package week4Day1Assgnmts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrame {

	/*Frame Assignment
	=====================
	https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0
	*/
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
				
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
				
		//Focus to frame - Inside Frame
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
			
		//Come out from frame
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		//Nested Frame - Frame 1
		driver.switchTo().frame(2);
		
		//Nested Frame - Frame 2
		driver.switchTo().frame("frame2");
		Thread.sleep(3000);
		
		driver.findElement(By.id("Click")).click();
		
		//Come out from frame
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		

	}
	

}

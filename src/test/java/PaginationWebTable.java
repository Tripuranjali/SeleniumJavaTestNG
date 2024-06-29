import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PaginationWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor je =(JavascriptExecutor) driver;
		WebElement element=driver.findElement(By.xpath("//a[text()='Blogger']"));
		je.executeScript("arguments[0].scrollIntoView();",element);
		List <WebElement> list = driver.findElements(By.xpath("//*[@id='pagination']/li/a"));
		int count=0;
		
		for(WebElement ele:list) {
			ele.getText();
			//pages=Integer.parseInt(page);
			count++;
		}
		System.out.println(count);
		for (int p=1;p<=count;p++) {
			if(p>1) {
				WebElement activepage= driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()="+p+"]"));
				activepage.click();
				
			}
			int rows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
			int cols = driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			for(int r=1;r<rows;r++) {
				for(int c=1;c<cols;c++) {
				
				String Table =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td["+c+"]")))).getText();
				
				
				//String Name =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")))).getText();
				System.out.print(Table+"\t"+"\n");
				}
				
			}			
			List <WebElement> checkbox = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr//td[4]//input[@type='checkbox']"))));
			for(WebElement checkclick: checkbox) {
				checkclick.click();
			}
			
		}
		
			
	}



}




	





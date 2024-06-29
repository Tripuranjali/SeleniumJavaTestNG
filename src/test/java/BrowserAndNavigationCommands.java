import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserAndNavigationCommands {

	public static  void main(String[] args) throws InterruptedException {
	

		ChromeDriver driver = new ChromeDriver();
			
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit' and @class='wikipedia-search-button']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));		
		List <WebElement> linkscount= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@href, 'Selenium')]"))); //driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']"));
		System.out.println(linkscount.size());
		
		for(WebElement eachele:linkscount) {
			eachele.click();
			
		}
		
		Set <String> WinID =driver.getWindowHandles();		
		List <String> WinList = new ArrayList<String>(WinID);
		
		System.out.println(WinList);
		for(String wl:WinList) {
			String title=driver.switchTo().window(wl).getTitle();
			System.out.println(title);
			if(title.equals("Selenium disulfide - Wikipedia")) {
				driver.close();
			}
		}
		
		
		
		
		

	}

}

package seleniumwebdriverpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com//");
		
		driver.findElement(By.name("username")).sendKeys("dnyaneshwarR");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Radhika Rathd')]/parent::"
				+ "td//preceding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'test1 test2 Tester')]/parent::"
				+ "td//preceding-sibling::td//input[@name='contact_id']")).click();;
		

	}

}

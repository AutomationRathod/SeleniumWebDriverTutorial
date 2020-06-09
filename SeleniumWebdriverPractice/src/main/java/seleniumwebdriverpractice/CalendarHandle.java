package seleniumwebdriverpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarHandle {

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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		String date = "22-May-2020";
		String[] dateArr = date.split("-"); //{22}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);
		
		String beforeXpath ="";
		String AfterXpath = "";
		
		final int totalWeekDay = 7;
		
		boolean flag = false;
		String dayVal= null;
		for(int rowNum=2; rowNum <=7; rowNum++)
		{
			for(int colNum=1; colNum<=totalWeekDay; colNum++)
			{
				try {
				 dayVal=driver.findElement(By.xpath(beforeXpath+rowNum+AfterXpath+colNum+"]")).getText();
				
				}catch(NoSuchElementException e){
					System.out.println("Please enter Correct date values");
					flag = false;
					break;
				}
				
				
				System.out.println(dayVal);
				if(dayVal.equals(day))
				{
					driver.findElement(By.xpath(beforeXpath+rowNum+AfterXpath+colNum+"]")).click();
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}			
		}
		
		

	}

}

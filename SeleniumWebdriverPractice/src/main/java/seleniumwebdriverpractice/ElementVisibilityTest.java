package seleniumwebdriverpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get("https://register.freecrm.com/register/");
		
		//isDisplayed() method: applicable for all the elements
		//return true/false
		
		boolean b1 = driver.findElement(By.name("action")).isDisplayed();
		System.out.println(b1);//
		
		//2. isEnabled() method:
		
		boolean b2 = driver.findElement(By.name("action")).isEnabled();
		System.out.println(b2);
		
		//select I Agree term & condition
		
		driver.findElement(By.id("terms")).click();
		boolean b3 = driver.findElement(By.name("action")).isEnabled();
		System.out.println(b3);
		
		//3. isSelected() method: only applicable for checkbox,dropdown,radiobutton
		boolean b4 = driver.findElement(By.name("action")).isSelected();
		System.out.println(b4);//true
		
		//de-select checkboxI Agree term & condition
		
		driver.findElement(By.id("terms")).click();
		boolean b5 = driver.findElement(By.name("action")).isSelected();
		System.out.println(b5);//false
		
		
		

		
	}

}

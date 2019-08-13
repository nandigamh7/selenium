package seleniumtest;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();	
		 String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		 driver.get(baseUrl);
		 
		 driver.manage().window().maximize();
		 driver.findElement(By.name("firstName")).sendKeys("Munna");
		 driver.findElement(By.name("lastName")).sendKeys("Bhai");
		 driver.findElement(By.name("phone")).sendKeys("9897969594");
		 driver.findElement(By.id("userName")).sendKeys("munnabhai@gmail.com");
		 
		 driver.findElement(By.name("address1")).sendKeys("D NO: 1-104/1, 1234 main street");
		 driver.findElement(By.name("city")).sendKeys("Unknow City");
		 driver.findElement(By.name("state")).sendKeys("Unknown State");
		 driver.findElement(By.name("postalCode")).sendKeys("100001");
		 
		 Select countryDrpDwn = new Select(driver.findElement(By.name("country")));
		 countryDrpDwn.deselectByValue("ALBANIA");
		
		 driver.findElement(By.id("email")).sendKeys("munna");
		 driver.findElement(By.name("password")).sendKeys("password");
		 driver.findElement(By.name("confirmPassword")).sendKeys("password");
		 
		 driver.findElement(By.name("submit")).click();

		 Thread.sleep(3000);
		 driver.findElement(By.linkText("sign-in")).click();
	}
	
}

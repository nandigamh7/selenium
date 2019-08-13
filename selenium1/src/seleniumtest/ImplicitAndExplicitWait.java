package seleniumtest;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitAndExplicitWait {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
		driver.get("http://demo.guru99.com/popup.php");
		
		//Get Size method of window
		System.out.println("Window size: " +driver.manage().window().getSize());
		driver.manage().window().maximize();
		System.out.println("Window size after maximize: " +driver.manage().window().getSize());
		
		Dimension d = new Dimension(420, 600);
		driver.manage().window().setSize(d);
		System.out.println("Window size after dimension set: " +driver.manage().window().getSize());
		Thread.sleep(3000);
		
		By by1 = By.linkText("Click Here");
		WebElement element = driver.findElement(by1);
		System.out.println("Attribute:"+element.getAttribute("name"));
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("All links: "+allLinks);
		
		
		driver.findElement(By.linkText("Click Here")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String mainWindow= driver.getWindowHandle();
		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		System.out.println("Session ID main window.....: "+mainWindow);
		while(i1.hasNext()){
			String childWindow = i1.next();
			if(!mainWindow.equalsIgnoreCase(childWindow)){
				//Switching to child window
				driver.switchTo().window(childWindow);
				System.out.println("Session ID child window.....: "+childWindow);
				
				//IMPLICITLY WAITING FOR 2 SECONDS
//				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//				driver.findElement(By.name("emailid")).sendKeys("munna");
				
				//EXPLICITLY waiting for the visibility of the element until 20 seconds
				By by = By.name("emailid");
				WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				email.sendKeys("munna");
				
				driver.findElement(By.name("btnLogin")).click();
				//Closing child window
				driver.close();
			}
		}
		//Switching to main window.
		driver.switchTo().window(mainWindow);
		driver.close();
	}

}

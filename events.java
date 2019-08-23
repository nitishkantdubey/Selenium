package sel_test;
//Be careful While Removing the comments

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class events {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver",
			//	"C://Users//Nitishkant.dubey//workspace//sel_test//driver//chromedriver.exe");
		System.setProperty("webdriver.gecko.driver",
				"C://Users//Nitishkant.dubey//workspace//sel_test//driver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		String url = "https://demoqa.com/droppable/";
		String url2 = "http://demo.guru99.com/test/delete_customer.php";
		driver.manage().window().maximize();
		driver.get(url2);
		//driver.get(url2);
		Actions act = new Actions(driver);
		if(driver.getTitle().equals("Droppable – ToolsQA – Demo Website to Practice Automation"))
		{
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source,dest).perform();;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		else if (driver.getTitle().equals("Delete Customer"))
		{
			driver.findElement(By.name("cusid")).sendKeys("user");
			driver.findElement(By.name("submit")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println("alert 1 "+alert.getText());
			alert.accept();
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("alert 2 "+alert.getText());
			alert.accept();		
		}		
		driver.quit();	
	}
}

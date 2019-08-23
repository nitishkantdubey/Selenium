package sel_test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//This program includes Google from Submission With wrong password and capture screen shot 
//if correct password then send mail

public class gmail {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TO DO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//Nitishkant.dubey//workspace//sel_test//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		WebDriverWait wait = new WebDriverWait(driver,2);
		
		try
		{
		
			By Email = By.xpath("//input[@aria-label='Email or phone']");
			WebElement mail_id = driver.findElement(Email);
			mail_id.clear();
			mail_id.sendKeys("example@gmail.com");
			
			WebElement Next_btn = driver.findElement(By.xpath("//*[@id='identifierNext']/span/span"));
			Next_btn.click();
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
			
			WebElement Password = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
			Password.sendKeys("password");
			
			WebElement Next_btn2 = driver.findElement(By.xpath("//*[@id='passwordNext']/span/span"));
			Next_btn2.click();
	
			WebElement Compose = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
			Compose.click();
			
			WebElement To_email = driver.findElement(By.xpath("//textarea[@name='to']"));
			To_email.sendKeys("recipient@gmail.com");
			
			WebElement Body = driver.findElement(By.xpath("//div[@role='textbox']"));		
			Body.sendKeys("Enter Your Body of email Here");
	
			WebElement send = driver.findElement(By.xpath("(//div[@role='button'])[53]"));
			send.click();
			
			
			
			
		}
		
		catch(Exception e)
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D://src/screenshot.png"));
			System.out.println("element exception Called " + e);
		}
		
	}

}

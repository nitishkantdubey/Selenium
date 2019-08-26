//ps also check the (.xml) file with this file for the html structure named as extent-config.xml 
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Nitishkant.dubey//workspace//sel_test//driver//chromedriver.exe");
		WebDriver driver3 	= new ChromeDriver(); 
		String url = "https://demoqa.com/droppable/";
		driver3.manage().window().maximize();
		driver3.get(url);
		Actions act3 = new Actions(driver3);
		act3.dragAndDrop(driver3.findElement(By.id("draggable")),driver3.findElement(By.id("droppable"))).perform();;
		ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\result.html");
		ExtentTest test ;
		 report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		 test = report.startTest("demo");
		 
		 if(driver3.getTitle().equalsIgnoreCase("Droppable – ToolsQA – Demo Website to Practice Automation"))
		{
			test.log(LogStatus.PASS, "passed");
			System.out.println("test pass");
		}
		else 
		{
			test.log(LogStatus.FAIL, "fail");
			System.out.println("test fail");
		}
		report.endTest(test);
		report.flush();
	}

}

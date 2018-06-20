package selenium.one.tatoc;

import org.openqa.selenium.By;
import java.util.*;

import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
	static WebDriver driver;
	
//   public static void main(String[] args)
//   {
//	   	
//    	BasicCourse();    	
//    	GreenBox();
//    	ColorChange();
//    	DragAndDrop();
//    	LaunchWindow();
//    	GenerateToken();
//   }
     
   public static void BasicCourse()
    {
    	driver.findElement(By.linkText("Basic Course")).click();	
    }
    
    public static void GreenBox()
    {
    	
    	driver.findElement(By.className("greenbox")).click();
    }
    public static void ColorChange()
    {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		String actualAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
		Boolean condition = true;
		while(condition) {
			driver.findElement(By.cssSelector("body > center > a:nth-child(7)")).click();
			WebElement childDiv = driver.findElement(By.id("child"));
			driver.switchTo().frame(childDiv);
			String expectedAnswer = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(actualAnswer.equals(expectedAnswer)) {
				condition = false;
			}
		}
		driver.findElement(By.cssSelector("body > center > a:nth-child(9)")).click();
	    driver.switchTo().defaultContent();
    }
    
    public static void DragAndDrop()
    {		
    	
		Actions act = new Actions(driver);	
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		act.dragAndDrop(from, to).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
    }
    
    public static void LaunchWindow()
    {
    	
    	driver.findElement(By.linkText("Launch Popup Window")).click();
		String MainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String ChildWindow = it.next();	
			driver.switchTo().window(ChildWindow);	
			if(!MainWindow.equalsIgnoreCase(ChildWindow))	
			{                                                                                                  
	           		driver.findElement(By.id("name")).sendKeys("Neha Varshney");
	            		driver.findElement(By.id("submit")).click();
	            		break;
			}
		}
		driver.switchTo().window(MainWindow);
		driver.findElement(By.linkText("Proceed")).click();
    }
    
    public static void GenerateToken()
    {    	
    	driver.findElement(By.linkText("Generate Token")).click();
    	String Cookie_val = driver.findElement(By.id("token")).getText();
		Cookie ck = new Cookie("Token", Cookie_val.substring(7));
		driver.manage().addCookie(ck);
		driver.findElement(By.linkText("Proceed")).click();
    }
}


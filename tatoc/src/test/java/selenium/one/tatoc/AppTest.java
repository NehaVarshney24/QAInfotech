package selenium.one.tatoc;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest extends App

{
	@BeforeClass
	public void before()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Neha Workspace\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.get("http://10.0.1.86/tatoc");
	}
	@AfterClass
	public void after()
	{
		driver.quit();
	}
	@Test
	public void page1() {
		BasicCourse();
		Assert.assertEquals("Grid Gate - Basic Course - T.A.T.O.C", driver.getTitle());
		
	}
	
	@Test(dependsOnMethods = {"page1"})
	public void page2() {
		GreenBox();
		Assert.assertEquals("Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());
	}
	@Test(dependsOnMethods = {"page2"})
	public void page3() {
		ColorChange();
		Assert.assertEquals("Drag - Basic Course - T.A.T.O.C", driver.getTitle());
	}
	
	@Test(dependsOnMethods = {"page3"})
	public void page4() {
		DragAndDrop();
		Assert.assertEquals("Windows - Basic Course - T.A.T.O.C", driver.getTitle());
	}
	
	@Test(dependsOnMethods = {"page4"})
	public void page5() {
		LaunchWindow();
		Assert.assertEquals("Cookie Handling - Basic Course - T.A.T.O.C", driver.getTitle());
	}
	
	@Test(dependsOnMethods = {"page5"})
	public void page6() {
		GenerateToken();
		Assert.assertEquals("End - T.A.T.O.C", driver.getTitle());
	}
}

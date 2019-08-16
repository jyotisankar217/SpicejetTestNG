package spicejettestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpicejetTestNG {
	WebDriver driver=null;
	Select driver2=null;
	JavascriptExecutor js=null;
	
	@BeforeTest
public void beforetest()
	{
System.setProperty("webdriver.gecko.driver", "D:\\Firefox\\geckodriver.exe");
driver =new  FirefoxDriver();
driver.get("https://www.spicejet.com/");

	  }
@Test	
public void test1()
    {
	 driver2 =new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	 driver2.selectByIndex(3);
     }
@Test
public void test2() 
     {
	driver.findElement(By.id("divpaxinfo")).click();
	for( int i=0;i<3;i++)
	{
	driver.findElement(By.id("hrefIncAdt")).click();
	}
	 for (int i2=0;i2<2;i2++){
			driver.findElement(By.id("hrefIncChd")).click();
		}
    for (int i3=0;i3<2;i3++){
			driver.findElement(By.id("hrefIncInf")).click();
		}
    driver.findElement(By.id("btnclosepaxoption")).click();
    
     }
@Test
public void test3() {
	int count3= driver.findElements(By.name("ctl00$mainContent$rbtnl_Trip")).size();
	
    for(int i4=0;i4<count3;i4++) {
		    String text2 = driver.findElements(By.name("ctl00$mainContent$rbtnl_Trip")).get(i4).getAttribute("value");
			if(text2.equals("One Way"))
			{
				driver.findElements(By.name("ctl00$mainContent$rbtnl_Trip")).get(i4).click();
				
			}
			System.out.println(driver.findElements(By.name("ctl00$mainContent$rbtnl_Trip")).get(i4).getAttribute("value"));
		}
    
     
}
@Test
public void test4() throws InterruptedException {
	int count=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
	   System.out.println(count);
	   Thread.sleep(6000);
	 
		      for(int i=1;i<count;i++) {
		    	 String text=driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("value");
	          if(text.equals(" Family and Friends"))
		   
		   driver.findElements(By.id("//input[@type='checkbox']")).get(i).click();
		
		   System.out.println(text);
		  
	   }
		   
                    }
@Test
public void test5() {
 js= (JavascriptExecutor)driver;
js.executeScript("document.getElementById('ctl00_mainContent_ddl_originStation1_CTXT').value='HYD';");
js.executeScript("document.getElementById('ctl00_mainContent_ddl_destinationStation1_CTXT').value='BOM';");
}
@AfterTest
public void aftertest() 
{
	driver.close();
}
}

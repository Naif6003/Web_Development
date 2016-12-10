import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
*
* Adapted from http://www.wunderkraut.com/blog/creating-and-running-a-simple-selenium-webdriver-test/2011-09-15
*/
public class ServletIT {
  private String baseUrl;
  private WebDriver driver;
  private ScreenshotHelper screenshotHelper;
  private String currentTestCase;

  //Before and After runs after each test
  @Before
  public void openBrowser() {
	  
    //baseUrl is the root url that the tester will hit
    baseUrl = "http://localhost:8080/naif-menu";
    driver = new ChromeDriver();
    screenshotHelper = new ScreenshotHelper();
  }

  @After
  public void saveScreenshotAndCloseBrowser() throws IOException {
    screenshotHelper.saveScreenshot(currentTestCase + "-screenshot.png");
    driver.quit();
  }

  
  @Test
  public void checkLogin() throws IOException {
	
	  currentTestCase = "testMenusPage";
	  driver.get(baseUrl+"/Menus_List");

	    
	    WebElement username = driver.findElement(By.id("username"));
	    WebElement userpassword = driver.findElement(By.id("password"));
	    
	    
	    username.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Naif");
	    userpassword.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1");
	    
	    username.submit();
	   
	    
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return driver.getTitle().startsWith("Menus");
	        }
	    });
	    
	    
	    assertEquals("Menus", driver.getTitle());
	    
	    
  }

 
  //A single test
  @Test
  public void MenusList() throws IOException {
	
	  currentTestCase = "testAddMenu";
	  driver.get(baseUrl+"/Menus_List");
	     
	    
	    WebElement username = driver.findElement(By.id("username"));
	    WebElement userpassword = driver.findElement(By.id("password"));
	    
	    
	    username.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Naif");
	    userpassword.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1");
	    
	    username.submit();
	    
	  //Wait for page title to change back to Projects, timeout in 10 seconds
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return driver.getTitle().startsWith("Menus");
	        }
	    });
	    
	   WebElement addMenu = driver.findElement(By.id("add"));
	   
	   addMenu.submit();
    
		  WebElement name = driver.findElement(By.id("name"));
		  WebElement description = driver.findElement(By.id("description"));
		  
		  name.sendKeys(Keys.chord(Keys.CONTROL, "a"), "new menu");
		  description.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Add by Maven 2");
		  
		  
		  name.submit();

	    
		//Wait for page title to change back to Projects, timeout in 10 seconds
		    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		            return driver.getTitle().startsWith("Menus");
		        }
		    });
	    
   
		    assertEquals("new menu", driver.findElement(By.id("14")).getText());
   
   
  }


//Saves screenshot
  private class ScreenshotHelper {

    public void saveScreenshot(String screenshotFileName) throws IOException {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot, new File("target/"+screenshotFileName));
    }
  }
}
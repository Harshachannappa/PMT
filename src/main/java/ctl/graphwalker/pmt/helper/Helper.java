package ctl.graphwalker.pmt.helper;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by krikar on 2015-02-01.
 */
public class Helper {
 

    /**
     * Random number generator.
     * Will be used to create random data used for input in test.
     */
    static private Random random = new Random(System.currentTimeMillis());

    /**
     * Timeout time in seconds used for waiting for element(s) to show up.
     */
    final static int timeOut = 10;

    /**
     * Generates a random number with 1 to max digits.
     *
     * @param max Maximum length of digits.
     * @return The random number
     */
    public static int getRandomInt(int max) {
        return random.nextInt(max) + 1;
    }

    public static void setup() {
        FirefoxDriverManager.getInstance().setup();
    }

    public static void tearDown() {
        getInstance().quit();
    }

    /**
     * Creates an instance of the Firefox WebDriver.
     */
    private static class WebDriverHolder {
        private static final WebDriver INSTANCE = new ChromeDriver();
    }

    public static WebDriverWait getWaiter() {
        return new WebDriverWait(getInstance(), 10);
    }

    /**
     * If not already created, creates the singleton webdriver object.
     *
     * @return the singleton webdriver object
     */
    public static WebDriver getInstance() {
    	//System.setProperty("webdriver.chrome.driver","C:\\_graphWalker\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver","./src/main/resources/Exe/chromedriver.exe");
        return WebDriverHolder.INSTANCE;
    }
    
    
//    public static void windowhandles(WebDriver driver)
//   	{	
//   	Set<String> windows = driver.getWindowHandles();
//   	Iterator<String> it=windows.iterator();
//   	String Mainhndl=it.next();
//   	String Chidhndl=it.next();
//   driver.switchTo().window(Chidhndl);
//
//   		}
    
    public static void windowhandles()
	{

	Set<String> windows = Helper.getInstance().getWindowHandles();
  	 int count=0;
  	 for (String window : windows) {
		if(count ==1){
			Helper.getInstance().switchTo().window(window);
		}
		count++;
	}
	}
 
      	

   	public static void alertwindow()
   	{
   		Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
		Helper.getInstance().switchTo().alert().accept();	
   	}
      	
//   	public static void FrameHandle()
//   	{
//   		Helper.getInstance().switchTo().frame(2);
//   	}
   	
   	public static void calendercntrl()
   	{
   		List<WebElement> dates = Helper.getInstance().findElements(By.xpath("html/body/div[1]/table/tbody/tr/td"));
        int total_start_dates = dates.size();
        
        for(int i=0;i<total_start_dates;i++)
        {
               String date = dates.get(i).getText();
               if(date.equals("1"))
               {
                      dates.get(i).click();
                      break;
               }
        }
   	}
        
      public static void calendercntrl2()
      
      {
    	  List<WebElement> dates1 = Helper.getInstance().findElements(By.xpath("html/body/div[2]/table/tbody/tr/td"));
          int total_end_dates = dates1.size();
          for(int i=0;i<total_end_dates;i++)
          {
                 String date1 = dates1.get(i).getText();
                 if(date1.equals("26"))
                 {
                        dates1.get(i).click();
                        break;
                 }
          }

      }
   	}
   	
   	
   	


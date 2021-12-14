package lambdatest; //<your package name>

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

class TestClass1 implements Runnable {
	@Test
public void run() {
    Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
    capsHashtable.put("browserName", "Chrome");
    capsHashtable.put("version", "92.0");
    capsHashtable.put("platform", "Windows 10");
    capsHashtable.put("resolution", "1024x768");
    capsHashtable.put("build", "Certification-build");
    capsHashtable.put("name", "Test 1");
    Lambdatest r1 = new Lambdatest();
    r1.executeTest(capsHashtable);
}
}
class TestClass2 implements Runnable {
	@Test
  public void run() {
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "MicrosoftEdge");
      capsHashtable.put("version", "96.0");
      capsHashtable.put("platform", "Windows 8.1");
      capsHashtable.put("resolution", "1024x768");
      capsHashtable.put("build", "Certification-build");
      capsHashtable.put("name", "Test 2");
      Lambdatest r2 = new Lambdatest();
      r2.executeTest(capsHashtable);
  }
}
public class Lambdatest {
  public static final String USERNAME = "nehal0000kumar1999";
  public static final String AUTOMATE_KEY = "zVtVRvMpqwC6iF7STTYJPdmOqtaivWyPJAe7HA8mZYL0JeMktL";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
  public static void main(String[] args) throws Exception {
    Thread object1 = new Thread(new TestClass1());
    object1.start();
    Thread object2 = new Thread(new TestClass2());
    object2.start();

  }
  public void executeTest(Hashtable < String, String > capsHashtable) {
    String key;
    DesiredCapabilities caps = new DesiredCapabilities();
    // Iterate over the hashtable and set the capabilities
    Set < String > keys = capsHashtable.keySet();
    Iterator < String > itr = keys.iterator();
    while (itr.hasNext()) {
      key = itr.next();
      caps.setCapability(key, capsHashtable.get(key));
    }
    caps.setCapability("console","true");
	caps.setCapability("network",true);
	caps.setCapability("visual",true);
	caps.setCapability("video",true);
    WebDriver driver;
    try {
    	
    	 driver = new RemoteWebDriver(new URL(URL), caps);
         WebDriverWait wait = new WebDriverWait(driver, 20);
         
         driver.get("https://www.lambdatest.com/automation-demos");
         driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait.until(ExpectedConditions.
				   	  presenceOfElementLocated(By.xpath("//span[text()='Got it']")));
			driver.findElement(By.xpath("//span[text()='Got it']")).click();
         driver.findElement(By.id("username")).sendKeys("lambda");
         driver.findElement(By.id("password")).sendKeys("lambda123");
         driver.findElement(By.xpath("//*[@id='newapply']/div[3]/button")).click();
         wait.until(ExpectedConditions.
   	  presenceOfElementLocated(By.xpath("//*[@id='developer-name']")));
         driver.findElement(By.xpath("//*[@id='developer-name']")).sendKeys("nehal0000kumar1999@gmail.com");
         driver.findElement(By.id("populate")).click();
         driver.switchTo().alert().accept();
         driver.findElement(By.xpath("//input[@id='3months']")).click();
         driver.findElement(By.xpath("//input[@id='discounts']")).click();
         WebElement slider = driver.findElement(By.xpath("//div[@role='slider']"));
         WebElement sliderPosition = driver.findElement(By.xpath("//div[@style='position: absolute; left: 540px; margin-top: 5px; background-color: rgb(204, 204, 204);']"));
         driver.findElement(By.xpath("//input[@id='tried-ecom']")).click();
         new Actions(driver).moveToElement(slider).dragAndDrop(slider, sliderPosition).build().perform();
    	driver.findElement(By.id("comments")).sendKeys("The Products are very nice to buy online");
    	((JavascriptExecutor) driver).executeScript("window.open()");
    	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(1));
    	driver.get("https://www.lambdatest.com/selenium-automation/");
    	String jenkins = driver.findElement(By.xpath("//img[@title='Jenkins']")).getAttribute("src");
    	wait.until(ExpectedConditions.
			   	  presenceOfElementLocated(By.xpath("//img[@title='Jenkins']")));
    	
    	new Actions(driver).moveToElement(driver.findElement(By.xpath("//img[@title='Jenkins']"))).build().perform();
    	URL imageURL = new URL(jenkins);
    	System.out.println(imageURL);
    	String destinationFile = "jenkins.svg";
		File file = new File(destinationFile);
		file.getAbsolutePath();
		String absolute = file.getAbsolutePath();
		InputStream is;
			is = imageURL.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			byte[] b = new byte[2048];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}

			is.close();
			os.close();

        driver.switchTo().window(tabs.get(0));

		try {
        driver.findElement(By.id("file")).sendKeys(absolute);
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		}
		catch(Exception e) {
			System.out.println(e);
		}
        
        driver.findElement(By.id("submit-button")).click();
    	driver.quit();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}













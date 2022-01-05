package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShareData {
   public WebDriver driver;
   @Before
   public void setUp() {
       //specificam unde se afla driverul pt browser
       System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
       //deschidem un browser
       driver = new ChromeDriver();
       //introducem o adresa
       driver.get("http://demo.automationtesting.in/Index.html");
       //schimbam rezolutia in full-screen
       driver.manage().window().maximize();
   }

   @After
   public void tearDown() {
       driver.quit();
   }
}

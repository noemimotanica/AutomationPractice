import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    //Web driver=variabila care e ajuta sa interactionam cu site-ul si elementele pe de pe site

    public WebDriver driver;

@Test
public void testAutomat () {
        //specificam unde se afla driverul pt browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        //deschidem un browser
        driver=new ChromeDriver();
        //introducem o adresa
        driver.get(" http://demo.automationtesting.in/Index.html");
        //schimbam rezolutia in full-screen
        driver.manage().window().maximize();
       // driver.quit();- se adauga doar la final

        //identificam elementul "sign in"
        WebElement signInElement= driver.findElement(By.id("btn1"));
        //facem un click
        signInElement.click();

        //identificam element dupa "locaters': id, class, name, link, css-e mai rapid la nivel de identificare, xpath
        WebElement emailElement=driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue="ceva@ceva.com";
        emailElement.sendKeys(emailValue);

        WebElement passwordElemet=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordValue="Obradfrumos34";
        passwordElemet.sendKeys(passwordValue);

        WebElement enterElement=driver.findElement(By.id("enterbtn"));
        enterElement.click();

       WebElement eroareElement=driver.findElement(By.id("errormsg"));
       String expectedError="Invalid User Name or PassWord";
       String actualError=eroareElement.getText();
       assertEquals("Mesajul de pe pagina nu este corect" ,expectedError, actualError);

    }
}

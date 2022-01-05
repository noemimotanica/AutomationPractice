import Base.ShareData;
import HelpMethods.ElementMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest extends ShareData {
public ElementMethods elementMethods;


@Test
public void testAutomat () {
    elementMethods= new ElementMethods(driver);

        //identificam elementul "sign in"
        WebElement signInElement= driver.findElement(By.id("btn1"));
        //facem un click
        elementMethods.clickElement(signInElement);

        //identificam element dupa "locaters': id, class, name, link, css-e mai rapid la nivel de identificare, xpath
        WebElement emailElement=driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue="ceva@ceva.com";
       elementMethods.fillElement(emailElement,"emailValue");

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

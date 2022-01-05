package HelpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class ElementMethods {

    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;

    }

    public void clickElement(WebElement element) {
        element.click();

    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);

    }

    public void validateElementMessage(WebElement webElement, String value) {
        WebElement eroareElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        String actualError = eroareElement.getText();
        assertEquals("Mesajul de pe pagina nu este corect", expectedError, actualError);

    }
}

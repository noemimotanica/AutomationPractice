import Base.ShareData;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v94.overlay.model.LineStyle;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest extends ShareData {

    @Test
    public void testAutomat() {

        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //interactionam cu switch to
        WebElement switchToElement=driver.findElement(By.xpath("//a[contains(text(), 'Switch')]"));
        Actions action=new Actions (driver);
        action.moveToElement(switchToElement).build().perform();
        //perform-executa comanda
       // build-inregistreaza comanda

        //identificam "alerts"
        WebElement alertsElement=driver.findElement(By.xpath("//a[contains(text(), 'Alerts')]"));
        alertsElement.click();
        String url="http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to(url);

        List<WebElement> AlertOptions=driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        AlertOptions.get(0).click();

        WebElement casutaOkButonElement =driver.findElement(By.cssSelector("#OKTab button"));
        casutaOkButonElement.click();

        Alert alertOk=driver.switchTo().alert();
        alertOk.accept();

        AlertOptions.get(1).click();

        WebElement CancelButonElement =driver.findElement(By.cssSelector("#CancelTab button"));
        CancelButonElement.click();
        Alert alertCancel=driver.switchTo().alert();
        alertCancel.accept();

        AlertOptions.get(2).click();
        WebElement TextBoxButonElement =driver.findElement(By.cssSelector("#Textbox button"));
        TextBoxButonElement.click();

        Alert alertText=driver.switchTo().alert();
        alertText.sendKeys("sa scriem");
        alertText.accept();
    }
}

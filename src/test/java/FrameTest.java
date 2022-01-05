import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrameTest {

    public WebDriver driver;
    @Test
    public void testAutomat() {
        //specificam unde se afla driverul pt browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        //deschidem un browser
        driver = new ChromeDriver();
        //introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");
        //schimbam rezolutia in full-screen
        driver.manage().window().maximize();
        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //interactionam cu switch to
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(), 'Switch')]"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).build().perform();
        //perform-executa comanda
        // build-inregistreaza comanda

        //identificam "frames"
        WebElement frameElement = driver.findElement(By.xpath("//a[contains(text(), 'Frames')]"));
        frameElement.click();
        String url = "http://demo.automationtesting.in/Frames.html";
        driver.navigate().to(url);

        List<WebElement> frameOptions=driver.findElements(By.cssSelector("ul[class='nav nav-tabs '] li a"));
        frameOptions.get(0).click();

        //ne mutam pe un iframe
        driver.switchTo().frame("singleframe");
        WebElement singleInputElement=driver.findElement(By.xpath("//input[@type='text']"));
        singleInputElement.sendKeys("ceva ce vrei tu");
        driver. switchTo().defaultContent();

        frameOptions.get(1).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        WebElement multipleInputElement=driver.findElement(By.xpath("//input[@type='text']"));
        multipleInputElement.sendKeys("ceva ce vrei tu");

        driver.quit();





    }
}

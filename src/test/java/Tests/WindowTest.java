package Tests;

import Base.ShareData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends ShareData {

    @Test
    public void testAutomat() {
        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //interactionam cu switch to
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).perform();
        //perform-executa comanda
        // build-inregistreaza comanda

        //identificam "windows"
        WebElement windowElement = driver.findElement((By.xpath("//a[contains(text(),'Windows')]")));
        windowElement.click();
        String url = "http://demo.automationtesting.in/Windows.html";
        driver.navigate().to(url);

        List<WebElement> windowOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        windowOptions.get(0).click();

        WebElement clickButonElement = driver.findElement(By.cssSelector("#Tabbed a button"));
        clickButonElement.click();

        System.out.println("titlul paginii" + driver.getTitle());

        //interactionam cu taburile nou deschise
        //salvam taburile intr-o lista noua
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());  //returneaza cate taburi/window-uri gaseste deschise
        driver.switchTo().window(tabs.get(1)); //window similar cu tav
        System.out.println("titlul paginii" + driver.getTitle());

        // driver.quit(); inchide browserul cu toate taburile existente
        driver.close(); //inchide doar tabul activ

        driver.switchTo().window(tabs.get(0));
        windowOptions.get(1).click();
        WebElement clickwindowElement = driver.findElement(By.cssSelector("#Seperate button"));
        clickwindowElement.click();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println("titlul paginii" + driver.getTitle());

        driver.close();

        driver.switchTo().window(windows.get(0));
        windowOptions.get(2).click();
        WebElement clickTabsElement = driver.findElement(By.cssSelector("#Multiple button"));
        clickTabsElement.click();
        ArrayList<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multipleTabs.get(2));

        driver.close();

        driver.switchTo().window(multipleTabs.get(1));

        driver.close();
        driver.switchTo().window(multipleTabs.get(0));
    }
}


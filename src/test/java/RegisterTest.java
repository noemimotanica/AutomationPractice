import Base.ShareData;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends ShareData {


    @Test
    public void testAutomat() {

        //gasim "skip sign in element"
        WebElement skipSignInElement=driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement firstNameElement=driver.findElement(By.cssSelector("input[placeholder='First Name']"));
         firstNameElement.sendKeys("Noemi");

         WebElement lastNameElement=driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
         lastNameElement.sendKeys("Pohrib");

        WebElement genderElement= driver.findElement(By.cssSelector("input[value='Male']"));
        genderElement.click();

        WebElement emailAdressElement=driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        emailAdressElement.sendKeys("noemi.pohrib@gmail.com");

        WebElement phoneElement=driver.findElement((By.cssSelector("input[ng-model='Phone']")));
        phoneElement.sendKeys("0744173502");


        WebElement hobbyElement=driver.findElement(By.id("checkbox3"));
                hobbyElement.click();

                WebElement skillsElement=driver.findElement(By.id("Skills"));
                Select skillsSelect=new Select(skillsElement);
                skillsSelect.selectByVisibleText("Android");



        WebElement yearElement=driver.findElement(By.id("yearbox"));
        Select yearSelect=new Select(yearElement);
        yearSelect.selectByValue("1970");

        WebElement countryElement=driver.findElement(By.id("country"));
        Select countrySelect=new Select (countryElement);
        countrySelect.selectByVisibleText("Australia");

        WebElement languageElement=driver.findElement(By.id("msdd"));
        languageElement.click();



        List<WebElement> languageElements=driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for( Integer i=0; i<languageElements.size(); i++) {
            if (languageElements.get(i).getText().equals("Bulgarian")) {
                Actions action=new Actions(driver);
                action.moveToElement( languageElements.get(i)).perform();
                languageElements.get(i).click();
                break;
            }
        }





        genderElement.click();
        //tema email, phone, select country

    //adresa
        WebElement adresaElement=driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String adresaElementValoare="Cluj nr 23";
        adresaElement.sendKeys(adresaElementValoare);
        //de facut un branch

        WebElement parolaElement=driver.findElement(By.id("firstpassword"));
        String parolaElementValoare="parola123";
        parolaElement.sendKeys(parolaElementValoare);

        //incarcam  o poza
        WebElement imageElement=driver.findElement(By.id("imagesrc"));
        imageElement.sendKeys("C:\\Users\\Noemi\\Desktop\\1.jpg");

        //validare pagina de "Register"
        String actualRegister=driver.getTitle();
      //  Assert.assertEquals("Register", "actualRegister");
       // String ceva="Register";
       // boolean proba=ceva==actualRegister;
    }



}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;

    @FindBy(id = "userEmail")
    WebElement inputEmail;


    public void typePracticeForm(){
        hideBanner();
        hideFooter();
        inputFirstName.sendKeys("Petya");
        inputLastName.sendKeys("Petrov");
        inputEmail.sendKeys("petya$petrov@gmail.com");
    }
}

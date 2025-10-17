package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static enums.Hobbies.MUSIC;

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

    @FindBy(id = "userNumber")
    WebElement inputMobile;

    @FindBy(id ="currentAddress")
    WebElement textAreaAddress;

    @FindBy(xpath= "//input[@id='dateOfBirthInput']")
    WebElement inputDateOfBirth;

    @FindBy(id = "subjectsInput")
    WebElement inputSubjects;

    @FindBy(id = "react-select-3-input")
    WebElement inputState;

    @FindBy(id = "react-select-4-input")
    WebElement inputCity;

    @FindBy(id = "submit")
    WebElement btnSubmit;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;

    public boolean validateModalMessage(){
        return validateTextInElement(modalMessage, "Thanks for submitting the form");
    }

    public boolean validateModalMessageNegative(){
        return validateTextInElement(modalMessage, "Wrong message!");
    }


    public void typePracticeForm(Student student){
        hideBanner();
        hideFooter();
        inputFirstName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
        //inputDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        pause(1);
        typeSubjects(student.getSubject());
        pause(1);
        typeHobbies(student.getHobbies());
        pause(1);
        textAreaAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        btnSubmit.click();

    }

    private void typeStateCity(String state, String city){
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);

    }

    private void typeHobbies(List<Hobbies> hobbies){
       for(Hobbies h: hobbies){
           switch(h){
               case MUSIC:
                   driver.findElement(By.xpath(h.getLocator())).click();
                   break;
               case SPORTS:
                   driver.findElement(By.xpath(h.getLocator())).click();
                   break;
               case READING:
                   driver.findElement(By.xpath(h.getLocator())).click();
                   break;
           }
       }



    }

    private void typeSubjects(String subjects){
        inputSubjects.click();
        String[] arr = subjects.split(",");
        for(String s:arr){
            inputSubjects.sendKeys(s);
            inputSubjects.sendKeys(Keys.ENTER);
        }

    }

    private void typeDateOfBirth(String dateOfBirth){
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
    }
    private void typeGender(Gender gender){
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

}

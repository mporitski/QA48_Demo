package tests;

import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegistrationFormPositive(){
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm();

    }
}

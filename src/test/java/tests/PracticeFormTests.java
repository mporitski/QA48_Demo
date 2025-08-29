package tests;

import dto.Student;
import emums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        Student student = new Student("Vasya", "Vasilev",
                "vasyavasilev@gmail.com",
                Gender.MALE, "0123456789",
                "04 Dec 1999", "Maths,Physics,Chemistry",
                "Sports", "", "street 1",
                "NCR", "Delhi");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
    }
}

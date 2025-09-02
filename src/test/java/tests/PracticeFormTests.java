package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        Student student = new Student("Vasya", "Vasilev",
                "vasyavasilev@gmail.com",
                Gender.MALE, "0123456789",
                "04 Dec 1999", "Maths,Physics,Chemistry",
                hobbies, "", "street 1",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[0]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(), "Test passed");
    }
}

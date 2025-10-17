package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    SoftAssert softAssert  = new SoftAssert();

    @Test(groups = "smoke")
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
//        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative(),
//                "Test wrong!"); ne delat tak, jestkii assert
        System.out.println("Program is working!");
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(),
                "Test passed");

    }

    @Test(groups = "smoke")
    public void studentRegFormPositiveTestValidateSoftAssert() {
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
        softAssert.assertFalse(new PracticeFormPage(getDriver()).validateModalMessageNegative(),
                "Test wrong!"); //ne delat tak -  jestkii assert
        System.out.println("Program is working!");
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(),
                "Test passed");

        softAssert.assertEquals(getDriver().findElement(By
                .xpath("//tbody/tr[2]/td[last()]")).getText(),
                student.getEmail(), "assert equals email");  //provertka sootvetstviya email
        softAssert.assertTrue(getDriver().findElement(By
                .xpath("//tbody/tr[10]/td[last()]")).getText()
                .contains(student.getState()), "assert contains state");

        softAssert.assertAll();

    }
}

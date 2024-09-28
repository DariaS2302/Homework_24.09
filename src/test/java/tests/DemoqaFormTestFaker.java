package tests;

import utils.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.DemoqaFormPage;


public class DemoqaFormTestFaker extends TestBase {

    private final DemoqaFormPage demoqaFormPage = new DemoqaFormPage();
    private final RandomUtils randomData = new RandomUtils();

    String firstName = randomData.FirstName(),
            lastName = randomData.LastName(),
            userEmail = randomData.UserEmail(),
            gender = randomData.Gender(),
            userNumber = randomData.UserNumber(),
            dayOfBirth = randomData.DayOfBirth(),
            monthOfBirth = randomData.MonthOfBirth(),
            yearOfBirth = randomData.YearOfBirth(),
            subjects = randomData.Subjects(),
            hobbies = randomData.Hobbies(),
            pictureName = "tst.jpg",
            address = randomData.Address(),
            state = randomData.State(),
            city = randomData.City(state);


    @Test
    void fullFormTest() {

        demoqaFormPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjects)
                .setHobby(hobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .clickSubmit();


        demoqaFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                .checkSuccessResult("Student Email", userEmail)
                .checkSuccessResult("Gender", gender)
                .checkSuccessResult("Mobile", userNumber)
                .checkSuccessResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkSuccessResult("Subjects", subjects)
                .checkSuccessResult("Hobbies", hobbies)
                .checkSuccessResult("Picture", pictureName)
                .checkSuccessResult("Address", address)
                .checkSuccessResult("State and City", state + " " + city);
    }
}
package tests;

import utils.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.DemoqaFormPage;


public class DemoqaFormTestFaker extends TestBase {

    private final DemoqaFormPage demoqaFormPage = new DemoqaFormPage();
    private final RandomUtils randomData = new RandomUtils();

    String firstName = randomData.firstName(),
            lastName = randomData.lastName(),
            userEmail = randomData.userEmail(),
            gender = randomData.gender(),
            userNumber = randomData.userNumber(),
            dayOfBirth = randomData.dayOfBirth(),
            monthOfBirth = randomData.monthOfBirth(),
            yearOfBirth = randomData.yearOfBirth(),
            subjects = randomData.subjects(),
            hobbies = randomData.hobbies(),
            pictureName = "tst.jpg",
            address = randomData.address(),
            state = randomData.state(),
            city = randomData.city(state);


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
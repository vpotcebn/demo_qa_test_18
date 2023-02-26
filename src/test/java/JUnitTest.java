import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class JUnitTest {
    @Test
     void fillFormTest(){
        Configuration.browserSize=("1920x1080");
        open ("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Under");
        $("[id=userEmail]").setValue("alexunder@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("7910281369");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue("1");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1990");
        $(".react-datepicker__month-container").$(byText("11")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[id=hobbiesWrapper]").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("11.png");
        $("[id=currentAddress]").setValue("125 Ariznona phd");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

       $(".modal-open").shouldHave(text("Thanks for submitting the form"));
       $(".modal-body").shouldHave(text("Alex Under"));
       $(".modal-body").shouldHave(text("alexunder@gmail.com"));
       $(".modal-body").shouldHave(text("Male"));
       $(".modal-body").shouldHave(text("7910281369"));
       $(".modal-body").shouldHave(text("11 February,1990"));
       $(".modal-body").shouldHave(text("Maths"));
       $(".modal-body").shouldHave(text("Reading"));
       $(".modal-body").shouldHave(text("125 Ariznona phd"));
       $(".modal-body").shouldHave(text("NCR Delhi"));
       $("#closeLargeModal").click();
    }
}
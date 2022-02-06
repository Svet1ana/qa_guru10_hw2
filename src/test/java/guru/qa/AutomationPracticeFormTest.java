    package guru.qa;

    import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
    import org.junit.jupiter.api.Order;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestMethodOrder;
    import com.codeborne.selenide.Condition;
    import com.codeborne.selenide.Configuration;
    import org.junit.jupiter.api.*;
    import java.io.File;
    import static com.codeborne.selenide.Condition.appear;
    import static com.codeborne.selenide.Condition.visible;
    import static com.codeborne.selenide.Selectors.byText;
    import static com.codeborne.selenide.Selenide.*;

    import org.junit.jupiter.api.BeforeAll;

    import static com.codeborne.selenide.Selenide.$;
    import static com.codeborne.selenide.Selenide.open;

    @TestMethodOrder(OrderAnnotation.class)
    public class AutomationPracticeFormTest {
        @BeforeAll
        static void openForm() {
            Configuration.browserSize = "1920x1880";
        }

        @Test
        void veryBigSuccessTest() {
            $("#firstName").setValue("FirstName");
            $("#lastName").setValue("LastName");
            $("#userEmail").setValue("test@test.com");
            $("[for='gender-radio-1']").click();
            $("#userNumber").setValue("0123456789");

            $("#dateOfBirthInput").click();
            $("[class*='month-select']").selectOptionByValue("2");
            $("[class*='year-select']").selectOptionByValue("1990");
            $("[class*='datepicker__day--028']").click();

            $("#subjectsInput").setValue("Maths").pressEnter();

            $("[for='hobbies-checkbox-1']").click();
            $("[for='hobbies-checkbox-2']").click();
            $("[for='hobbies-checkbox-3']").click();

            File file = new File("src/test/resources/qa.png");
            $("#uploadPicture").uploadFile(file);
            // TODO check upload file

            $("#currentAddress").setValue("Current Address");

            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#submit").scrollTo().click();

            $("#example-modal-sizes-title-lg")
                    .shouldBe(Condition.text(  "Thanks for submitting the form"));
            $("#example-modal-sizes-title-lg")
                    .shouldBe(Condition.text(  "Thanks for submitting the form"));
            $(byText("FirstName LastName")).should(appear);
            $(byText("test@test.com")).should(appear);
            $(byText("Female")).should(visible);
            $(byText("0123456789")).should(appear);
            $(byText("28 February,1990")).should(appear);
            $(byText("Maths")).should(appear);
            $(byText("Sports")).should(appear);
            $(byText("qa.png")).should(appear);
            $(byText("Current Address")).should(appear);
            $(byText("NCR Delhi")).should(appear);

        }

        @AfterAll
        static void afterAll(){closeWebDriver();}
    }

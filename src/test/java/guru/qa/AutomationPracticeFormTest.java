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



    @TestMethodOrder(OrderAnnotation.class)
    public class AutomationPracticeFormTest {
        @BeforeAll
        static void openForm() {
            Configuration.browserSize = "1920x1880";
            open("https://demoqa.com/automation-practice-form");
        }

        @Test
        @Order(1)
        void enterName() {
            $("#firstName").setValue("FirstName");
            $("#lastName").setValue("LastName");
            $("#firstName").shouldHave(Condition.value("FirstName"));
            $("#lastName").shouldHave(Condition.value("LastName"));
        }
        @Test
        @Order(2)
        void enterUserEmail() {
            $("#userEmail").setValue("test@test.com");
            $("#userEmail").shouldHave(Condition.value("test@test.com"));
        }
        @Test
        @Order(3)
        void chooseGender() {
            //$("#gender-radio-1").click();
            $("[for='gender-radio-1']").click();
            //TODO $("#gender-radio-1").shouldBe(Condition.checked);
        }
        @Test
        @Order(4)
        void enterNumber() {
            $("#userNumber").setValue("0123456789");
            $("#userNumber").shouldBe(Condition.value("0123456789"));
        }
        @Test
        @Order(5)
        void chooseDateOfBirth() {
            $("#dateOfBirthInput").click();
            $("[class*='month-select']").selectOptionByValue("2");
            $("[class*='year-select']").selectOptionByValue("1990");
            $("[class*='datepicker__day--028']").click();
            $("#dateOfBirthInput").shouldHave(Condition.value("28 Feb 1990"));
        }

        @Test
        @Order(6)
        void enterSubject() {
            $("#subjectsInput").setValue("Maths").pressEnter();
            // TODO $("#subjectsInput").shouldHave(Condition.text("Maths"));
        }
        @Test
        @Order(7)
        void markedHobbies() {
            $("[for='hobbies-checkbox-1']").click();
            //TODO $("[for='hobbies-checkbox-1']").shouldBe();
        }
        @Test
        @Order(8)
        void fileUpload() {
            File file = new File("src/test/resources/qa.png");

            $("#uploadPicture").uploadFile(file);
            // TODO check upload file
        }
        @Test
        @Order(9)
        void enterAddress() {
            $("#currentAddress").setValue("Current Address");
            $("#currentAddress").shouldHave(Condition.value("Current Address"));
        }
        @Test
        @Order(10)
        void enterStateCity() {
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#state").shouldBe(Condition.text("NCR"));
            $("#city").shouldBe(Condition.text(  "Delhi"));
        }

        @Test
        @Order(11)
        void clickSubmitButton() {

            $("#submit").scrollTo().click();
            $("#example-modal-sizes-title-lg")
                    .shouldBe(Condition.text(  "Thanks for submitting the form"));
        }

        @Test
        @Order(12)
        void checkResult(){
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

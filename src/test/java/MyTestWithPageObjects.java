import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyTestWithPageObjects {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    private final String name = "Ann Shilova";
    private final String filePath = "C:/Users/User/IdeaProjects/myTest/src/test/java/photo.png";

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    void fillFirstName() {

        RegistrationPage registrationPage = new RegistrationPage(page);
        registrationPage.openPage().setNameAndGender("Ann", "Shilova");


        page.fill("input#userEmail", "example@mail.ru");
        page.click("label[for='gender-radio-2']");
        page.fill("input#userNumber", "8123456789");

        page.click("#dateOfBirthInput");
        page.selectOption("select.react-datepicker__month-select", "10");
        page.selectOption("select.react-datepicker__year-select", "1995");
        page.click(".react-datepicker__day--026:not(.react-datepicker__day--outside-month)");

        page.click("#subjectsInput");
        page.fill("#subjectsInput", "St. Petesburg");
        page.click("label[for='hobbies-checkbox-3']");
        page.setInputFiles("#uploadPicture", Paths.get(filePath));
        page.fill("#currentAddress", "St. Petesburg");
        page.click("#state");
        page.click("div[id^='react-select-3-option'] >> text=NCR");
        page.click("#city");
        // div[id^='react-select-3-option'] означает: div, чей id начинается с react-select-3-option
        page.click("div[id^='react-select-4-option'] >> text=Delhi");

        page.click("button#submit ");

        page.waitForTimeout(5000); // Ждёт 5 секунд (5000 миллисекунд)

        assertTrue(page.textContent("body").contains(name));
    }
    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }
}


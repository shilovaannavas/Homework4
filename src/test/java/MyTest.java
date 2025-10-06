import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.*;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class MyTest {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    void fillFirstName() {
//
//        // Путь к файлу
//        String filePath = "C:/Users/User/IdeaProjects/myTest/src/test/java/photo.png";
//
//
//        page.navigate("https://demoqa.com/automation-practice-form",
//                new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
//
//        page.fill("input#firstName", "Ann");
//        page.fill("input#lastName", "Shilova");
//        page.fill("input#userEmail", "example@mail.ru");
//        page.click("label[for='gender-radio-2']");
//        page.fill("input#userNumber", "8123456789");
//        page.fill("input#dateOfBirthInput", "26 Nov 1995");
//        page.click("#subjectsInput");
//        page.fill("#subjectsInput", "St. Petesburg");
//        page.click("label[for='hobbies-checkbox-3']");
//        page.setInputFiles("#uploadPicture", Paths.get(filePath));
//        page.fill("#currentAddress", "St. Petesburg");
//        page.click("#state");
//        page.click("div[id^='react-select-3-option'] >> text=NCR");
//        page.click("#city");
//        // div[id^='react-select-3-option'] означает: div, чей id начинается с react-select-3-option
//        page.click("div[id^='react-select-4-option'] >> text=Delhi");
//
//        page.click("button#submit ");
//
//        page.waitForTimeout(5000); // Ждёт 5 секунд (5000 миллисекунд)
//
//        assertTrue(page.textContent("body").contains("Ann Shilova"));
//    }

        page.navigate("https://github.com/selenide/selenide");

        page.waitForNavigation(() -> {
            page.click("a#wiki-tab");
        });

        try {
            Thread.sleep(3000); // Пауза 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(page.textContent("body").contains("Soft assertions"));


        page.waitForNavigation(() -> {
            page.click("a:has-text('Soft assertions')");
        });

        try {
            Thread.sleep(3000); // Пауза 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(page.textContent("body").contains("Using JUnit5 extend test class"));

    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }
}

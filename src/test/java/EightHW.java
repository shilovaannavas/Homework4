import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.*;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EightHW {

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
    void github() {

        page.navigate("https://github.com/");
        // Наведение на <li> с текстом "Solutions"
        page.hover("li:has-text('Solutions')");


        page.waitForNavigation(() -> {
            page.click("a:has-text('Enterprises')");
        });

        try {
            Thread.sleep(3000); // Пауза 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(page.textContent("body").contains("The enterprise-ready platform"));

        page.navigate("https://the-internet.herokuapp.com/drag_and_drop");

        Locator source = page.locator("#column-a");
        Locator target = page.locator("#column-b");

        source.dragTo(target);

        try {
            Thread.sleep(3000); // Пауза 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }
}

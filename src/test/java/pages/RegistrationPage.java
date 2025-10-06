package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import pages.components.CalendarComponent;

public class RegistrationPage {

    private final Page page;
    private final CalendarComponent calendarComponent;

    public RegistrationPage(Page page) {
        this.page = page;
        this.calendarComponent = new CalendarComponent(page);
    }

    public RegistrationPage openPage() {
        page.navigate("https://demoqa.com/automation-practice-form",
                new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        return this;
    }

    public RegistrationPage setNameAndGender(String firstName, String lastName) {
        page.fill("input#firstName", firstName);
        page.fill("input#lastName", lastName);
        page.click("label[for='gender-radio-2']");
        return this;
    }

}

package pages.components;

import com.microsoft.playwright.Page;

public class CalendarComponent {
    private final Page page;

    public CalendarComponent(Page page) {
        this.page = page;
    }

    public void setDate(String year, String month, String day) {
        page.selectOption("select.react-datepicker__month-select", month);
        page.selectOption("select.react-datepicker__year-select", year);
        page.click(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)");
    }
}

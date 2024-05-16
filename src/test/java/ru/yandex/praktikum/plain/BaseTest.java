package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;

public class BaseTest {
    private static final String BROWSER = "chrome";
    public WebDriver webDriver;
    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }

}

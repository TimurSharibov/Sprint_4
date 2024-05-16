package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String lastname;
    private final String address;
    private final String subwayTitle;
    private final String phone;
    private final String date;
    private final String comment;
    private final String color;
    private final String location;

    public OrderTest(String name, String lastname, String address, String subwayTitle, String phone, String date, String comment, String color, String location) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.subwayTitle = subwayTitle;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.color = color;
        this.location = location;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Тим", "Бони", "Масква", "Арбатская", "89887775555", "31.12.2024", "Прошу привезти вовремя",
                        "чёрный жемчуг", "Home"},
                {"Иван", "Ваня", "Москва", "Ясенево", "89998887777", "05.05.2024", "Привезите вечером",
                        "серая безысходность", "Header"}
        };
    }



    @Test
    public void orderNotFound() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("321654987564");
        mainPage.clickGoButton();
        mainPage.notFoundImageIsDisplayed();

        assertTrue(mainPage.notFoundImageIsDisplayed());
    }

    @Test
    public void createOrder() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.clickCreateOrder(location);

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo(name, lastname, address, subwayTitle, phone);
        orderPage.clickNextButton();
        orderPage.fillRentInfo(date, comment, color);
        orderPage.clickCreateOrderButton();
        orderPage.clickYesButton();

        orderPage.orderIssuedIsDisplayed();
    }


}

package ru.yandex.praktikum.page;

import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver webDriver;
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButtonLocator = By.xpath("//button[text()='Далее']");

    private final By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentInputLocator = By.xpath("//div[text()='* Срок аренды']");
    private final By rentInputPeriodLocator = By.xpath("//div[text()='пятеро суток']");
    private final By commentInputLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By createOrderButtonLocator = By.xpath("//button[text()='Заказать' and @class ='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By yesButtonLocator = By.xpath("//button[text()='Да']");
    private final By orderIssuedLocator = By.xpath("//div[text()='Заказ оформлен']");

    private final String stationMenuItemLocator = "//div[text()='%s']";
    private final String colorMenuItemLocator = "//label[text()='%s']";

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillCustomerInfo(String name, String lastname, String address, String subwayTitle, String phone) {

        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);

        WebElement lastnameInput = webDriver.findElement(lastNameInputLocator);
        lastnameInput.sendKeys(lastname);

        WebElement addressInput = webDriver.findElement(addressInputLocator);
        addressInput.sendKeys(address);

        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.click();


        WebElement arbatskayaStationMenu = webDriver
                .findElement(By.xpath(String.format(stationMenuItemLocator, subwayTitle)));

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", arbatskayaStationMenu);
        arbatskayaStationMenu.click();

        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phone);


    }

    public void clickNextButton() {
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();

    }

    public void fillRentInfo(String date, String comment, String color) {
        WebElement dateInput = webDriver.findElement(dateInputLocator);
        dateInput.sendKeys(date, Keys.ENTER);

        WebElement rentInput = webDriver.findElement(rentInputLocator);
        rentInput.click();

        WebElement returnPeriodInput = webDriver.findElement(rentInputPeriodLocator);
        returnPeriodInput.click();


        WebElement colorChange = webDriver
                .findElement(By.xpath(String.format(colorMenuItemLocator, color)));
        colorChange.click();

        WebElement commentInput = webDriver.findElement(commentInputLocator);
        commentInput.sendKeys(comment);

    }

    public void clickCreateOrderButton() {
        WebElement createOrderButton = webDriver.findElement(createOrderButtonLocator);
        createOrderButton.click();

    }

    public void clickYesButton() {
        WebElement createOrderButton = webDriver.findElement(yesButtonLocator);
        createOrderButton.click();

    }

    public void orderIssuedIsDisplayed() {
        WebElement orderIssued = webDriver.findElement(orderIssuedLocator);
        orderIssued.isDisplayed();
    }
}
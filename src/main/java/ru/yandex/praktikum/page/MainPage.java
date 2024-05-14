package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPage {
    private final WebDriver webDriver;
    private final By orderStatusLocator = By.xpath("//button[text()='Статус заказа']");
    private final By orderNumberInputLocator = By.xpath("//input[@placeholder='Введите номер заказа']");
    private final By goButtonLocator = By.xpath("//button[text()='Go!']");
    private final By notFoundImageLocator = By.xpath("//img[@alt='Not found']");
    private final String createOrderButtonLocator = "//div[contains(@class,'%s')]/button[text()='Заказать']";
    private final String questionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id,'accordion__panel')][.='%s']";
    private final By cookiesButtonLocator = By.id("rcc-confirm-button");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderStatusButton() {
        WebElement orderStatusButton = webDriver.findElement(orderStatusLocator);
        orderStatusButton.click();
    }

    public void enterOrderNumber(String orderNumber) {
        WebElement orderInput = webDriver.findElement(orderNumberInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderInput));
        orderInput.sendKeys(orderNumber);
    }

    public void clickGoButton() {
        WebElement goButton = webDriver.findElement(goButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
    }

    public boolean notFoundImageIsDisplayed() {
        //return webDriver.findElement(notFoundImageLocator).isDisplayed();
        WebElement notFoundImg = webDriver.findElement(notFoundImageLocator);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(notFoundImg));
        return notFoundImg.isDisplayed();
    }

    public void clickCreateOrder(String location) {
        WebElement element = webDriver.findElement(By.xpath(String.format(createOrderButtonLocator, location)));
        element.click();
    }

    public void closeCookiesWindow() {
        webDriver.findElement(cookiesButtonLocator).click();
    }

    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }
}
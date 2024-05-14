package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {
//   public static WebDriver getWebDriver(String browserType) {
//       if (browserType.equalsIgnoreCase("chrome")) {
//           WebDriverManager.chromedriver().setup();
//           return new ChromeDriver();
//
////       } else if(browserType.equalsIgnoreCase("opera")){
////               WebDriverManager.operadriver().setup();
////               return new OperaDriver();
////
//       } else  {
//           WebDriverManager.firefoxdriver().setup();
//           return new FirefoxDriver();
//       }
//   }

    public static WebDriver getWebDriver(String browserType) {
        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "opera":
                //WebDriverManager.operadriver().setup();
                return null;
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}

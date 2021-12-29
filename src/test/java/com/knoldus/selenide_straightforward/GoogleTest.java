package com.knoldus.selenide_straightforward;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

  /*Selenium using Chrome Driver :

    System.setProperty("webdriver.chrome.driver",
          "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("https://knoldus.com");*/


    //==================Selenide using Chrome Driver :====================//

          /*System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
          System.setProperty("selenide.browser", "Chrome");
          open(https://knoldus.com); //this opens a Chrome browser with the provided url.*/



  //=============For Firefox Browser. its just one line of code.==============//

  /*open(https://knoldus.com); this opens a Firefox browser with the provided url.*/



  @Rule
  public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

  @Test
  public void search_selenide_in_google() {
    open("https://duckduckgo.com");
    $(By.name("q")).val("Knoldus").pressEnter();
    $$(".results .result").shouldHave(sizeGreaterThan(1));
    $(".results .result").shouldBe(visible).shouldHave(
        text("Knoldus Inc. - Product Engineering Done Right"),
        text("knoldus.com"));
  }
}

package com.knoldus.POM_Classic_Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleTest {
  private WebDriver driver;

  @Before
  public void setUp() {
    String currentBrowser = System.getProperty("selenide.browser", "firefox");
    if ("chrome".equals(currentBrowser)) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if ("firefox".equals(currentBrowser)) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else if ("safari".equals(currentBrowser)) {
      driver = new SafariDriver();
    } else if ("edge".equals(currentBrowser)) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    } else if ("ie".equals(currentBrowser)) {
      WebDriverManager.iedriver().setup();
      driver = new InternetExplorerDriver();
    }
  }

  // Reference for Selenide

  /*$("li"); //$ for element
  $$("li"); //$$ for more than one element
  $$("#menu");*/

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void userCanSearch() throws IOException {
    FileReader reader=new FileReader("/home/saumya/Selenide-Project/src/data.properties");
    Properties p=new Properties();
    p.load(reader);
    driver.get("https://www.duckduckgo.com");
    GooglePage page = PageFactory.initElements(driver, GooglePage.class);
    SearchResultsPage results = page.searchFor(p.getProperty("searchValue"));
    assertThat(results.getResults().get(0).getText(), containsString("Knoldus Inc. - Product Engineering Done Right"));
  }

  //Reference For Selenium

  /*driver.findElement(By.tagName("li"));
  driver.findElements(By.cssSelector("li"));
  driver.findElements(By.id("menu"));*/
}

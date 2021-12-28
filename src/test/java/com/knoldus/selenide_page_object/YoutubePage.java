package com.knoldus.selenide_page_object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YoutubePage {
  public void InputOption(){
    $(By.xpath("//input[@id='search']")).sendKeys("Knoldus");
  }
  public void SearchOption() {
    $(By.xpath("//button[@id='search-icon-legacy']//child::yt-icon")).click();

  }
}

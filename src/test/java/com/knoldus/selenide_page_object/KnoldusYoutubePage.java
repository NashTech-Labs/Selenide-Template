package com.knoldus.selenide_page_object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class KnoldusYoutubePage {
  public void SearchOption() {
    $(By.xpath("//yt-formatted-string[text()='Knoldus - Annual Day 2020']")).click();
  }
  public void SubscribeOption() {
    $(By.xpath("//tp-yt-paper-button[@aria-label='Subscribe']")).click();
  }
}
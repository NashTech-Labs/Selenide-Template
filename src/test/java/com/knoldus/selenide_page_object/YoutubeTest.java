package com.knoldus.selenide_page_object;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class YoutubeTest {
  @Test
  public void userCanSearch() throws InterruptedException {
    //open the youtube page on browser
    open("https://www.youtube.com/");
    YoutubePage page = new YoutubePage();
    //pass the search value in browser
    page.InputOption();
    Thread.sleep(2000);
    //clicks on search button to search
    page.SearchOption();
    Thread.sleep(1000);


    KnoldusYoutubePage results = new KnoldusYoutubePage();
    Thread.sleep(2000);
    //Search some video from the knoldus playlist and play
    results.SearchOption();
    Thread.sleep(2000);
    results.SubscribeOption();
    Thread.sleep(4000);

  }
}

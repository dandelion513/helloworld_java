package Tests;

import java.util.*;
import java.util.concurrent.TimeUnit;

import Helpers.Core;
import Pages.CurrentPage;
import Pages.LeftPanel;
import Pages.MainPage;
import Pages.TopPanel;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WikiTest extends Core{
  //private WebDriver driver;
  //private WebDriverWait wait;

//  @Test
//  public void testWiki1() throws Exception {
//      //go to some other page:
////      CurrentPage.goToRandomPage();
////      //then click target element "mosaic ball"
////      CurrentPage.clickMosaicBall();
////      //check that current page is the main page "Википедия — свободная энциклопедия"
////      MainPage.checkMainPageTitle("Википедия — свободная энциклопедия");
//  }
//
// @Test
//  public void testWiki2() throws Exception {
//     //input text into search field
//      TopPanel.inputSearchInfo("а");
//     //check that number of predicative suggestions is the same as our parameter
//      TopPanel.compareSuggestionsNumberWith(10);
//  }
//
//  @Test
//  public void testWiki3() throws Exception {
//      //input text into search field
//      TopPanel.inputSearchInfo("аур");
//      //check each suggestion
//      TopPanel.checkSuggestionsList(Arrays.asList("Аур", "Аура", "Аурих", "Аурано", "Ауриго", "Ауро", "Ауреа"));
//  }

//  @Test
//  public void testWiki4() throws Exception {
//      LeftPanel.getParticipationList();
//      boolean check = LeftPanel.checkParticipationList(Arrays.asList("Сообщить об ошибке", "Портал сообщества", "Форум", "Свежие правки", "Новые страницы", "Справка", "Пожертвовать"));
//      Assert.assertTrue(check);
//  }


//  @Test
//  public void testWiki5() throws Exception {
//      String pageName = MainPage.getFavoritePageLinkName();
//      MainPage.goToFavoritePage();
//      CurrentPage.checkPageTitle(pageName);
//  }
}

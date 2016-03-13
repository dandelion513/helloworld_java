package Pages;

import Helpers.Core;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tatyana on 28.02.2016.
 */
public class CurrentPage{

    private WebDriver driver;
    private static WebDriverWait wait;

    public CurrentPage()
    {
        this.driver = Core.getDriver();
        this.wait = Core.getWait();
    }


    @Given("^on Current Page I click Random Page link$")
    public void onCurrentPageIClickRandomPageLink() throws Throwable {
      WebElement randomPageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'Посмотреть случайно выбранную страницу')]")));
      randomPageLink.click();
    }

    @When("^on Current Page I click Mosaic Ball element$")
    public void onCurrentPageIClickMosaicBallElement() throws Throwable {
        clickMosaicBall();
    }

    public static void clickMosaicBall(){
        //locate mosaic ball
        WebElement mosaicBallWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Перейти на заглавную страницу']")));
        //click mosaic ball
        mosaicBallWebElement.click();
    }

    @Then("^on Current Page I see correct Favorite Page title$")
    public void onCurrentPageISeeCorrectFavoritePageTitle() throws Throwable {
        WebElement currentPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String title = currentPageTitle.getText();
        String linkName = MainPage.getFavoritePageLinkName();
        if (!title.equals(linkName))
        {
            throw new PendingException("Favorite page header is not correct");
        }
    }

    @Given("^I am on the Main Page$")
    public void iAmOnTheMainPage() throws Throwable {
         clickMosaicBall();
    }
}

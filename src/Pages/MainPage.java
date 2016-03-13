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
 * Created by Tatyana on 02.03.2016.
 */
public class MainPage{

    private WebDriver driver;
    private static WebDriverWait wait;
    private static String favoritePageLinkName;

    public MainPage()
    {
        this.driver = Core.getDriver();
        this.wait = Core.getWait();
    }

    //returns valid text of favorite page link only after onMainPageISeeFavoritePageLink() call
    public static String getFavoritePageLinkName() {
        return favoritePageLinkName;
    }

    @Then("^on Main Page I see that the Main Page title is \"([^\"]*)\"$")
    public void onMainPageISeeMainPageTitle(String arg0) throws Throwable {
        String title = driver.getTitle();
        if (!title.equals(arg0))
        {
            throw new PendingException("Main page title is incorrect: \"" + title + "\" is not the same as \"" + arg0 + "\"" );
        }
    }

    @When("^on Main Page I see Favorite Page link$")
    public void onMainPageISeeFavoritePageLink() throws Throwable {
        WebElement link = findFavoritePageLink();
        favoritePageLinkName = findFavoritePageLinkName();
    }

    @When("^on Main Page I click Favorite Page link$")
    public void onMainPageIClickFavoritePageLink() throws Throwable {
        WebElement link = findFavoritePageLink();
        link.click();
    }

    public static WebElement findFavoritePageLink(){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='mf-tfa']//a"))).get(1);
    }

    private static String findFavoritePageLinkName(){
        WebElement link = findFavoritePageLink();
        return link.getAttribute("title");
    }
}

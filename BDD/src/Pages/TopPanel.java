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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatyana on 28.02.2016.
 */
public class TopPanel{


    private WebDriver driver;
    private static WebDriverWait wait;

    public TopPanel()
    {
        this.driver = Core.getDriver();
        this.wait = Core.getWait();
    }

    @When("^on Top Panel I input \"([^\"]*)\" to the Search field$")
    public void onTopPanelIInputToTheSearchField(String arg0) throws Throwable {
        WebElement searchWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']")));
        searchWebElement.sendKeys(arg0);
    }

    @Then("^on Top Panel I see \"([^\"]*)\" predicative suggestions$")
    public void onTopPanelISeePredicativeSuggestions(String arg0) throws Throwable {
        List<WebElement> listOfSuggestions = getSuggestionsList();
        int size = listOfSuggestions.size();
        int check = Integer.valueOf(arg0);
        if ( size!= check)
        {
            throw new PendingException("Number of suggestions is not equal to " + arg0);
        }

    }

    private static List<WebElement> getSuggestionsList(){
        WebElement searchSuggestionsWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='suggestions-results']")));
        return searchSuggestionsWebElement.findElements(By.className("mw-searchSuggest-link"));
    }

    @Then("^on Top Panel I see at least the following predicative suggestions: (.*)$")
    public void onTopPanelISeeAtLeastTheFollowingPredicativeSuggestions(List<String> entries) throws Throwable {
        List<WebElement> listOfSuggestions = getSuggestionsList();
        int counter = 0;
        List<String> absentList = new ArrayList<String>();
        for (String s : entries )
        {
            int check = counter;
            for ( WebElement e : listOfSuggestions )
            {
                String title = e.getAttribute("title");
                if ( title.equals(s))
                {
                    counter++;
                    break;
                }
            }
            if ( check == counter )
            {
                absentList.add(s);
            }
        }
        int count = absentList.size();
        if (count!=0)
        {
           throw new PendingException("Some of the suggestions are missing: " + absentList.toString());

        }

    }

}

package Pages;

import Helpers.Core;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
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
public class LeftPanel{


    private WebDriver driver;
    private static WebDriverWait wait;

    public LeftPanel()
    {
        this.driver = Core.getDriver();
        this.wait = Core.getWait();
    }


    @When("^on Left Panel I see Participation List: (.*)$")
    public void onLeftPanelISeeParticipantsList(List<String> participationCheckList) throws Throwable {
        List<WebElement> participationList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'p-participation')]//li//a")));
        int participationListSize = participationList.size();
        int checkListSize = participationCheckList.size();
        if( participationListSize != checkListSize)
        {
            throw new PendingException("Number of entries is not equal to number of entries in check list");
        }

        int counter = 0;
        List<String> absentPartList = new ArrayList<String>();
        //compare each predicate from check list with each result in the suggestion list
        for (String i : participationCheckList) {
            int check = counter;
            for (WebElement j : participationList) {
                String text = j.getAttribute("text");
                if (text.equals(i)) {
                    counter++;
                    break;
                }
            }
            if (check == counter) {
                absentPartList.add(i);
            }
        }
        int count = absentPartList.size();
        if (count!=0)
        {
            throw new PendingException("Some of the suggestions are missing: " + absentPartList.toString());

        }
    }


}
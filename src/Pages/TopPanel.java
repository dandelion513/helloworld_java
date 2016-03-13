package Pages;

import Helpers.Core;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatyana on 28.02.2016.
 */
public class TopPanel extends Core{
    public static void inputSearchInfo(String input){
        WebElement searchWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']")));
        searchWebElement.sendKeys(input);
    }
    private static List<WebElement> getSuggestionsList(){
        WebElement searchSuggestionsWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='suggestions-results']")));
        List<WebElement> listOfSuggestions = searchSuggestionsWebElement.findElements(By.className("mw-searchSuggest-link"));
        return listOfSuggestions;
    }

    //compareSuggestionsNumberWith returns true if suggestions list size is less or equal to parameter
    public static boolean compareSuggestionsNumberWith(int number){
        List<WebElement> listOfSuggestions = getSuggestionsList();
        int size = listOfSuggestions.size();
        return size <= number;
    }

    public static boolean checkSuggestionsList(List<String> listOfTemplates){
        List<WebElement> listOfSuggestions = getSuggestionsList();

        int counter = 0;
        List<String> absentList = new ArrayList<String>();
        for (String s : listOfTemplates )
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
        System.out.println("Number of matches: " + counter);
        System.out.println("Absent: " + absentList.toString());
        return counter == listOfTemplates.size();

    }
}

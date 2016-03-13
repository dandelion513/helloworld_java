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
public class LeftPanel extends Core {

    public static List<WebElement> getParticipationList() {
        List<WebElement> participationList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'p-participation')]//li//a")));
        return participationList;
    }

    public static boolean checkParticipationListSize(List<String> participationCheckList) {
        List<WebElement> participationList = getParticipationList();
        int participationListSize = participationList.size();
        //System.out.println("The number of entries under Participation: " + participationListSize);
        return participationListSize == participationCheckList.size();
    }

    public static boolean checkParticipationList(List<String> participationCheckList) {
        List<WebElement> participationList = getParticipationList();
        checkParticipationListSize(participationCheckList);
        int participationCheckListSize = participationCheckList.size();
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

        System.out.println("The number of matches: " + counter + " from " + participationCheckListSize );
        System.out.println("Absent: " + absentPartList.toString());
        return counter == participationCheckList.size();
    }
}
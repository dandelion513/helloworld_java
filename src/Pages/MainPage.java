package Pages;

import Helpers.Core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Alexey on 02.03.2016.
 */
public class MainPage extends Core {
    public static WebElement findFavoritePageLink(){
        WebElement favoritePageLink = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='mf-tfa']//a"))).get(1);
        return favoritePageLink;
    }

    public static void goToFavoritePage(){
        WebElement link = findFavoritePageLink();
        link.click();
    }

    public static String getFavoritePageLinkName(){
        WebElement link = findFavoritePageLink();
        String linkName = link.getAttribute("title");
        return linkName;
    }

    public static String getMainPageTitle(){
        String title = driver.getTitle();
        return title;
    }


    public static boolean checkMainPageTitle(String title){
        String current = getMainPageTitle();
        return current.equals(title);
    }

}

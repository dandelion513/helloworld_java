package Pages;

import Helpers.Core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Tatyana on 28.02.2016.
 */
public class CurrentPage extends Core{

    public static void clickMosaicBall(){
        //locate mosaic ball
        WebElement mosaicBallWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Перейти на заглавную страницу']")));
        //click mosaic ball
        mosaicBallWebElement.click();
    }
    public static String getTitle(){
        //locate first heading
        WebElement currentPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //get first heading title
        String title = currentPageTitle.getText();
        return title;
    }


    public static boolean checkPageTitle(String title){
        String current = getTitle();
        return current.equals(title);
    }

    public static WebElement findRandomPageLink(){
        //locate random page link
        WebElement randomPageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'Посмотреть случайно выбранную страницу')]")));
        return randomPageLink;
    }

    public static void goToRandomPage(){
        WebElement randomLink = findRandomPageLink();
        randomLink.click();
    }
}

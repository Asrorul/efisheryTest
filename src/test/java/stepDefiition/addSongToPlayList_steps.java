package stepDefiition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AddSongToPlaylistObjectPage;

public class addSongToPlayList_steps {

    String url= "https://music.youtube.com/";
    AddSongToPlaylistObjectPage po= new AddSongToPlaylistObjectPage();

    @Given("open youtube music without login")
    public void userGoToHttpsPage() {
        po.userGoToHttpsPage(url);
    }

    @And("search a song {string}")
    public void searchASong(String s) {
        po.driver.findElement(By.xpath(po.searchBtn)).click();
        po.driver.findElement(By.xpath(po.inputSearchField)).sendKeys(s);
        po.driver.findElement(By.xpath(po.inputSearchField)).sendKeys(Keys.ENTER);
    }

    @When("add to playlist from the search result")
    public void addToPlaylistFromTheSearchResult() {
        Actions builder = new Actions(po.driver);
        builder.moveToElement(po.driver.findElement(By.xpath(po.threeDots))).build().perform();
        po.driver.findElement(By.xpath(po.threeDots)).click();
        po.driver.findElement(By.xpath(po.addToPlatList)).click();
    }

    @Then("login pop up would be shown")
    public void loginPopUpWouldBeShown() {
        Assert.assertTrue(po.isElementPresent(By.xpath(po.popUpLogin)));
        Assert.assertTrue(po.isElementPresent(By.xpath(po.signInButton)));
        po.closeBrowser();
    }

//    @Then("close browser")
//    public void closeBrowser() {
//        po.closeBrowser();
//    }


}

package stepDefiition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class addToPlayList_steps {
    WebDriver driver;
    WebDriverWait wait;
    String url= "https://music.youtube.com/";

    String searchBtn="//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-search-box/div/div[1]/tp-yt-paper-icon-button[1]";
    String inputSearchField="//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-search-box/div/div/input";
    String threeDots="//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer/ytmusic-menu-renderer/tp-yt-paper-icon-button/tp-yt-iron-icon";
    String addToPlatList="//*[@id=\"items\"]/ytmusic-menu-navigation-item-renderer[2]";
    String popUpLogin="//*[@id=\"contentWrapper\"]/ytmusic-modal-with-title-and-button-renderer";
    String signInButton="//*[@id=\"contentWrapper\"]/ytmusic-modal-with-title-and-button-renderer/div/yt-button-renderer";
    @Given("open youtube music without login")
    public void userGoToHttpsPage() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get(url);
    }

    @And("search a song")
    public void searchASong() {
        driver.findElement(By.xpath(searchBtn)).click();
        driver.findElement(By.xpath(inputSearchField)).sendKeys("hati hati di jalan");
        driver.findElement(By.xpath(inputSearchField)).sendKeys(Keys.ENTER);

    }

    @When("add to playlist from the search result")
    public void addToPlaylistFromTheSearchResult() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(threeDots))).build().perform();
        builder.moveToElement(driver.findElement(By.xpath(threeDots))).build().perform();
        driver.findElement(By.xpath(threeDots)).click();
        driver.findElement(By.xpath(addToPlatList)).click();
    }

    @Then("login pop up would be shown")
    public void loginPopUpWouldBeShown() {
        Assert.assertTrue(isElementPresent(By.xpath(popUpLogin)));
        Assert.assertTrue(isElementPresent(By.xpath(signInButton)));

    }


    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}

package pages.resources;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class fileUtils {

    public String loginButton= "//*[@id=\"right-content\"]/a";
    public String emailFiedl="//*[@id=\"identifierId\"]";
    public String emailNextBtn="//*[@id=\"identifierNext\"]/div/button";
    public String passwordField="//*[@id=\"password\"]/div[1]/div/div[1]/input";
    public String passwordNextBtn="//*[@id=\"passwordNext\"]/div/button";


    public WebDriver driver;
    WebDriverWait wait;
    String url= "https://music.youtube.com/";

    public void userGoToHttpsPage(String url) {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get(url);
    }

    public void OpenYTMusicAndlogin(String username, String password) {
        userGoToHttpsPage(url);
        driver.findElement(By.xpath(loginButton)).click();
        driver.findElement(By.xpath(emailFiedl)).isDisplayed();
        driver.findElement(By.xpath(emailFiedl)).sendKeys(username);
        driver.findElement(By.xpath(emailNextBtn)).click();
        driver.findElement(By.xpath(passwordField));
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
        driver.findElement(By.xpath(passwordNextBtn)).click();
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

//    @Then("close browser")
    public void closeBrowser() {
        driver.close();
        driver.quit();
//        throw new io.cucumber.java.PendingException();
    }
}

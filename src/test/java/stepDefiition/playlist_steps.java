package stepDefiition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class playlist_steps {
    WebDriver driver;
    String url= "https://music.youtube.com/";
    String loginButton= "//*[@id=\"right-content\"]/a";
    String emailFiedl="//*[@id=\"identifierId\"]";
    String emailNextBtn="//*[@id=\"identifierNext\"]/div/button";
    String passwordField="//*[@id=\"password\"]/div[1]/div/div[1]/input";
    String passwordNextBtn="//*[@id=\"passwordNext\"]/div/button";
    String libraryMenu="//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-pivot-bar-renderer/ytmusic-pivot-bar-item-renderer[3]/yt-formatted-string";
    //*[@id="layout"]/ytmusic-nav-bar/div[2]/ytmusic-pivot-bar-renderer/ytmusic-pivot-bar-item-renderer[3]/yt-formatted-string
    String menuPlaylist= "//*[@id=\"chips\"]/ytmusic-chip-cloud-chip-renderer[1]";
    String createNewPlaylistBtn="//*[@id=\"items\"]/ytmusic-two-row-item-renderer[1]/a[@title=\"New playlist\"]";
    String titlePLaylistField="//*[@id=\"input-2\"]/input";
//    String titlePLaylistField= "//*[@id=\"title-input\"]";
    String descPlaylistField="//*[@id=\"textarea\"]";
    String dropdownVisibility="//*[@id=\"container\"]/div[2]/span[2]/tp-yt-iron-icon";
    String visiblityPrvt="//*[@id=\"dropdown-items\"]/ytmusic-dropdown-item-renderer[3]/tp-yt-paper-item";
    String visibilityUnlisted="//*[@id=\"dropdown-items\"]/ytmusic-dropdown-item-renderer[2]";
    String visibilityPublic="//*[@id=\"dropdown-items\"]/ytmusic-dropdown-item-renderer[1]";
    String btnCretePlaylist= "//*[@id=\"general-pane\"]/div[2]/yt-button-renderer[2]";
    String btnSave="//*[@id=\"general-pane\"]/div[2]/tp-yt-paper-button[2]";
    //*[@id="button"]
//    *[@id="general-pane"]/div[2]/yt-button-renderer[2]

    String TitlePlaylist= "//*[@id=\"header\"]/ytmusic-editable-playlist-detail-header-renderer/ytmusic-detail-header-renderer/div/div[2]/h2/yt-formatted-string";
    //*[@id="header"]/ytmusic-editable-playlist-detail-header-renderer/ytmusic-detail-header-renderer/div/div[2]/h2/yt-formatted-strin
    String DescPlaylist="//*[@id=\"description\"]";

    String ErrorTitleField="//*[@id=\"a11yWrapper\"]";

    String addMusicToPlaylist="//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer[1]/div[3]/yt-button-renderer/a/yt-icon-button/button";
                               //*[@id="contents"]/ytmusic-responsive-list-item-renderer[1]
                               //*[@id="contents"]/ytmusic-responsive-list-item-renderer[1]/div[3]/yt-button-renderer
                               //*[@id="contents"]/ytmusic-responsive-list-item-renderer[1]/div[3]/yt-button-renderer
    String itemOnPlaylist="//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer";
    String titleOnListLibrary= "//*[@id=\"items\"]/ytmusic-two-row-item-renderer[2]/div[1]/div/yt-formatted-string/a";
    String editPlaylistBtn= "//*[@id=\"top-level-buttons\"]/yt-button-renderer/a/tp-yt-paper-button";

    String email= "efisheryasror@gmail.com";
    String password="23571113";
    String playlistName;
    String playlistDesc;
    WebDriverWait wait;
    String playListUrl;

    String publicPlaylistTitle="//*[@id=\"header\"]/ytmusic-detail-header-renderer/div/div[2]/h2/yt-formatted-string";

    @Given("User go to {string}")
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

    @Given("User on page library with login account")
    public void userOnPageLibraryWithLoginAccount() throws InterruptedException {
        OpenYTMusicAndlogin(email,password);
        driver.findElement(By.xpath(libraryMenu)).click();
        driver.findElement(By.xpath(menuPlaylist)).isDisplayed();
        driver.findElement(By.xpath(menuPlaylist)).click();
    }

    @When("user create new playlist with valid data with visibility private")
    public void createPrivatePlayList() {
        playlistName= randomString();
        playlistDesc="";
        userCreateNewPlaylistWithValidData(visiblityPrvt,playlistName,playlistDesc);
    }

    @When("user create new playlist with valid data with visibility unlisted")
    public void userCreateNewPlaylistWithValidDataWithVisibilityUnlisted() {
        playlistName= randomString();
        playlistDesc="";
        userCreateNewPlaylistWithValidData(visibilityUnlisted,playlistName,playlistDesc);
    }

    @When("user create new playlist with valid data with visibility public")
    public void userCreateNewPlaylistWithValidDataWithVisibilityPublic() {
        playlistName= randomString();
        playlistDesc="";
        userCreateNewPlaylistWithValidData(visibilityPublic,playlistName,playlistDesc);
    }

    public void userCreateNewPlaylistWithValidData(String visibility, String playlistName, String playlistDesc) {
        driver.findElement(By.xpath(createNewPlaylistBtn)).isDisplayed();
        driver.findElement(By.xpath(createNewPlaylistBtn)).click();
        inputDataPlaylist(playlistName,playlistDesc,visibility);
        driver.findElement(By.xpath(btnCretePlaylist)).isEnabled();
        driver.findElement(By.xpath(btnCretePlaylist)).click();
//        playListUrl= driver.getCurrentUrl();
    }

    public void inputDataPlaylist(String title, String desc, String visibity){
        driver.findElement(By.xpath(titlePLaylistField)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(titlePLaylistField)).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath(titlePLaylistField)).sendKeys(title);
        driver.findElement(By.xpath(descPlaylistField)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(descPlaylistField)).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath(descPlaylistField)).sendKeys(desc);
        driver.findElement(By.xpath(dropdownVisibility)).click();
        driver.findElement(By.xpath(visibity)).click();

    }

    @Then("new playlist would be created")
    public void newPlaylistWouldBeCreated() {
        driver.findElement(By.xpath(TitlePlaylist)).isDisplayed();
        Assert.assertEquals(driver.findElement(By.xpath(TitlePlaylist)).getText(),playlistName);
        playListUrl= driver.getCurrentUrl();
        driver.findElement(By.xpath(libraryMenu)).click();
        Assert.assertTrue(driver.findElement(By.xpath(titleOnListLibrary)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(titleOnListLibrary)).getText(),playlistName);
    }

    public void OpenYTMusicAndlogin(String username, String password) throws InterruptedException {
        userGoToHttpsPage(url);
        driver.findElement(By.xpath(loginButton)).click();
        driver.findElement(By.xpath(emailFiedl)).isDisplayed();
        driver.findElement(By.xpath(emailFiedl)).sendKeys(username);
        driver.findElement(By.xpath(emailNextBtn)).click();
        driver.findElement(By.xpath(passwordField));
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
        driver.findElement(By.xpath(passwordNextBtn)).click();
    }

    @When("user create new playlist with empty data")
    public void userCreateNewPlaylistWithEmptyData() {
        driver.findElement(By.xpath(createNewPlaylistBtn)).isDisplayed();
        driver.findElement(By.xpath(createNewPlaylistBtn)).click();
        inputDataPlaylist("","",visiblityPrvt);
    }

    @Then("error message would be shown and new playlist would not be created")
    public void newPlaylistWouldNotBeCreated() {
        Assert.assertEquals(driver.findElement(By.xpath(ErrorTitleField)).getText(),"Required");
    }

    @Then("close browser")
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @When("add music to playlist")
    public void addMusicToPlaylist() throws InterruptedException {
//        Thread.sleep(1000);
        driver.findElement(By.xpath(titleOnListLibrary)).click();
//        driver.navigate().refresh();
        driver.findElement(By.xpath(addMusicToPlaylist)).click();

//        driver.findElement()
    }

    @Then("music would be added to playlist")
    public void musicWouldBeAddedToPlaylist() {
        Assert.assertTrue(driver.findElement(By.xpath(itemOnPlaylist)).isDisplayed());
    }

    public String randomString(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
        }

    @Given("User on page playlist detail")
    public void userOnPagePlaylistDetail() throws InterruptedException {
        OpenYTMusicAndlogin(email,password);
        driver.findElement(By.xpath(libraryMenu)).isDisplayed();
        driver.findElement(By.xpath(libraryMenu)).click();
        driver.findElement(By.xpath(menuPlaylist)).isDisplayed();
        driver.findElement(By.xpath(menuPlaylist)).click();
        driver.findElement(By.xpath(titleOnListLibrary)).click();;
        driver.findElement(By.xpath(editPlaylistBtn)).click();
    }

    @When("Edit playlist data and save")
    public void editPlaylistDataAndSave() {
        playlistName= randomString();
        playlistDesc= randomString();
        System.out.println(playlistDesc);
        inputDataPlaylist(playlistName,playlistDesc,visiblityPrvt);
        driver.findElement(By.xpath(btnSave)).isEnabled();
        driver.findElement(By.xpath(btnSave)).click();

    }

    @Then("playlist data would be changed")
    public void playlistDataWouldBeChanged() throws InterruptedException {
//        String url= driver.getCurrentUrl();
//        Thread.sleep(2000);
//        System.out.println("cek="+driver.getCurrentUrl());
//        driver.navigate().to(driver.getCurrentUrl());
//        driver.navigate().refresh();
//        driver.navigate().refresh();
//        driver.navigate().refresh();

        driver.findElement(By.xpath(libraryMenu)).isDisplayed();
        driver.findElement(By.xpath(libraryMenu)).click();
        driver.findElement(By.xpath(menuPlaylist)).click();


//        driver.findElement(By.xpath("//*[@id=\"items\"]/ytmusic-two-row-item-renderer[1]/div[1]/div/yt-formatted-string/a")).isDisplayed();
//        driver.findElement(By.xpath("//*[@id=\"items\"]/ytmusic-two-row-item-renderer[1]/div[1]/div/yt-formatted-string/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"items\"]/ytmusic-two-row-item-renderer[1]/div[1]/div/yt-formatted-string/a")).click();


//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TitlePlaylist)));

        String titleplayist=driver.findElement(By.xpath(titleOnListLibrary)).getText();
        Assert.assertEquals(playlistName,titleplayist);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DescPlaylist)));
//        driver.navigate().refresh();
//        String descplaylist=driver.findElement(By.xpath(DescPlaylist)).getText();
//        Assert.assertEquals(playlistName,descplaylist);
//        driver.findElement(By.xpath(DescPlaylist)).isDisplayed();
//        System.out.println("ini1="+driver.findElement(By.xpath(DescPlaylist)).getText());
//        System.out.println("ini2="+playlistDesc);
        Assert.assertEquals(playlistDesc,driver.findElement(By.xpath(DescPlaylist)).getAttribute("textContent"));
    }

    @When("reopen browser with another session to check visibility")
    public void reopenBrowserWithAnotherSessionToCheckVisibility() {
        System.out.println(playListUrl);
        userGoToHttpsPage(playListUrl);
    }

    @Then("playlist will unable to see")
    public void playlistWillUnableToSee() {
        Assert.assertFalse(isElementPresent(By.xpath(playlistName)));
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    @Then("playlist will able to see")
    public void playlistWillAbleToSee() {
        Assert.assertTrue(isElementPresent(By.xpath(publicPlaylistTitle)));
    }


}

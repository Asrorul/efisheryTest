package stepDefiition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Playlist_ObjectPage;


public class playlist_steps {

    Playlist_ObjectPage po= new Playlist_ObjectPage();
    String email= "efisheryasror@gmail.com";
    String password="23571113";
    String playlistName;
    String playlistDesc;
    String playListUrl;

    @Given("User on page library with login account")
    public void userOnPageLibraryWithLoginAccount() {
        po.OpenYTMusicAndlogin(email,password);
        po.driver.findElement(By.xpath(po.libraryMenu)).click();
        po.driver.findElement(By.xpath(po.menuPlaylist)).isDisplayed();
        po.driver.findElement(By.xpath(po.menuPlaylist)).click();
    }

    @When("user create new playlist with valid data with visibility private")
    public void createPrivatePlayList() {
        playlistName= po.randomString();
        playlistDesc="";
        po.userCreateNewPlaylist(po.visiblityPrvt,playlistName,playlistDesc);
    }

    @When("user create new playlist with valid data with visibility unlisted")
    public void userCreateNewPlaylistWithValidDataWithVisibilityUnlisted() {
        playlistName= po.randomString();
        playlistDesc="";
        po.userCreateNewPlaylist(po.visibilityUnlisted,playlistName,playlistDesc);
    }

    @When("user create new playlist with valid data with visibility public")
    public void userCreateNewPlaylistWithValidDataWithVisibilityPublic() {
        playlistName= po.randomString();
        playlistDesc="";
        po.userCreateNewPlaylist(po.visibilityPublic,playlistName,playlistDesc);
    }

    @Then("new playlist would be created")
    public void newPlaylistWouldBeCreated() {
        po.driver.findElement(By.xpath(po.TitlePlaylist)).isDisplayed();
        Assert.assertEquals(po.driver.findElement(By.xpath(po.TitlePlaylist)).getText(),playlistName);
        playListUrl= po.driver.getCurrentUrl();
        po.driver.findElement(By.xpath(po.libraryMenu)).click();
        Assert.assertTrue(po.driver.findElement(By.xpath(po.titleOnListLibrary)).isDisplayed());
        Assert.assertEquals(po.driver.findElement(By.xpath(po.titleOnListLibrary)).getText(),playlistName);
    }


    @When("user create new playlist with empty data")
    public void userCreateNewPlaylistWithEmptyData() {
        po.userCreateNewPlaylist(po.visiblityPrvt,"","");

    }

    @Then("error message would be shown and new playlist would not be created")
    public void newPlaylistWouldNotBeCreated() {
        Assert.assertEquals(po.driver.findElement(By.xpath(po.ErrorTitleField)).getText(),"Required");
        po.closeBrowser();
    }



    @When("add music to playlist")
    public void addMusicToPlaylist() {
        po.driver.findElement(By.xpath(po.titleOnListLibrary)).click();
        po.driver.findElement(By.xpath(po.addMusicToPlaylist)).click();
    }

    @Then("music would be added to playlist")
    public void musicWouldBeAddedToPlaylist() {
        Assert.assertTrue(po.driver.findElement(By.xpath(po.itemOnPlaylist)).isDisplayed());
        po.closeBrowser();
    }

    @Given("User on page playlist detail")
    public void userOnPagePlaylistDetail() throws InterruptedException {
        po.OpenYTMusicAndlogin(email,password);
        po.driver.findElement(By.xpath(po.libraryMenu)).isDisplayed();
        po.driver.findElement(By.xpath(po.libraryMenu)).click();
        po.driver.findElement(By.xpath(po.menuPlaylist)).isDisplayed();
        po.driver.findElement(By.xpath(po.menuPlaylist)).click();
        po.driver.findElement(By.xpath(po.titleOnListLibrary)).click();;
        po.driver.findElement(By.xpath(po.editPlaylistBtn)).click();
    }

    @When("Edit playlist data and save")
    public void editPlaylistDataAndSave() {
        playlistName= po.randomString();
        playlistDesc= po.randomString();
        System.out.println(playlistDesc);
        po.inputDataPlaylist(playlistName,playlistDesc,po.visiblityPrvt);
        po.driver.findElement(By.xpath(po.btnSave)).isEnabled();
        po.driver.findElement(By.xpath(po.btnSave)).click();
    }

    @Then("playlist data would be changed")
    public void playlistDataWouldBeChanged() {
        po.driver.findElement(By.xpath(po.libraryMenu)).isDisplayed();
        po.driver.findElement(By.xpath(po.libraryMenu)).click();
        po.driver.findElement(By.xpath(po.menuPlaylist)).click();
        String titleplayist=po.driver.findElement(By.xpath(po.titleOnListLibrary)).getText();
        Assert.assertEquals(playlistName,titleplayist);
        Assert.assertEquals(playlistDesc,po.driver.findElement(By.xpath(po.DescPlaylist)).getAttribute("textContent"));
    }

    @When("reopen browser with another session to check visibility")
    public void reopenBrowserWithAnotherSessionToCheckVisibility() {
        po.closeBrowser();
        System.out.println(playListUrl);
        po.userGoToHttpsPage(playListUrl);
    }

    @Then("playlist will unable to see")
    public void playlistWillUnableToSee() {
        Assert.assertFalse(po.isElementPresent(By.xpath(playlistName)));
        po.closeBrowser();
    }

    @Then("playlist will able to see")
    public void playlistWillAbleToSee() {
        Assert.assertTrue(po.isElementPresent(By.xpath(po.publicPlaylistTitle)));
        po.closeBrowser();
    }


    @Then("close browser")
    public void closeBrowser() {
        po.closeBrowser();
    }
}

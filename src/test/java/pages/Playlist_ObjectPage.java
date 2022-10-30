package pages;


import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.resources.fileUtils;


public class Playlist_ObjectPage extends fileUtils {

    public String libraryMenu="//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-pivot-bar-renderer/ytmusic-pivot-bar-item-renderer[3]/yt-formatted-string";
    public String menuPlaylist= "//*[@id=\"chips\"]/ytmusic-chip-cloud-chip-renderer[1]";
    public String createNewPlaylistBtn="//*[@id=\"items\"]/ytmusic-two-row-item-renderer[1]/a[@title=\"New playlist\"]";
    public String titlePLaylistField="//*[@id=\"input-2\"]/input";
    public String descPlaylistField="//*[@id=\"textarea\"]";
    public String dropdownVisibility="//*[@id=\"container\"]/div[2]/span[2]/tp-yt-iron-icon";
    public String visiblityPrvt="//*[@id=\"dropdown-items\"]/ytmusic-dropdown-item-renderer[3]/tp-yt-paper-item";
    public String visibilityUnlisted="//*[@id=\"dropdown-items\"]/ytmusic-dropdown-item-renderer[2]";
    public String visibilityPublic="//*[@id=\"dropdown-items\"]/ytmusic-dropdown-item-renderer[1]";
    public String btnCretePlaylist= "//*[@id=\"general-pane\"]/div[2]/yt-button-renderer[2]";
    public String btnSave="//*[@id=\"general-pane\"]/div[2]/tp-yt-paper-button[2]";
    public String TitlePlaylist= "//*[@id=\"header\"]/ytmusic-editable-playlist-detail-header-renderer/ytmusic-detail-header-renderer/div/div[2]/h2/yt-formatted-string";
    public String DescPlaylist="//*[@id=\"description\"]";

    public String ErrorTitleField="//*[@id=\"a11yWrapper\"]";

    public String addMusicToPlaylist="//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer[1]/div[3]/yt-button-renderer/a/yt-icon-button/button";

    public String itemOnPlaylist="//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer";
    public String titleOnListLibrary= "//*[@id=\"items\"]/ytmusic-two-row-item-renderer[2]/div[1]/div/yt-formatted-string/a";
    public String editPlaylistBtn= "//*[@id=\"top-level-buttons\"]/yt-button-renderer/a/tp-yt-paper-button";


    public String publicPlaylistTitle="//*[@id=\"header\"]/ytmusic-detail-header-renderer/div/div[2]/h2/yt-formatted-string";


    public void userCreateNewPlaylist(String visibility, String playlistName, String playlistDesc) {
        driver.findElement(By.xpath(createNewPlaylistBtn)).isDisplayed();
        driver.findElement(By.xpath(createNewPlaylistBtn)).click();
        inputDataPlaylist(playlistName,playlistDesc,visibility);
        driver.findElement(By.xpath(btnCretePlaylist)).isEnabled();
        driver.findElement(By.xpath(btnCretePlaylist)).click();
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

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String randomString(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

}

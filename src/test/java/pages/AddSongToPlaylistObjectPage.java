package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.resources.fileUtils;

public class AddSongToPlaylistObjectPage extends fileUtils {

    public String searchBtn="//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-search-box/div/div[1]/tp-yt-paper-icon-button[1]";
    public String inputSearchField="//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-search-box/div/div/input";
    public String threeDots="//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer/ytmusic-menu-renderer/tp-yt-paper-icon-button/tp-yt-iron-icon";
    public String addToPlatList="//*[@id=\"items\"]/ytmusic-menu-navigation-item-renderer[2]";
    public String popUpLogin="//*[@id=\"contentWrapper\"]/ytmusic-modal-with-title-and-button-renderer";
    public String signInButton="//*[@id=\"contentWrapper\"]/ytmusic-modal-with-title-and-button-renderer/div/yt-button-renderer";


}

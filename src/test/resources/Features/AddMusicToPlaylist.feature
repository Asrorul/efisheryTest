Feature: add music to playlist
  Scenario: add music to playlist without login
    Given open youtube music without login
    And search a song
    When add to playlist from the search result
    Then login pop up would be shown
    Then close browser

  Scenario: add music to playlist from library page
    Given User on page library with login account
    When add music to playlist
    Then music would be added to playlist
    Then close browser
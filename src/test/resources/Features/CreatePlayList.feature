Feature: Create Playlist
  Scenario: Create playlist with private visibility
    Given User on page library with login account
    When user create new playlist with valid data with visibility private
    Then new playlist would be created
    Then close browser
    When reopen browser with another session to check visibility
    Then playlist will unable to see

  Scenario: Create playlist with unlisted visibility
    Given User on page library with login account
    When user create new playlist with valid data with visibility unlisted
    Then new playlist would be created
    Then close browser
    When reopen browser with another session to check visibility
    Then playlist will able to see

  Scenario: Create playlist with unlisted visibility
    Given User on page library with login account
    When user create new playlist with valid data with visibility public
    Then new playlist would be created
    Then close browser
    When reopen browser with another session to check visibility
    Then playlist will able to see

  Scenario: Create playlist with empty data
    Given User on page library with login account
    When user create new playlist with empty data
    Then error message would be shown and new playlist would not be created
    Then close browser
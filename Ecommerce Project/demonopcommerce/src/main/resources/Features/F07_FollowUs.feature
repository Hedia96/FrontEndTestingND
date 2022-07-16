@smoke
Feature: F07_FollowUS | the four icons for social media facebook, youtube, twitter,RSS
  Scenario: user on home page ,click on facebook icon
   # Given
    When user click on facebook icon from follow us section
    Then creating a new tab and the expected URL is "https://www.facebook.com/nopCommerce"


  Scenario: user on home page ,click on twitter icon
   # Given
    When user click on twitter icon from follow us section
  Then creating a new tab and the expected URL is "https://twitter.com/nopCommerce"
#

  Scenario: user on home page ,click on RSS icon
   # Given
    When user click on RSS icon from follow us section
    Then creating a new tab and the expected URL is "https://demo.nopcommerce.com/nopcommerce-new-release"


  Scenario: user on home page ,click on Youtube icon
   # Given
    When user click on Youtube icon from follow us section
    Then creating a new tab and the expected URL is "https://www.youtube.com/user/nopCommerce"


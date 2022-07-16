@smoke
Feature: F08_Whishlist | user press on button <3  to add the product in wish list
  Scenario: user press on button <3  to add the product in wish list
    #Given=Before is already open in Home page
    When user press on the wishlist button
    #And user click on url in notifcation msg
    Then check green message pop up and content
    And refer to link wishlist shown in the message
    And check the quantity
#
#  Scenario: user press on button <3  to add the product in wish list for second time
#    #Given=Before is already open in Home page
#    When user press on the wishlist button
#    Then check green message pop up and content
#    And refer to link wishlist shown in the message
#    And check the quantity
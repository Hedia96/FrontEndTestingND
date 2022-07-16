@smoke
Feature: F02_Login | users could login with registered account using email and password
  #SC2- User could login with valid data
  Scenario: users could login with valid data successfully
    Given user go to login page
    #And Registered email before to avoid error message
    #When Entering registered email "yoyohedia5@gmail.com"and Password ""
    When Entering registered email "yoyohedia6@gmail.com"and Password "P@ssw0rd"
    And click on the login Button
    Then refer to the page and My account appears on the left top of the page



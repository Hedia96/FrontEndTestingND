@smoke
Feature: F01_Register | users could register with new accounts
  #SC1- User could register with valid data
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When Entering username"Ayah" and Lastname"Hedya"and Email "yoyohedia7@gmail.com"
    And Enter"P@ssw0rd"as Password and its confirmation
    And Click on Register button
    Then Display the registration success message



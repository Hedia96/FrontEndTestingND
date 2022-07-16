@smoke
  Feature: F06_Homeslider | user click on the slider ,slider shall refer to another link
    Scenario: user click on the slider nokia ,slider shall refer to another link
      When click on the slider"nokia"
      Then check the current url after"nokia"slider

    Scenario: user click on the slider iphone  ,slider shall refer to another link
      When click on the slider"iphone"
      Then check the current url after"iphone"slider

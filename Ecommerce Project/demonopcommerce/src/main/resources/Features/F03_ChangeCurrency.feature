@smoke
  Feature: F03_ChangeCurrency | user changes currency from US to Euro and vice versa
    #SC5- Logged User could switch between currencies US-Euro
    Scenario: user after login successfully could change currency from US to Euro and vice versa
      Given click on the left top tab on the page
      When select the needed currency"Euro"
      Then check the selected currency reflected in the shown products
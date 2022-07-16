@smoke
Feature: F05_HoverCateogry
  Scenario: hover then select any of the sub categories from the dynamic list
    Given Hover on the one of main categories
    When select one of sub categories
    Then check the page title same as the text of selected sub category
#  - in Home page, there are 3 main categories contains sub-categories
#  [Computers, Electronics, Apparel]
#
#  2- you need to select random one of the three main categories
#
#  3- you should hover on the selected category
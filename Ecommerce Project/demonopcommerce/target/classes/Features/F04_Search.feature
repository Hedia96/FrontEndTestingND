@smoke
Feature: F04_search |user search by product name or SKU

  Scenario Outline:  user search by product name like 'book' ,'laptop' or 'nike'
    Given user enter "<name>" of the product
    When click on search button
    Then check the search result includes"<name>"
    Examples:
      | name   |
      | book   |
      | laptop |
      | nike   |


  Scenario Outline: user search by entering  SKU code ex: SCI_FAITH, APPLE_CAM, SF_PRO_11
    Given user enter "<SKU>" of the product
    When click on search button
    Then check the search result includes"<SKU>"
    Examples:
      | SKU       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
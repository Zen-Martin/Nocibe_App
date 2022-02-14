#@REQ_OF-488 Nocibe
Feature: Products Page

  Background:
    Given User is on homepage
    And User is on search bar
    When User enter a "Parfum"
    And User validate his choice

  @TEST_OF-658
  Scenario: Display of product card
    Given User is on product page
    When User select a product
    Then User should be able to see choosen product info

#  @TEST_OF-654
#  Scenario Outline: Filter on product find
#    Given User is on product page
#    When User select sort by <Sort_value>
#    Then User should see effective sort by operation
#    And User select product <Product_option>
#    And User validates <Option_value>
#    Then User should see a page display with choosen product results
#    And User should see message about choosen product results number
#
#    Examples:
#      |Sort_value       |Product_option |Option_value  |
#      |Prix croissant   |price          |de 1 à 16     |
#
#
#  @TEST_OF-701
#  Scenario: Modify filter parameters
#    Given User is on product page
#    And User see product filter parameters
#    When User click on cross near filter parameter
#    Then User should see filter parameter disappear
#    And User click on 're-initialise filter' button
#    Then User should see no filter parameter

#	@TEST_OF-660
#	Scenario: Unavailable product
#		Given User is on product page
#		When User look at product results
#		Then User should be able to see message about unavaibility of product
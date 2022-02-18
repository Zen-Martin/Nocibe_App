#@REQ_OF-488 Nocibe
Feature: Products Page

  Background:
    Given User is on homepage
    And User is on search bar
    When User enter a "Parfum"
    And User validate his choice

#  @TEST_OF-658
#  Scenario: Display of product card
#    Given User is on product page
#    When User select a product
#    Then User should be able to see choosen product info

#  @TEST_OF-698
#  Scenario: Increase cart contain quantity
#    Given User select a product
#    And User go to cart page
#    When User click on adding icon near any contain
#    Then User should see contain quantity change


#  @TEST_OF-699
#  Scenario: Decrease cart contain quantity
#    Given User select a product
#    And User go to cart page
#    When User click on reducing icon near any contain
#    Then User should see contain quantity change

#  @TEST_OF-700
#  Scenario: Delete cart contain
#    Given User select a product
#    And User go to cart page
#    When User click on cross icon near any contain
#    Then User should see contain disappear

#  @TEST_OF-693
#  Scenario: Ready to payment
#    Given User select a product
#    And User go to cart page
#    When User click button "validate my cart"
#    And User get logged
#    Then User should see payment page

#  @TEST_OF-685
#  Scenario: Available product
#    Given User select a product
#    When User click on button "add to cart"
#    Then User should see message about product add on cart

#  @TEST_OF-654
#  Scenario Outline: Filter on product find
#    Given User is on product page
#    When User select sort by "<Sort_value>"
#    And User select product "<Product_option>"
#    Then User should see product result decrease
#
#    Examples:
#      |Sort_value       |Product_option  |
#      |Prix croissant   |PRIX            |

  @TEST_OF-701
  Scenario Outline: Modify filter parameters
    Given User is on product page
    When User select sort by "<Sort_value>"
    And User select product "<Product_option>"
    Then User should see filter active
    When User select again product "<Product_option>"
    Then User should see filter disappear
    And User click on re-initialise button
    Then User should see default product result display

    Examples:
      |Sort_value       |Product_option  |
      |Prix croissant   |MARQUE          |
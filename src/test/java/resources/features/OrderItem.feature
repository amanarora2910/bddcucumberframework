Feature: Automated Tests of Ordering an item

Background: User is logged in
    Given user is logged in
	
Scenario: User place an order of T-Shirt and Verify it in Order History	
	And adds t-shirt in shopping cart
    When user confirms the payment for the order
    Then the order is successfully placed
    And the order details are correct
    
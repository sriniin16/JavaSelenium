Feature: AutomationPractice


  Scenario: Search product in search bar
    Given I am on the automation practice landing page
    When I search for "Dress" in the search bar
    Then I should be displayed with the search results
    
	Scenario: search product and add item to cart
		Given I am on the automation practice landing page
		When I search for "Dress" in the search bar
    Then I should be displayed with the search results
    When I select the item with multi color option
    And Verify the product description page
    And I verify the color as "Yellow" and quantity update
    And I add the item to the cart
    Then I should be able to verify the items in the summary page
    
	Scenario: add more items and verify item and qunatity update    
		Given I am on the automation practice landing page
		When I search for "Dress" in the search bar
    Then I should be displayed with the search results
    When I select the item with multi color option
    And Verify the product description page
    And I verify the color as "Yellow" and quantity update
    And I add the item to the cart
    Then I should be able to verify the items in the summary page
    When I add item with color "Blue" to the cart     
    And I update quantity for one item
    And I remove the last item in the cart
    Then I verify the items in the summary page



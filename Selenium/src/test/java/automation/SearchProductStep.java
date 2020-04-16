package automation;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStep extends BaseStep {

    private BaseStep base;
    public SearchProductPage searchProductpage;
    
    

    public SearchProductStep(BaseStep base)
    {
        this.base = base;
        searchProductpage = new SearchProductPage(base.driver);
    }

    @Given("^I am on the automation practice landing page$")
    public void i_am_on_the_automation_practice_landing_page() 
    {
        System.out.println("Launched");        
        String Title = searchProductpage.getSiteTitle();
        Assert.assertEquals(Title, "My Store");
    }

    @When("^I search for \"([^\"]*)\" in the search bar$")
    public void iSearchForInTheSearchBar(String productType)
    {
    	searchProductpage.searchProductInSearchBox(productType);
        System.out.println("product searched: " +productType);
    }

    @Then("^I should be displayed with the search results$")
    public void iShouldBeDisplayedWithTheSearchResults()
    {
    	boolean pageDisplayed = searchProductpage.searchProductDisplayed();
        Assert.assertEquals(true, pageDisplayed, "Search results not displayed");
    }
    
    @When("I select the item with multi color option")
    public void i_select_the_item_with_multi_color_option() {
        Assert.assertEquals(true, searchProductpage.verifyMultiColorItem(),"multi color item not displayed");
        searchProductpage.selectItem();
    }
    
    @When("Verify the product description page")
    public void verify_the_product_description_page() {
        searchProductpage.verifyProductDescriptionPage();
    }    

    @When("I verify the color as {string} and quantity update")
    public void i_verify_the_color_as_and_quantity_update(String color) {
        searchProductpage.chooseColorAndQuantity(color);
    }
    
    @When("I add the item to the cart")
    public void i_add_the_item_to_the_cart() {
        searchProductpage.addToCart();
    }

    @Then("I should be able to verify the items in the summary page")
    public void i_should_be_able_to_verify_the_items_in_the_summary_page() {
        Assert.assertEquals(true, searchProductpage.verifySummaryPage(),"Summary page not displayed");
    }
    
    @When("I add item with color {string} to the cart")
    public void i_add_item_with_color_to_the_cart(String color) {
        searchProductpage.addMoreItem(color);
    }

    @When("I update quantity for one item")
    public void i_update_quantity_for_one_item() {
        searchProductpage.updateQuantityInSummaryPage();
    }

    @When("I remove the last item in the cart")
    public void i_remove_the_last_item_in_the_cart() {
        searchProductpage.removeItemInSummaryPage();
    }

    @Then("I verify the items in the summary page")
    public void i_verify_the_items_in_the_summary_page() {
        Assert.assertEquals(true, searchProductpage.verifyProductInCart(),"Product mismatch in cart");
    }
}

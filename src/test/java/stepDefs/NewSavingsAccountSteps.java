package stepDefs;
import pages.HomePage;
import pages.LoginPage;
import pages.NewSavingsAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class NewSavingsAccountSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    NewSavingsAccountPage newSavingsAccountPage = new NewSavingsAccountPage();

    //user is logged in
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        loginPage.verifyUserIsOnLoginPage();
    }

    @When("user enters the valid credentials")
    public void userEntersTheValidCredentials() {
        loginPage.doLogin();
        loginPage.clickOnSignInButton();
    }

    @Then("verify user is on the Home page")
    public void verifyUserIsOnTheHomePage() {
        homePage.verifyUserIsSignedInSuccessfully();
    }

    @Then("user clicks on the Savings field")
    public void user_clicks_on_the_checking_field() {

        homePage.clickOnSavingsItem();
    }

    @Then("verify View Savings and New Savings options are displayed")
    public void verify_view_checking_and_new_savings_options_are_displayed() {
        homePage.verifySavingsOptionsAreDisplayed();
    }


    @Then("user clicks on New Savings option")
    public void userClicksOnNewSavingsAccount() {
        homePage.userChooseNewSavingsOption();
    }
    // verify New Savings page is opened
    @Given("page with corresponding URL is opened")
    public void verify_new_savings_page_is_opened() {
        newSavingsAccountPage.getSavingsPageURL();
    }
    @Then("verify New Saving Account header is displayed")
    public void verifyNewSavingAccountHeaderIsDisplayed() {
        newSavingsAccountPage.verifyNewSavingsAccountHeaderIsDisplayed();

    }
//verify Select Savings Account Type radio button options are visible and unchecked by default

    @Given("Select Savings Account Type header is displayed")
    public void verifyNewSavingsAccountHeaderIsDisplayed() {
        newSavingsAccountPage.verifySelectSavingsAccountTypeHeaderIsDisplayed();
    }
    @Then("verify Savings and Money Market radio buttons unchecked by default")
    public void verifySavingsMoneyMarketRadioButtonsUncheckedByDefault() {
        newSavingsAccountPage.verifySelectSavingsRadioButtonsAreUnchecked();
    }
    //verify Select Account Ownership radio button options are visible and unchecked by default
    @Given("verify the Select Account Ownership header is displayed")
    public void verifyTheNewSavingsAccountOwnerIsDisplayed() {
        newSavingsAccountPage.verifySelectAccountOwnershipHeaderIsDisplayed();
    }
    @Then("verify the Individual and Joint radio buttons unchecked by default")
    public void verifyTheIndividualAndJointRadioButtonOptionsAreUncheckedByDefault() {
        newSavingsAccountPage.verifyOwnershipRadioButtonsAreUnchecked();
    }

//Verify user is able to enter account name with alphanumeric and special characters

    @Given("user is in account name field")
    public void user_is_in_account_name_field() {
        newSavingsAccountPage.getToAccountNameField();
    }

    @When("user enters the account name with alphanumeric and special characters")
    public void user_enters_with_alphanumeric_and_special_characters() {

        newSavingsAccountPage.enterAccountName();

    }

    @Then("verify that entered account name corresponds to the name displayed in the field")
    public void verify_that_entered_corresponds_to_the_name_displayed_in_the_field() {
        newSavingsAccountPage.verifyIfAccountFieldHasText();
    }
    //Verify user is able to enter valid numeric whole or decimal amount in the Initial Deposit Amount field
    @Given("user is in input field Initial Deposit Amount")
    public void user_is_in_input_field_initial_deposit_amount() {
        newSavingsAccountPage.getToInputDepositField();
    }

    @When("user enters valid numeric whole or decimal number {string}")
    public void user_enters_valid_numeric_whole_or_decimal_number(String amount) {
        newSavingsAccountPage.enterDepositAmount(amount);
    }

    @Then("verify amount in the field is the same {string}")
    public void verify_amount_in_the_field_is_the_same(String amount) {
        newSavingsAccountPage.verifyIfEnteredAmountDisplayed(amount);
    }
    // Scenario Outline: Verify user is not able to enter invalid input
    @Given("user is in input field initial deposit amount")
    public void user_is_in_input_filed_initial_deposit_amount() {
        newSavingsAccountPage.getToInputDepositField();
    }

    @When("user enters the invalid {string}")

    public void user_enters_invalid_amount(String input) {
        newSavingsAccountPage.clickOnSavingsRadioButton();
        newSavingsAccountPage.clickOnIndividualRadioButton();
        newSavingsAccountPage.enterAccountName();
        newSavingsAccountPage.enterInvalidAmount(input+ Keys.ENTER);
    }

    @Then("verify corresponding error message is displayed")
    public void verify_corresponding_error_message_is_displayed() {
        newSavingsAccountPage.verifyErrorAmountMessage();

    }
    //verify user is able to create an account and redirected to page to view saving account

    @Given("user filled the fields")
    public void user_filled_the_fields() {
        newSavingsAccountPage.clickOnSavingsRadioButton();
        newSavingsAccountPage.clickOnIndividualRadioButton();
        newSavingsAccountPage.enterAccountName();
        newSavingsAccountPage.enterDepositAmount("25.00");
    }

    @When("user clicks on the Submit button")
    public void user_clicks_on_the_submit_button() {
        newSavingsAccountPage.clickOnSubmitButton();
    }

    @Then("verify user is redirected to page to view saving account")
    public void verify_user_is_redirected_to_page_to_view_savind_account() {
        newSavingsAccountPage.verifyUserGetSuccessfullyMessage();
    }
//verify user is able to click on Reset button

    @When("user clicks on the Reset button")
    public void user_clicks_on_the_reset_button() {
        newSavingsAccountPage.clickOnResetButton();

    }

    @Then("verify all the filled values are reset to default")
    public void verify_all_the_filled_values_are_reset_to_default() {
        newSavingsAccountPage.verifySelectSavingsRadioButtonsAreUnchecked();
        newSavingsAccountPage.verifyOwnershipRadioButtonsAreUnchecked();
        newSavingsAccountPage.verifyAccountNameFieldIsEmpty();
        newSavingsAccountPage.verifyAmountFieldIsEmpty();

    }
}


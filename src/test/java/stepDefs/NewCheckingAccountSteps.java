package stepDefs;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCheckingAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewCheckingAccountSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    NewCheckingAccountPage newCheckingAccountPage = new NewCheckingAccountPage();


    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.verifyUserIsOnLoginPage();
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        loginPage.doLogin();
        loginPage.clickOnSignInButton();
    }

    @Then("verify user is on Home page")
    public void verifyUserIsOnHomePage() {
        homePage.verifyUserIsSignedInSuccessfully();
    }

    @Then("user clicks on Checking field")
    public void user_clicks_on_checking_field() {
        homePage.clickOnCheckingItem();
    }

    @Then("verify View Checking and New Checking options are displayed")
    public void verify_view_checking_and_new_checking_options_are_displayed() {
        homePage.verifyCheckingOptionsAreDisplayed();
    }


    @Then("user clicks on New Checking Account")
    public void userClicksOnNewCheckingAccount() {
        newCheckingAccountPage.clickOnNewChecking();
    }

    @Then("verify New Checking Account header is displayed")
    public void verifyNewCheckingAccountHeaderIsDisplayed() {
        newCheckingAccountPage.verifyNewCheckingAccountHeaderIsDisplayed();
    }


    @And("verify Individual and Joint radio buttons unchecked by default")
    public void verifyIndividualAndJointRadioButtonOptionsAreUncheckedByDefault() {
        newCheckingAccountPage.verifyOwnershipRadioButtonsAreUnchecked();
    }

    @Then("verify Select Account Ownership header is displayed")
    public void verifySelectAccountOwnershipHeaderIsDisplayed() {
        newCheckingAccountPage.verifySelectAccountOwnershipHeaderIsDisplayed();

    }

    @And("verify Standard and Interest Checking radio buttons unchecked by default")
    public void verifyStandardAndInterestCheckingRadioButtonsUncheckedByDefault() {
        newCheckingAccountPage.verifyCheckingRadioButtonsAreUnchecked();
    }

    @Then("verify Select Checking Account header is displayed")
    public void verifySelectCheckingAccountHeaderIsDisplayed() {
        newCheckingAccountPage.verifySelectCheckingAccountTypeHeaderIsDisplayed();
    }

    @Given("user is in the account name Field")
    public void user_is_in_the_account_name_field() {

    }

    @When("user field user enters account name with alphanumeric and special characters")
    public void user_field_user_enters_with_alphanumeric_and_special_characters() {

        newCheckingAccountPage.enterAccountName();
    }

    @Then("verify that the entered account name corresponds to the name displayed in the field")
    public void verify_that_the_entered_corresponds_to_the_name_displayed_in_the_field() {
        newCheckingAccountPage.verifyIfAccountFieldHasText();
    }

    @Given("user is in the input field Initial Deposit Amount")
    public void user_is_in_the_input_field_initial_deposit_amount() {

    }

    @When("user enters valid numeric whole or decimal {string}")
    public void user_enters_valid_numeric_whole_or_decimal(String amount) {
        newCheckingAccountPage.enterDepositAmount(amount);
    }

    @Then("verify amount in the field is the same as entered {string}")
    public void verify_amount_in_the_field_is_the_same_as_entered(String amount) {
        newCheckingAccountPage.verifyIfEnteredAmountDisplayed(amount);
    }

    @Given("user is in the input field initial deposit amount")
    public void user_is_in_the_input_filed_initial_deposit_amount() {

    }

    @When("user enters invalid {string}")
    public void user_enters_un_valid(String input) {
        newCheckingAccountPage.enterInvalidAmount(input);
    }

    @Then("verify user can't continue and corresponding error message is displayed")
    public void verify_user_can_t_continue_and_corresponding_error_message_is_displayed() {
        newCheckingAccountPage.verifyErrorAmountMessage();

    }

    @Given("user filled all the fields")
    public void user_filled_all_the_fields() {
        newCheckingAccountPage.clickOnStandardRadioButton();
        newCheckingAccountPage.clickOnIndividualRadioButton();
        newCheckingAccountPage.enterAccountName();
        newCheckingAccountPage.enterDepositAmount("25.00");


    }

    @When("user clicks on Reset button")
    public void user_clicks_on_reset_button() {
        newCheckingAccountPage.clickOnResetButton();

    }

    @Then("verify all filled values are reset to default")
    public void verify_all_filled_values_are_reset_to_default() {
        newCheckingAccountPage.verifyCheckingRadioButtonsAreUnchecked();
        newCheckingAccountPage.verifyOwnershipRadioButtonsAreUnchecked();
        newCheckingAccountPage.verifyAccountNameFieldIsEmpty();
        newCheckingAccountPage.verifyAmountFieldIsEmpty();

    }

    @When("user clicks on Submit button")
    public void user_clicks_on_submit_button() {
        newCheckingAccountPage.clickOnSubmitButton();
    }

    @Then("verify user is redirected to page with checking accounts and cen see message Successfully created new Interest Checking account named account name")
    public void verify_user_is_redirected_to_page_with_checking_accounts_and_cen_see_message_account_name() {
        newCheckingAccountPage.verifyUserGetSuccessfullyMessage();
    }


}

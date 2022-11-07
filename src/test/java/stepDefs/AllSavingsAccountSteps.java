package stepDefs;

import pages.AllSavingsAccountPages;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllSavingsAccountSteps {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    AllSavingsAccountPages allSavingsAccountPages = new AllSavingsAccountPages();


    @Given("user on the login page")
    public void user_on_the_login_page() {

        loginPage.verifyUserIsOnLoginPage();
    }

    @When("user enter valid credentials")
    public void userEnterValidCredentials() {
        loginPage.doLogin();
        loginPage.clickOnSignInButton();
    }

    @Then("verify user on the Home page")
    public void verifyUserOnTheHomePage() {
        homePage.verifyUserIsSignedInSuccessfully();
    }

    @Then("user click on the Savings field")
    public void user_click_on_the_checking_field() {

        homePage.clickOnSavingsItem();
    }

    @Then("verify View Savings and New Savings options displayed")
    public void verify_view_checking_and_new_savings_options_displayed() {
        homePage.verifySavingsOptionsAreDisplayed();
    }

    @When("user click on View Savings option")
    public void user_click_on_view_savings_option() {

        homePage.clickOnViewSavingsAccount();
    }

    @Given("Transactions header is displayed")
    public void transactions_header_is_displayed() {
        allSavingsAccountPages.verifyTransactionsHeaderIsDisplayed();

    }

    @Then("verify Date header is displayed")
    public void verify_date_header_is_displayed() {
        allSavingsAccountPages.verifyDateHeaderIsDisplayed();
    }

    @Then("verify Category header is displayed")
    public void verify_category_header_is_displayed() {
        allSavingsAccountPages.verifyCategoryHeaderIsDisplayed();
    }

    @Then("verify Description header is displayed")
    public void verify_description_header_is_displayed() {
        allSavingsAccountPages.verifyDescriptionHeaderIsDisplayed();
    }

    @Then("verify Amount header is displayed")
    public void verify_amount_header_is_displayed() {
        allSavingsAccountPages.verifyAmountHeaderIsDisplayed();
    }

    @Then("verify Balance header is displayed")
    public void verify_balance_header_is_displayed() {
        allSavingsAccountPages.verifyBalanceHeaderIsDisplayed();
    }

    @Given("user has several accounts")
    public void user_has_several_accounts() {
        allSavingsAccountPages.verifySavingsAccountCard1IsDisplayed();
    }

    @Then("check the number of accounts")
    public void check_the_number_of_accounts() {
        allSavingsAccountPages.countAccountNumber();
    }

    @Then("verify only one toggle button is activated")
    public void verify_only_one_toggle_button_is_activated() {
        allSavingsAccountPages.verifyOnlyOneToggleButtonIsSelected();
    }

    @Given("only one toggle button is activated")
    public void only_one_toggle_button_is_activated() {

    }

    @Then("verify user can see the same account data in the transaction table")
    public void verify_user_can_see_the_same_account_data_in_the_transaction_table() {
        allSavingsAccountPages.verifyUserCanSeeSameAccountInformation();

    }

}

package stepDefs;

import pages.LoginPage;
import pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationSteps {


    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();

    //  Verify Sign Up Here link redirects the user to the Sign Up page
    @Given("user is on Login page")
    public void user_is_on_Login_page() {

    }

    @When("user clicks on sign Up Here link")
    public void user_clicks_on_sign_up_here_link() {
        loginPage.clickSignUpLink();

    }
    @Then("verify user is on the registration page")
    public void verify_user_is_on_the_registration_page() {
        registrationPage.verifyUserIsOnRegistrationPage();

    }
//Verify user is able to choose a proper title from the drop-down window

    @When("user click on Title field")
    public void user_click_on_Title_field() {
        registrationPage.verifyUserClickOnTitleField();
    }

    @Then("verify user can see the drop-down window with title options")
    public void verify_user_can_see_the_drop_down_window_with_title_options() {
        registrationPage.verifyUserSeeDropDown();
    }

    @And("verify chosen {string} appears in the {string} field")
    public void verify_chosen_appears_in_the_field(String selection, String title) {
        registrationPage.verifyUserCanSelectTitle(selection, title);
    }
    //Verify user can enter first name
    @When("user enters {string} in first name field")
    public void user_enters_in_first_name_field(String string) {
        registrationPage.verifyUserCanEnterFirstName();
    }

    @Then("verify first name is displayed in the first name field")
    public void verify_first_name_is_displayed_in_the_first_name_field() {
        registrationPage.verifyFirstNameIsDisplayed();
    }
    //Verify user can enter last name
    @When("user enters {string} in last name")
    public void user_enters_in_last_name(String string) {
        registrationPage.verifyUserCanEnterLastName();
    }

    @Then("verify Last Name is displayed in the last name field")
    public void verify_last_name_is_displayed_in_the_last_name_field()  {
        registrationPage.verifyLastNameIsDisplayed();
    }
    //Verify user can select gender

    @When("user clicks on M radio button")
    public void user_clicks_on_m_radio_button() {
        registrationPage.selectGenderMRadioButton();
    }
    @Then("verify active radio button is M")
    public void verify_active_radio_button_is_m() {
        registrationPage.verifyGenderMRadioButton();
    }

    @When("user clicks on F radio button")
    public void user_clicks_on_f_radio_button() {
        registrationPage.selectGenderFRadioButton();
    }
    @Then("verify active radio button is F")
    public void verify_active_radio_button_is_f() {
        registrationPage.verifyGenderFRadioButton();
    }

    //Verify user can enter correct date of birth
    @Given("user clicks on DOB field")
    public void user_clicks_on_dob_field() {
        registrationPage.clickOnDOBField();
    }

    @When("user types correct {string}, {string}, {string} format")
    public void user_types_correct_format(String month, String day, String year) throws InterruptedException {
        registrationPage.verifyUserCanEnterDOB(month, day, year);
    }

    @Then("verify {string}, {string}, {string} is displayed  in the corresponding field")
    public void verify_dob_is_displayed_in_the_corresponding_field(String month, String day, String year) throws InterruptedException {
        registrationPage.verifyDOBFieldIsDisplayed(month, day, year);
    }
//Verify user can't enter invalid date of birth

    @When("user types incorrect {string}, {string}, {string} format")
    public void user_types_incorrect_format(String invalidMonth, String invalidDay, String invalidYear) {
        registrationPage.verifyUserCannotEnterInvalidDOB(invalidMonth, invalidDay, invalidYear);
    }

    @Then("verify user gets an error message {string}")
    public void verify_user_gets_an_error_message(String errorMessage) {
        registrationPage.verifyDOBErrorMessageIsDisplayed(errorMessage);
    }
    //Verify user is able to enter correct SSN
    @Given("user clicks on SSN field")
    public void user_clicks_on_ssn_field() {
        registrationPage.clickOnSSNField();
    }

    @When("user types in correct {string} format")
    public void user_types_in_correct_format(String snn) {
        registrationPage.verifyUserCanEnterSSN(snn);
    }

    @Then("{string} is displayed in the SSN field")
    public void ssn_is_displayed_in_the_ssn_field(String snn) {
        registrationPage.verifySSNIsDisplayed(snn);
    }

//Verify user cannot enter incorrect SSN

    @When("user types incorrect {string} format")
    public void user_types_incorrect_format(String invalidSSN) throws InterruptedException {
        registrationPage.userEntersAllDataTillSNN();
        registrationPage.enterInvalidSSN(invalidSSN);
    }

    @Then("error message is displayed prompting to enter correct format SSN")
    public void error_message_is_displayed_prompting_to_enter_correct_format_ssn() {
        registrationPage.verifyInvalidSSNErrorMessage();

    }

}
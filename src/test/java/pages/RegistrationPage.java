package pages;


import utilities.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class RegistrationPage extends BasePage {

    @FindBy(id = "title")
    public WebElement titleRegistrationField;

    @FindBy(xpath = "//select/option[contains(text(),'Please select')]")
    public WebElement pleaseSelectMessage;

    @FindBy(id = "firstName")
    public WebElement firstNameRegistrationField;

    @FindBy(id = "lastName")
    public WebElement lastNameRegistrationField;

    @FindBy(xpath = "//input[@value= 'M']")
    public WebElement genderMRadioButton;

    @FindBy(xpath = "//input[@value= 'F']")
    public WebElement genderFRadioButton;

    @FindBy(id = "dob")
    public WebElement dateOfBirthRegistrationField;

    @FindBy(id = "ssn")
    public WebElement ssnRegistrationField;

    @FindBy(id = "emailAddress")
    public WebElement emailRegistrationField;

    @FindBy(id = "password")
    public WebElement passwordRegistrationField;

    @FindBy(id = "//confirmPassword")
    public WebElement confirmPasswordRegistrationField;

    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    public WebElement singInLink;

    @FindBy(xpath = "//input[@title='Social Security Number must be in a valid format. i.e. ###-##-####']")
    public WebElement invalidSSNErrorMessage;


    @FindBy(xpath = "//input[contains(@title,‘Password must contain’)]")
    public WebElement passwordErrorMessage;

    public void verifyUserIsOnRegistrationPage() {

        Assert.assertTrue("User is not on the RegistrationPage Page", firstNameRegistrationField.isDisplayed());
    }

    public void verifyUserClickOnTitleField() {

        titleRegistrationField.click();
    }

    public void verifyUserSeeDropDown() {

        WebElement titleDropdown = titleRegistrationField;
        Select titleDropdownSelect = new Select(titleDropdown);
        Assert.assertTrue("User is not in the Title Field", pleaseSelectMessage.isDisplayed());
    }
    public void verifyUserCanSelectTitle(String selection, String title) {
        WebElement titleDropdown = titleRegistrationField;
        Select titleDropdownSelect = new Select(titleDropdown);
        titleDropdownSelect.selectByVisibleText(selection);
        WebElement selectedOption = titleDropdownSelect.getFirstSelectedOption();
        Assert.assertEquals(title, selectedOption.getText());
    }
    public void verifyUserCanEnterFirstName() {
        firstNameRegistrationField.sendKeys(ConfigReader.getProperty("enter.first.name") + Keys.ENTER);
    }
    public void verifyFirstNameIsDisplayed(){
        String firstName = firstNameRegistrationField.getAttribute("value");
        Assert.assertEquals(ConfigReader.getProperty("enter.first.name"), firstName);

    }
    public void verifyUserCanEnterLastName() {
        lastNameRegistrationField.sendKeys(ConfigReader.getProperty("enter.last.name")+ Keys.ENTER);
    }

    public void verifyLastNameIsDisplayed()  {

        String lastName = lastNameRegistrationField.getAttribute("value");

        Assert.assertEquals(ConfigReader.getProperty("enter.last.name"), lastName);

    }
    public void clickOnDOBField(){
        dateOfBirthRegistrationField.click();
    }
    public void verifyUserCanEnterDOB(String month, String day, String year) throws InterruptedException {

        dateOfBirthRegistrationField.sendKeys(month + day + year + Keys.ENTER);

    }

    public void verifyDOBFieldIsDisplayed(String month, String day, String year) throws InterruptedException {
        String dobValue = dateOfBirthRegistrationField.getAttribute("value");
        Assert.assertEquals(month+ day + year, dobValue);
    }


    public void selectGenderMRadioButton(){
        genderMRadioButton.click();
    }
    public void selectGenderFRadioButton(){
        genderFRadioButton.click();
    }
    public void verifyGenderMRadioButton(){
        Assert.assertTrue(genderMRadioButton.isSelected());

    }
    public void verifyGenderFRadioButton(){
        Assert.assertTrue(genderFRadioButton.isSelected());
    }

    public void verifyUserCannotEnterInvalidDOB(String invalidMonth, String invalidDay, String invalidYear)  {

        dateOfBirthRegistrationField.sendKeys(invalidMonth + invalidDay + invalidYear + Keys.ENTER);

    }

    public void verifyDOBErrorMessageIsDisplayed(String errorMessage) {
        errorMessage = "Please enter valid date";

    }
    public void clickOnSSNField(){

        ssnRegistrationField.click();
    }
    public void verifyUserCanEnterSSN(String ssn) {

        ssnRegistrationField.sendKeys(ssn + Keys.ENTER);
    }

    public void verifySSNIsDisplayed(String ssn) {
        String ssnValue =  ssnRegistrationField.getAttribute("value");
        Assert.assertEquals(ssn, ssnValue);
    }
    public void userEntersAllDataTillSNN() throws InterruptedException {
        titleRegistrationField.click();
        Select titleDropdown = new Select(titleRegistrationField);
        titleDropdown.selectByVisibleText("Ms.");
        firstNameRegistrationField.sendKeys(ConfigReader.getProperty("registration.first.name"));
        lastNameRegistrationField.sendKeys(ConfigReader.getProperty("registration.last.name"));
        genderFRadioButton.click();
        verifyUserCanEnterDOB("03/", "25/", "1992");
    }
    public void enterInvalidSSN(String invalidSSN) {
        ssnRegistrationField.sendKeys(invalidSSN);
    }


    public void verifyInvalidSSNErrorMessage() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOf(invalidSSNErrorMessage));

        Assert.assertTrue("Invalid format SSN message isn't displayed", invalidSSNErrorMessage.isDisplayed());
    }

}
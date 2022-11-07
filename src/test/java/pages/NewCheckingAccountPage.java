package pages;

import utilities.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCheckingAccountPage extends BasePage{

    @FindBy(id ="new-checking-menu-item")
    WebElement newChecking;

    @FindBy(xpath ="//strong[text()='New Checking Account']")
    WebElement newCheckingAccountHeader;


    @FindBy(xpath ="//strong[text()='Select Account Ownership']")
    WebElement selectAccountOwnership;

    @FindBy(id ="Individual")
    WebElement individualRadioButton;


    @FindBy(id ="Joint")
    WebElement jointRadioButton;

    @FindBy(xpath ="//input[@id='Standard Checking']")
    WebElement standardRadioButton;


    @FindBy(xpath ="//input[@id='Interest Checking']")
    WebElement interestRadioButton;

    @FindBy(xpath ="//strong[text()='Select Checking Account Type']")
    WebElement selectCheckingAccountTypeHeader;

    @FindBy(id="name")
    WebElement accountNameField;

    @FindBy(id ="new-account-error-alert")
    WebElement amountErrorMessage;

    @FindBy(id = "openingBalance")
    public WebElement initialDepositAmountField;

    @FindBy(id = "newCheckingReset")
    public WebElement resetButton;

    @FindBy(id = "newCheckingSubmit")
    public WebElement submitButton;

    @FindBy(id = "new-account-msg")
    public  WebElement successfullyMessage;

    public void clickOnNewChecking(){
        newChecking.click();
    }

    public void verifyNewCheckingAccountHeaderIsDisplayed(){
        Assert.assertTrue(newCheckingAccountHeader.isDisplayed());
    }

    public void verifySelectAccountOwnershipHeaderIsDisplayed(){
        Assert.assertTrue(selectAccountOwnership.isDisplayed());
    }

    public void verifyOwnershipRadioButtonsAreUnchecked(){

        Assert.assertFalse(individualRadioButton.isSelected() && jointRadioButton.isSelected());

    }

    public void verifyCheckingRadioButtonsAreUnchecked(){


        Assert.assertFalse(standardRadioButton.isSelected() && interestRadioButton.isSelected());

    }
    public void verifySelectCheckingAccountTypeHeaderIsDisplayed(){
        Assert.assertTrue(selectCheckingAccountTypeHeader.isDisplayed());
    }


    public void enterAccountName(){

        accountNameField.sendKeys(ConfigReader.getProperty("checking.account.name"));
    }
    public  void verifyIfAccountFieldHasText(){
        String accountName = accountNameField.getAttribute("value");
        Assert.assertEquals(ConfigReader.getProperty("checking.account.name"), accountName);

    }
    public void enterDepositAmount(String amount){

        initialDepositAmountField.sendKeys(amount );
    }
    public  void verifyIfEnteredAmountDisplayed(String amount){
        String enteredAmount = initialDepositAmountField.getAttribute("value");
        Assert.assertEquals(amount, enteredAmount);

    }
    public void enterInvalidAmount(String input){

        initialDepositAmountField.sendKeys(input );
    }
    public  void verifyErrorAmountMessage() {
        amountErrorMessage.isDisplayed();

    }

    public void clickOnStandardRadioButton(){
        standardRadioButton.click();
    }
    public void clickOnIndividualRadioButton(){
        individualRadioButton.click();
    }

    public void clickOnResetButton() {
        resetButton.click();
    }
    public void verifyAccountNameFieldIsEmpty(){

        String accountName = accountNameField.getAttribute("value");
        Assert.assertTrue(accountName.isEmpty());
    }

    public void verifyAmountFieldIsEmpty(){

        String amountField = initialDepositAmountField.getAttribute("value");
        Assert.assertTrue(amountField.isEmpty());
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void verifyUserGetSuccessfullyMessage(){
        Assert.assertTrue(successfullyMessage.isDisplayed());
    }

}


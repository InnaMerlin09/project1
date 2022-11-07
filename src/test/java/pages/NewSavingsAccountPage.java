package pages;
import utilities.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewSavingsAccountPage extends BasePage{


    @FindBy(xpath ="//strong[text()='New Savings Account']")
    WebElement newSavingsAccountHeader;

    @FindBy(xpath ="//strong[text()='Select Savings Account Type']")
    WebElement selectSavingsAccountTypeHeader;

    @FindBy(xpath ="//label[@for='Savings']")
    WebElement savingsRadioButton;

    @FindBy(xpath ="//label[@for='Money Market']")
    WebElement moneyMarketRadioButton;

    @FindBy(xpath ="//strong[text()='Select Account Ownership']")
    WebElement selectAccountOwnership;

    @FindBy(xpath ="//label[@for='Individual']")
    WebElement individualRadioButton;

    @FindBy(xpath ="//label[@for='Joint']")
    WebElement jointRadioButton;

    @FindBy(id="name")
    WebElement accountNameField;

    @FindBy(id ="new-account-error-msg")
    WebElement amountErrorMessage;

    @FindBy(id = "openingBalance")
    public WebElement initialDepositField;

    @FindBy(id = "newSavingsReset")
    public WebElement resetButton;

    @FindBy(id = "newSavingsSubmit")
    public WebElement submitButton;

    @FindBy(id = "new-account-msg")
    public  WebElement successfullyMessage;


    public void getSavingsPageURL(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(ConfigReader.getProperty("sp.url"), currentURL);
    }

    public void verifyNewSavingsAccountHeaderIsDisplayed(){
        Assert.assertTrue(newSavingsAccountHeader.isDisplayed());
    }


    public void verifySelectSavingsAccountTypeHeaderIsDisplayed(){
        Assert.assertTrue(selectSavingsAccountTypeHeader.isDisplayed());
    }
    public void verifySelectSavingsRadioButtonsAreUnchecked() {
        Assert.assertFalse(savingsRadioButton.isSelected() && moneyMarketRadioButton.isSelected());
    }
    public void verifySelectAccountOwnershipHeaderIsDisplayed(){
        Assert.assertTrue(selectAccountOwnership.isDisplayed());
    }
    public void verifyOwnershipRadioButtonsAreUnchecked(){

        Assert.assertFalse(individualRadioButton.isSelected() && jointRadioButton.isSelected());

    }
    public void getToAccountNameField(){
        accountNameField.click();

    }
    public void enterAccountName(){

        accountNameField.sendKeys(ConfigReader.getProperty("checking.account.name"));
    }
    public  void verifyIfAccountFieldHasText(){
        String accountName = accountNameField.getAttribute("value");
        Assert.assertEquals(ConfigReader.getProperty("checking.account.name"), accountName);

    }
    public void getToInputDepositField() {
        initialDepositField.click();
    }
    public void enterDepositAmount(String amount){

        initialDepositField.sendKeys(amount);
    }
    public  void verifyIfEnteredAmountDisplayed(String amount){
        String enteredAmount = initialDepositField.getAttribute("value");
        Assert.assertEquals(amount, enteredAmount);

    }
    public void enterInvalidAmount(String input){

        initialDepositField.sendKeys(input );
    }
    public  void verifyErrorAmountMessage() {
        amountErrorMessage.isDisplayed();

    }

    public void clickOnSavingsRadioButton(){
        savingsRadioButton.click();
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

        String amountField =  initialDepositField.getAttribute("value");
        Assert.assertTrue(amountField.isEmpty());
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void verifyUserGetSuccessfullyMessage(){
        Assert.assertTrue(successfullyMessage.isDisplayed());
    }

}



package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "home-menu-item")
    WebElement homeMenuItem;

    @FindBy(xpath ="//a[@id='checking-menu']")
    WebElement checkingDropdown;

    @FindBy(id ="view-checking-menu-item")
    WebElement viewChecking;

    @FindBy(id ="new-checking-menu-item")
    WebElement newChecking;


    @FindBy(id ="savings-menu")
    WebElement savingsDropdown;

    @FindBy(id ="view-savings-menu-item")
    WebElement viewSavings;

    @FindBy(id ="new-savings-menu-item")
    WebElement newSavings;

    public void verifyUserIsSignedInSuccessfully(){
        Assert.assertTrue("User is not on the Home Page",homeMenuItem.isDisplayed());
    }

    public void clickOnCheckingItem(){

        checkingDropdown.click();
    }

    public void verifyCheckingOptionsAreDisplayed(){

        Assert.assertTrue(viewChecking.isDisplayed()&&newChecking.isDisplayed() );

    }

    public void clickOnSavingsItem(){

        savingsDropdown.click();
    }

    public void verifySavingsOptionsAreDisplayed(){

        Assert.assertTrue(viewSavings.isDisplayed()&&newSavings.isDisplayed() );

    }
    public void userChooseNewSavingsOption(){
        newSavings.click();
    }
    public void clickOnViewSavingsAccount() {
        viewSavings.click();
    }


}

package pages;
import org.apache.hc.core5.http.Header;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class AllSavingsAccountPages extends BasePage {

    @FindBy(xpath = "//th[@data-field='date']")
    WebElement dateHeader;

    @FindBy(xpath = "//th[@data-field='category']")
    WebElement categoryHeader;

    @FindBy(xpath = "//th[@data-field='description']")
    WebElement descriptionHeader;

    @FindBy(xpath = "//th[@data-field='amount']")
    WebElement amountHeader;

    @FindBy(xpath = "//th[@data-field='balance']")
    WebElement balanceHeader;

    @FindBy(xpath = "//strong[contains(@class,Transactions)]")
    WebElement transactionsHeader;

    @FindBy(xpath = "//div[@class='col-md-6 col-lg-3'][1]")
    WebElement savingsAccountCard1;

    @FindBy(xpath = "//div[@class='col-md-6 col-lg-3']")
    WebElement savingsAccountCards;

    @FindBy(xpath = "//span[@class='switch-label']")
    WebElement toggleButtons;

    @FindBy(xpath = "//div[contains(text(), 'Balance:')]")
    WebElement balanceFromBox;

    @FindBy(xpath = "//td[5]")
    WebElement balanceInTable;

    public void verifyTransactionsHeaderIsDisplayed() {
        Assert.assertTrue("Transaction header isn't displayed", transactionsHeader.isDisplayed());
    }

    public void verifyDateHeaderIsDisplayed() {
        Assert.assertTrue("Date header isn't displayed", dateHeader.isDisplayed());
    }


    public void verifyCategoryHeaderIsDisplayed() {
        Assert.assertTrue("Category header isn't displayed", categoryHeader.isDisplayed());
    }

    public void verifyDescriptionHeaderIsDisplayed() {
        Assert.assertTrue("Description header isn't displayed", descriptionHeader.isDisplayed());
    }

    public void verifyAmountHeaderIsDisplayed() {
        Assert.assertTrue("Amount header isn't displayed", amountHeader.isDisplayed());
    }

    public void verifyBalanceHeaderIsDisplayed() {
        Assert.assertTrue("Balance header isn't displayed", balanceHeader.isDisplayed());

    }

    public void verifySavingsAccountCard1IsDisplayed() {
        Assert.assertTrue("savingsAccountCard1 isn't displayed", savingsAccountCard1.isDisplayed());
    }

    public void countAccountNumber() {
        List<WebElement> optionCount = driver.findElements(By.xpath("//div[@class='col-md-6 col-lg-3']"));
        System.out.println(optionCount.size());
    }

    public void verifyOnlyOneToggleButtonIsSelected() {

        List<WebElement> toggleButton = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(toggleButton.size());
        int count = 0;
        for (WebElement element : toggleButton) {
            if (element.isSelected())
                count++;
        }
        System.out.println(count);

        Assert.assertEquals("more than one toggle button is activated", 1, count);
    }

    public void verifyUserCanSeeSameAccountInformation() {
        String balance = "";

        List<WebElement> toggleButton = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element : toggleButton) {
            if (element.isSelected())

                balance = balanceFromBox.getText();
        }
        System.out.println(balance);
        String[] words = balance.split(" ");
        String amount = words[1].toString();
        System.out.println(amount);
        System.out.println(balanceInTable.getText());
        Assert.assertEquals(balanceInTable.getText(), amount);

    }


}
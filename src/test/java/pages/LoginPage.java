package pages;
import utilities.ConfigReader;
import utilities.DataBaseUtils;
import utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginPage extends BasePage {


    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;


    @FindBy(xpath = "//title[text()='Digital Bank']")
    public WebElement title;


    @FindBy(id = "submit")
    public WebElement signInButton;


    @FindBy(css = "a[href='/bank/signup']")
    public WebElement signUpHereLink;


    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    WebElement loginErrorMessage;


    public void verifyPageTitle() {
        Assert.assertEquals("Title is not the same", "Digital Bank", driver.getTitle());
    }

    public void verifySignInButtonIsDisplayed() {
        Assert.assertTrue(signInButton.isDisplayed());
    }

    public void doLogin() {

        username.sendKeys(ConfigReader.getProperty("login.username"));
        password.sendKeys(ConfigReader.getProperty("login.password"));

    }

    public void doLogin(String invalidUsername, String invalidPassword) {

        username.sendKeys(invalidUsername);
        password.sendKeys(invalidPassword + Keys.ENTER);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void verifyUserIsOnLoginPage() {

        Assert.assertTrue("User is not on the Home Page", signUpHereLink.isDisplayed());
    }

    public void clickSignUpLink() {
        signUpHereLink.click();
    }

    public void verifyLoginErrorMessageIsDisplayed() {

        Assert.assertTrue(loginErrorMessage.isDisplayed());
        System.out.println(loginErrorMessage.getText());
    }

    public void sampleMethodToRetrieveData() {
        // Retrieve result from database
        ResultSet result = DataBaseUtils.executeQuery("select first_name from employees limit 1;");
        // ResultSet result = DataBaseUtils.executeQuery("SELECT * FROM employees WHERE LENGTH(last_name)<=7 ORDER BY emp_id limit 5;");
// Use result to get the data
        String userName = null;
        try {
         /*   while (result.next()) {
                System.out.println(result.getString(2));
            }*/


            result.next();
            userName = result.getString(1);
            System.out.println(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Data does not match with UI", "Hosna", userName);

    }
}
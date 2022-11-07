package stepDefs;
import utilities.ConfigReader;
import utilities.DataBaseUtils;
import utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class Hooks {

    @Before
    public void setUp() throws Exception {
        ConfigReader.initProperties();
        Driver.createDriver();
        DataBaseUtils.initDatabase();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception{
        try {
            if (scenario.isFailed()) {

                File scrFile = ((TakesScreenshot)
                        Driver.getDriver()).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(scrFile, new File("target//screenshot.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("The error happened while taking screenshot and cleaning up after the test");
            e.getMessage();
        }
        Driver.getDriver().quit();
        DataBaseUtils.closeConnection();

    }
}
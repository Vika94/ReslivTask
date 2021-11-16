package driver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setupDriver() {
        DriverCreation.setDriver();
    }

    @AfterTest
    public void quitDriver() {
        DriverCreation.quitDriver();
    }
}
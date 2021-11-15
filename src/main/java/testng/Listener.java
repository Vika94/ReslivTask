package testng;

import driver.DriverCreation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import utils.PropertyReader;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(context.getSuite().getParameter("env") == null ? System.getProperties().getProperty("env") : context.getSuite().getParameter("env"));
        DriverCreation.createDriver();

    }

    @Override
    public void onFinish(ITestContext context) {
        DriverCreation.quitDriver();
    }
}
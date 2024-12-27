package base;

import io.appium.java_client.android.AndroidDriver;
import org.example.utilities.AppiumDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = AppiumDriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        AppiumDriverManager.quitDriver();
    }
}

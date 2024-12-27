package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class HomePage {
    private AndroidDriver driver;

    // Locators
    private By searchButton = By.id("com.android.tv.launcher:id/search");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}

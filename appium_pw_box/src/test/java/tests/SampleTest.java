package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.KeyEventUtils;

import java.util.List;

import static java.lang.Thread.sleep;

public class SampleTest extends BaseTest {

    @Test
    public void testSearchButton() {
        KeyEventUtils keyEventUtils = new KeyEventUtils(driver);
        keyEventUtils.pressHome();
        keyEventUtils.pressDown();
        WebElement currentElement = driver.switchTo().activeElement();
        System.out.println(currentElement.getText());
        WebElement parentElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.tvlauncher:id/items_list\").instance(1)"));
        List<WebElement> childElements = parentElement.findElements(By.className("android.widget.FrameLayout"));

// Iterate through the child elements or perform actions
        WebElement childElement;
        for (int i = 0; i < childElements.size(); i++)
        {
            childElement = childElements.get(i);
                if (childElement.getAttribute("focused").equalsIgnoreCase("true"))
                {
                    System.out.println("menu item found");
//                    new KeyEventUtils(driver).pressCenter();
                    break;
                }
        }
//        List<WebElement> firstItems =  driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\")"));
//        System.out.println(firstItem.getAttribute("focused"));
//        System.out.println(currentElement.getAttribute("focused"));
//        WebElement sourceRow = driver.findElement(By.xpath("//android.view.View[@resource-id=\"home:app_rail\"]/android.view.View/android.view.View[9]"));
//        System.out.println(sourceRow.getAttribute("focused").toLowerCase());
//        List<WebElement> list = driver.findElements(By.className("android.view.View"));
//        System.out.println(currentElement.);
    }

    @Test
    public void testFocused() {
        KeyEventUtils keyEventUtils = new KeyEventUtils(driver);
        keyEventUtils.pressHome();
        keyEventUtils.pressDown();
        keyEventUtils.pressDown();
        WebElement currentElement = driver.switchTo().activeElement();
        System.out.println(currentElement.getText());
        WebElement childElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().childSelector(\"new UiSelector().description(\"TÁI SINH - Tùng Dương (ST: Tăng Duy Tân) | Liveshow Người Đàn Ông Hát | Chìm vào trong ánh mắt...\").instance(1)\"))"));
    }


    protected void selectMenuItem(String itemName) throws Exception {

        boolean notAtMenuItem = true;
        int startTime;
        int timer;
        WebElement menuItemRoot;
        List<WebElement> menuItems;
        WebElement menuItem;
        String itemText;

        startTime = (int)(System.currentTimeMillis() / 1000);
        while (notAtMenuItem)
        {
            timer = (((int)(System.currentTimeMillis() / 1000))-startTime);
            if(timer>70)
            {
                throw new Exception("selecting menu item takes too long, fail");
            }
            menuItemRoot = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.tvlauncher:id/items_list\").instance(1)"));
            menuItems = menuItemRoot.findElements(By.className("android.widget.FrameLayout"));

            for (int i = 0; i < menuItems.size(); i++)
            {
                menuItem = menuItems.get(i);
                itemText = menuItem.getText().toLowerCase();
                if (itemText.contains(itemName.toLowerCase()))
                {
                    if (menuItem.getAttribute("focused").equalsIgnoreCase("true"))
                    {
                        System.out.println("menu item found");
                        new KeyEventUtils(driver).pressCenter();
                        notAtMenuItem = false;
                        break;
                    }
                }
            }
            if (notAtMenuItem)
            {
                new KeyEventUtils(driver).pressDown();
            }
            sleep(1);
        }
    }
}
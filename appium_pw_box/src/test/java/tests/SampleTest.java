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
        HomePage homePage = new HomePage(driver);
        KeyEventUtils keyEventUtils = new KeyEventUtils(driver);
        keyEventUtils.pressHome();
        keyEventUtils.pressDown();
//        keyEventUtils.pressDown();
//        keyEventUtils.pressDown();
//        keyEventUtils.pressRight();
//        keyEventUtils.pressRight();
//        keyEventUtils.pressRight();
//        keyEventUtils.pressRight();
//        keyEventUtils.pressRight();
//        keyEventUtils.pressRight();
//        keyEventUtils.pressRight();
        WebElement currentElement = driver.switchTo().activeElement();
        List<WebElement> firstItems =  driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\")"));
//        System.out.println(firstItem.getAttribute("focused"));
//        System.out.println(currentElement.getAttribute("focused"));
        WebElement sourceRow = driver.findElement(By.xpath("//android.view.View[@resource-id=\"home:app_rail\"]/android.view.View/android.view.View[9]"));
        System.out.println(sourceRow.getAttribute("focused").toLowerCase());
//        List<WebElement> list = driver.findElements(By.className("android.view.View"));
//        System.out.println(currentElement.);
    }


//    protected void selectMenuItem(String itemName) throws Exception {
//
//        boolean notAtMenuItem = true;
//        int startTime;
//        int timer;
//        WebElement menuItemRoot;
//        List menuItems;
//        WebElement menuItem;
//        String itemText;
//
//        startTime = (int)(System.currentTimeMillis() / 1000);
//        while (notAtMenuItem)
//        {
//            timer = (((int)(System.currentTimeMillis() / 1000))-startTime);
//            if(timer>70)
//            {
//                throw new Exception("selecting menu item takes too long, fail");
//            }
//            menuItemRoot = driver.findElement(By.id(resMenuItemsElement));
//            menuItems = menuItemRoot.findElements(By.id(resMenuItemElement));
//
//            for (int i = 0; i < menuItems.size(); i++)
//            {
//                menuItem = (WebElement) menuItems.get(i);
//                itemText = menuItem.getText().toLowerCase();
//                if (itemText.contains(itemName.toLowerCase()))
//                {
//                    if (menuItem.getAttribute("selected").toLowerCase().equals("true"))
//                    {
//                        System.out.println("menu item found");
//                        new KeyEventUtils(driver).pressCenter();
//                        notAtMenuItem = false;
//                        break;
//                    }
//                }
//            }
//            if (notAtMenuItem)
//            {
//                new KeyEventUtils(driver).pressDown();
//            }
//            sleep(1);
//        }
//    }
}
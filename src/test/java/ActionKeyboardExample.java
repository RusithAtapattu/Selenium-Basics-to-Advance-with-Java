import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void KeyboardOperationsTestsBrowserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void KeyboardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
//        googleSearchTextBox.sendKeys("Welcome");
//
        Actions actions = new Actions(driver);
//        //Select the text
//
////        Action storingBuildOperation = actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build();
////        storingBuildOperation.perform();
//        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
//
//        Thread.sleep(4000);
//
//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("Writing capital sentence").perform();
//        Thread.sleep(4000);
//
//        actions.keyUp(Keys.SHIFT)
//                .keyDown(Keys.COMMAND)
//                .sendKeys("a")
//                .keyUp(Keys.COMMAND)
//                .keyDown(Keys.COMMAND)
//                .sendKeys("x")
//                .build().perform();

        //To write capital in a text box
        actions.keyDown(googleSearchTextBox,Keys.SHIFT)
                .sendKeys("davey jones")
                .perform();
    }

    @Test
    public void KeyboardActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is " + size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();
    }
}

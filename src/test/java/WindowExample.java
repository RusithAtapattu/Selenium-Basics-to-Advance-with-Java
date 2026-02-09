import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {

    WebDriver driver;

    @BeforeMethod
    public void WindowTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void windowTests() throws InterruptedException {
        //01) Click and Confirm new Window Opens

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window : " + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles =  driver.getWindowHandles();
        System.out.println("Handles size " + handles.size());

        // First method - Using forEach loop

        for (String newWindow : handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is : " + driver.getTitle());
        }

        driver.close();

        driver.switchTo().window(oldWindow);

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openButtonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility " + openButtonVisibility);

        // Second method - Using List

//        List<String> list = new ArrayList<String>(handles); // Converting set to lists
//        if (list.size() > 1){
//            driver.switchTo().window(list.get(1));
//            System.out.println("Child tab title is : " + driver.getTitle());
//            driver.close();
//            driver.switchTo().window(oldWindow);
//        }
//
//        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
//        boolean openButtonVisibility = openButton1.isDisplayed();
//        System.out.println("Open button visibility " + openButtonVisibility);


        //02) Find the number of opened tabs

        WebElement multiWindowButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int howManyWindows = multiWindows.size();
        System.out.println("No of windows opened " + howManyWindows);


        //03) Close all windows except Primary
        WebElement dontCloseMeButton = driver.findElement(By.id("j_idt88:j_idt93"));
        dontCloseMeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for (String allWindows : newWindowsHandles){
            if (!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }

//        driver.switchTo().window(oldWindow);
//        driver.close();
    }
}

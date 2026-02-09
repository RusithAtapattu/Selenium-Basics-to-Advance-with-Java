import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenFileTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        Thread.sleep(3000);
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("/Users/rusithatapattu/Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFile:totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }
    }


    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st way - Using Robot class
//        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadButton.click();
//
//        //Mac control begins here
//
//        String data = "/Users/rusithatapattu/Downloads/beautiful.png";
//        StringSelection selection = new StringSelection(data);
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
//
//        Thread.sleep(4000);
//        Robot robot = new Robot();
//        // COMMAND + V (⌘ + V)
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_META);
//
//        // Press ENTER
//        Thread.sleep(4000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        //2nd way - Using Send Keys (Applicable only element type is file )

        String data = "/Users/rusithatapattu/Downloads/beautiful.png";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);

    }



}

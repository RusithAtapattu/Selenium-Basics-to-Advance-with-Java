import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void FrameTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
        Thread.sleep(1000);
    }

    @Test
    public void frameTests(){
        //01) Click Me (Inside frame)

        driver.switchTo().frame(0);

        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click inside frame button text : " + afterClickButtonText);


        //02) Click Me (Inside Nested frame)

        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);     //Inside into 3rd frame
        driver.switchTo().frame("frame2");      //Inside into 3rd frame > Child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After click inside Nested frame button text : " + afterClickNestedFrameButtonText);


        //03) How many frames in this page?

        driver.switchTo().defaultContent();

        List<WebElement> getIframeTagCount =  driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("Iframe tag count : " + size);

        for (WebElement iframeElement :getIframeTagCount){
            String frameSRCAttributeValue = iframeElement.getAttribute("src");
            System.out.println("Frame SRC attribute value : " + frameSRCAttributeValue);
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenImagePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void findBrokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images =  driver.findElements(By.xpath("//div[@class='example']/img"));

        // "Natural width" = '0'

        int i = 1;
        for (WebElement image:images){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " + i + " is broken");
            } else {
                System.out.println("Image " + i + " is not broken");
            }
            i++;
        }
    }

    @Test
    public void findBrokenImageTest2(){
        driver.get("https://demoqa.com/broken");
        WebElement brokenImage = driver.findElement(By.xpath("//img[2]"));
        if (brokenImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image is broken");
        } else {
            System.out.println("Image is not broken");
        }
    }
}

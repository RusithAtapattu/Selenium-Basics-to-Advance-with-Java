import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void DropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void leafgroundpageDropDownTest() throws InterruptedException {
        // 1.1) ways of select values in Basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);


        // 1.2) Get the number of dropDown options
        //Generics
        List<WebElement> listOfOptions = select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of elements in dropdown :" + size);

        for (WebElement element:listOfOptions){
            System.out.println(element.getText());
        }


        // 1.3) using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);


        // 1.4) Selecting value in a Bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listOfDropDown2Values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listOfDropDown2Values){
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")){
                element.click();
                break;
            }
        }
    }


//2) Google Search - pick a value from suggestions
    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(3000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']//li//span"));
        System.out.println(googleSearchList.size());
        for (WebElement element : googleSearchList){
            System.out.println(element.getText());
        }
    }


//3) Handle Hidden Auto Suggestions Drop Down And Search using DOM Debugger Trick

}

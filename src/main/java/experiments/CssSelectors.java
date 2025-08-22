package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement footer = driver.findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());
        pause(1);

        //WebElement divElements = driver.findElement(By.className("card-up")); //*[class='card-up']
        //WebElement divElements = driver.findElement(By.cssSelector(".card-up"));
        //WebElement divElements = driver.findElement(By.cssSelector("*[class='card-up']"));
        WebElement divElements = driver.findElement(By.cssSelector("div[class='card-up']"));
        divElements.click();

        //WebElement btnRadioButton = driver.findElement(By.id("item-2"));
        WebElement btnRadioButton = driver.findElement(By.cssSelector("*[id='item-2']"));
        btnRadioButton.click();

        //WebElement btnImpressive = driver.findElement(By.id("impressiveRadio"));
        WebElement btnImpressive = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        btnImpressive.click();
        pause(1);

        WebElement btnButtons = driver.findElement(By.cssSelector("li[id='item-4']"));
        btnButtons.click();
        pause(1);

        //WebElement btnDoubleClick = driver.findElement(By.id("doubleClickBtn"));
        //WebElement btnDoubleClick = driver.findElement(By.cssSelector("#doubleClickBtn"));
        WebElement btnDoubleClick = driver.findElement(By.cssSelector("button[id='doubleClickBtn']"));
        btnDoubleClick.click();
        pause(1);


        //driver.close();
        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

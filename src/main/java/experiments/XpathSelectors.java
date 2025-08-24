package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsRadioButtonPage(){
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

        //WebElement btnImpressive = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        WebElement btnImpressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        btnImpressive.click();
        pause(1);

        driver.get("https://demoqa.com/");
        hideBanner();
        hideFooter();
        //WebElement divBookStore = driver.findElement(By.cssSelector("div[class='category-cards'] div[class='card mt-4 top-card']:last-child"));
        WebElement divBookStore = driver.findElement(By.xpath("//div[@class='category-cards']//div[@class='card mt-4 top-card'][last()]"));
        divBookStore.click();
        pause(1);

        driver.navigate().back();
        pause(1);

        WebElement divTextBox = driver.findElement(By.cssSelector("div[class='category-cards'] div[class='card mt-4 top-card']:nth-child(2)"));
        divTextBox.click();

        WebElement btnPracticeForm = driver.findElement(By.xpath("//*[text()='Practice Form']"));
        btnPracticeForm.click();
        pause(1);

        driver.quit();
    }

    private void hideBanner(){
        JavascriptExecutor jg = (JavascriptExecutor) driver;
        jg.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    private void hideFooter(){
        JavascriptExecutor jg = (JavascriptExecutor) driver;
        jg.executeScript("document.querySelector('footer').style.display='none'");
    }

    @Test
    public void selectorsTextBox(){
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();
        WebElement fullName = driver.findElement(By.xpath("//*[@id='userName-label']"));
        WebElement inputFullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@type='email']"));
        inputEmail.sendKeys("monkey@gmail.com");
        WebElement textareaCurAdd = driver.findElement(By.id("currentAddress"));
        textareaCurAdd.sendKeys("Monkey Street 1");
    }

    public void pause(int time) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

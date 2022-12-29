import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MySeleniumTest {

    @Test
    @DisplayName("Отображение окна с результатом")
    public void getResult() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement buttonElements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div"));
        buttonElements.click();

        WebElement buttonTextBox = driver.findElement(By.id("item-0"));
        buttonTextBox.click();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Tester");

        WebElement eMail = driver.findElement(By.id("userEmail"));
        eMail.sendKeys("tester@tosters.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Somewhere in nowhere.");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("The same.");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView();", buttonSubmit);
        buttonSubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement outputBox = driver.findElement(By.id("output"));
//        boolean isShowOutput = outputBox.isDisplayed();
        boolean isShowOutput = driver.findElement(By.id("output")).isDisplayed();

        Assertions.assertTrue(isShowOutput, "Окно с результатом отобразилось");
    }

}

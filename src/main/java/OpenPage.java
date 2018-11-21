import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

class OpenPage {

    private WebDriver driver;

    OpenPage(WebDriver driver) { this.driver = driver; }

    @Step("Открываем страницу \"{0}\"")
    void checkLink(String s) {
        WebElement link =  driver.findElement(By.linkText(s));
        Assert.assertEquals("Error", s, link.getText());
        link.click();
    }

    @Step("Навести мышкой \"{0}\"")
    void moveTo(String s) {
        new Actions(driver).moveToElement(driver.findElement(By.xpath(".//div[@class='my-ozon']"))).perform();

    }

    @Step("Нажать кнопку \"{0}\"")
    void button(String s) {
        if ("Вход в систему".equals(s)) {
            WebElement button = driver.findElement(By.id("sgnBt"));
            button.click();
        }

    }


}

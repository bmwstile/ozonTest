import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    @Step("Логинимся \"{0}\" , вводим пароль \"{1}\"")
    void login(String login, String password) throws InterruptedException {
        driver.findElement(By.xpath(".//input[@type='text']")).sendKeys(login);
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//input[@type='password']")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//button[@class='blue button full-width submit-button big auth']")).click();

    }

}

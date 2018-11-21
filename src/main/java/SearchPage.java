import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    public SearchPage(WebDriver driver) { this.driver = driver; }

    @Step("Выполняем поиск \"{0}\" ")
    void search(String Text) throws InterruptedException {
        driver.findElement(By.xpath(".//input[@type='text']")).sendKeys(Text);
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//button[@data-test-id='header-search-go']")).click();

    }

}

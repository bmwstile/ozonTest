import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BasketPage {
    private WebDriver driver;
    public BasketPage(WebDriver driver) { this.driver = driver; }

    @Step("Добавить в корзину")
    void addToBasket() throws InterruptedException {

        List<WebElement> div = driver.findElements(By.xpath(".//div[@class=\"item-wrapper\"]/div"));
        Thread.sleep(2000);
        System.out.println("List size is: " + div.size());

        for (int x = div.size()-2; x > 0 ;x=x-2) {

          //  String num = String.format(".//div[@class='item-wrapper']/div[@data-key='%s']/div/div[@class='tile-actions']/div[@class='sale-block']/button/span[contains(text(),'корзину')]", x);
            if(driver.findElements(By.xpath(".//div[@class='item-wrapper']/div[@data-key='"+x+"']/div/div[@class='tile-actions']/div[@class='sale-block']/button/span[contains(text(),'корзину')]")).size()>0)
                {
                    driver.findElement(By.xpath(".//div[@class='item-wrapper']/div[@data-key='"+x+"']/div/div[@class='tile-actions']/div[@class='sale-block']/button/span[contains(text(),'корзину')]")).click();
                    Thread.sleep(500);
                    System.out.print(x);
                    System.out.print("\n");
                }
                else x=x-2;
        }


    }

    @Step("Удалить все из корзины")
    void removeFromBasket() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(By.xpath(".//div[@class='bIconButton mRemove mGray jsRemoveAll']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//div[@class='eRemovedCartItems_removeAll jsRemoveAll']")).click();
        Thread.sleep(5000);

        if(driver.findElement(By.xpath(".//div[@class='bIconButton mRemove mGray jsRemoveAll']")).isDisplayed())
            {
                driver.findElement(By.xpath(".//div[@class='bIconButton mRemove mGray jsRemoveAll']")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath(".//div[@class='eRemovedCartItems_removeAll jsRemoveAll']")).click();
            }

    }

    @Step("Проверка что корзина пуста")
    void chekBasket() throws InterruptedException {

        Assert.assertTrue(driver.findElement(By.xpath(".//span[contains(text(),'пуста')]")).isDisplayed());
    }

}

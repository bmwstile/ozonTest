import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

@Title("Тестовое задание")
public class ozonTest {

    private WebDriver driver;

    @Step("Открытие ссылок")
    private void openPage(String s) {
        OpenPage openPage = new OpenPage(driver);
        openPage.checkLink(s);
    }

    @Step("Нажать на кнопку")
    private void clickOnButton(String s) {
        OpenPage openPage = new OpenPage(driver);
        openPage.button(s);
    }

    @Step("Логин")
    private void loginPage(String login, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
    }

    @Step("Поиск")
    private void searchPage(String Text) throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(Text);
    }

    @Step("Корзина")
    private void basketPage() throws InterruptedException {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.addToBasket();
    }

    @Step("Разлогиниться")
    private void Logout() throws InterruptedException {
        Logout logout = new Logout(driver);
        logout.exit();
    }

    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        //FirefoxDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        //driver = new InternetExplorerDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void exit() {
        driver.quit();
    }

    @Test
    @Title("Ozon")
    public void testOzonTask() throws InterruptedException {
        OpenPage openPage = new OpenPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        driver.get("http://www.ozon.ru/");

        openPage.checkLink("Заказы");
        openPage.checkLink("Войти по почте");
        loginPage("ivanovivanbmw@lenta.ru", "Test1234567890");
        Thread.sleep(2000);

        searchPage("Iphone");
        basketPage();

        ((JavascriptExecutor)driver).executeScript("scroll(0,-1000)");

        driver.findElement(By.xpath(".//span[contains(text(),'Корзина')]")).click();

        basketPage.removeFromBasket();

        Logout();

        openPage.checkLink("Заказы");
        openPage.checkLink("Войти по почте");
        loginPage("ivanovivanbmw@lenta.ru", "Test1234567890");
        Thread.sleep(2000);


        driver.findElement(By.xpath(".//span[contains(text(),'Корзина')]")).click();

        basketPage.chekBasket();




    }


}
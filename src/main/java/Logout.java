import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Logout {
    private WebDriver driver;
    public Logout(WebDriver driver) { this.driver = driver; }

    void exit()
    {
        new Actions(driver).moveToElement(driver.findElement(By.xpath(".//div[@class='eMyOzon_Item_Bottom bTextLink' and contains(text(),'Иван')]"))).perform();
        driver.findElement(By.xpath(".//div[@class='ePanelLinks_term jsOption  jsClearTilesFromStorage jsLogOff jsBottomPart']")).click();
    }
}

package Search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class productSearch {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","/Users/santana/Workspace/qa-challenge/ui_tests/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void CT006_searchType() throws Exception {
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.isDisplayed();
        searchField.sendKeys("blouse");

        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.xpath("//img[@alt='Blouse']")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

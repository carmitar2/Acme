package Demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Test2
{
    private static WebDriver driver;
    private String baseUrl;
    //---------------------------
    //---------------------------

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QH-01\\Documents\\Projects\\Acme\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.acme.qualityhouse.bg/build3/index.php?page=login";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testAcmeLogin()
    {
        driver.findElement(By.name("username")).sendKeys("student1");
        driver.findElement(By.name("userpass")).sendKeys("stpass1");
        driver.findElement(By.name("ses_login")).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("http://www.acme.qualityhouse.bg/build3/index.phpp", URL );
    }

    @Test
    public void second()
    {
        System.out.println("Test");
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.close ();
    }
}

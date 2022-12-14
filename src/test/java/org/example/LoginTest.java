package org.example;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    @BeforeClass
   public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void Test1() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        /*тут будет наш тест*/
        profilePage.clickNotionBtm();
        profilePage.inputZametka("hochy denyak");
        profilePage.setPushBtm();
        String user = profilePage.getUserName();
        String notion = profilePage.getNotionText();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);
        Assert.assertEquals(ConfProperties.getProperty("notion"), notion);
        driver.quit();
        }

}
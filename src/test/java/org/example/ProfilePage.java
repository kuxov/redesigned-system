package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(@href, '/post')]")
    private WebElement notionBtm;

    @FindBy(xpath = "//*[contains(@class, 'user-link o')]")
    private WebElement userName;

    public void clickNotionBtm(){
        notionBtm.click();
    }
    public String getUserName() {
        String name = userName.getText();
        return name;
    }

}

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

    //@FindBy(xpath = "//*[@id=\"hook_Block_pfnull\"]/div[2]/div[1]/div/div/div[2]")
    @FindBy(xpath = "//*[contains(@class, 'posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler')]")
    private WebElement zametkaField;

    @FindBy (xpath = "//*[contains(@data-l, 't,button.submit')]")
    WebElement pushBtm;

    public void inputZametka(String passwd) {
        zametkaField.sendKeys(passwd); }

    public void clickNotionBtm(){
        notionBtm.click();
    }
    public String getUserName() {
        String name = userName.getText();
        return name;}


        public void setPushBtm() {
        pushBtm.click();
    }

}

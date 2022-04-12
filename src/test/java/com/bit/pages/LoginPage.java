package com.bit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(name ="email")
    WebElement elmEmail;

    @FindBy(name ="password")
    WebElement elmPassword;

    @FindBy(xpath ="//span[text()='Login']")
    WebElement elmLogin;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setEmail(String email)
    {
        elmEmail.sendKeys(email);
    }

    public void setPassword(String password)
    {
        elmPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        elmLogin.click();
    }

    public void login(String email,String password)
    {
        System.out.println("In login()");
       setEmail(email);
       setPassword(password);
       clickLogin();
    }



}

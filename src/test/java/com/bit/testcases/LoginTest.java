package com.bit.testcases;

import com.bit.base.BaseTest;
import com.bit.pages.LoginPage;

import com.bit.utilities.TestUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

//    @Test
//    @Parameters({"email", "password"})
//    public void loginTest(String email,String password)
//    {
//        System.out.println("In LoginTest");
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.login(email,password);
//
//    }

    @Test(dataProviderClass= TestUtil.class,dataProvider="dp")
    public void loginTest(Hashtable<String,String> data)
        {
            System.out.println("In LoginTest");
            String email = data.get("email");
            String password = data.get("password");

            LoginPage loginPage = new LoginPage(driver);

            loginPage.login(email, password);

        }


}

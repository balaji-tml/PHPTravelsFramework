package com.bit.base;

import com.bit.utilities.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static FileInputStream fis;
    public static Properties config;
    public static Properties or;
    public static ExcelReader excel;
    public static String userDir = System.getProperty("user.dir");




    @BeforeSuite
    public void setUp() throws IOException {

        config = new Properties();
        or = new Properties();
        excel =  new ExcelReader(userDir + "/src/test/resources/com/bit/testdata/Testdata.xlsx");
        String browser,appurl;
        if(driver == null)
        {
            fis = new FileInputStream(userDir + "/src/test/resources/com/bit/properties/config.properties");
            config.load(fis);
            fis = new FileInputStream(userDir + "/src/test/resources/com/bit/properties/or.properties");
            or.load(fis);
            if(config.getProperty("browser").equals("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/com/bit/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
            driver.get(config.getProperty("appurl"));
            System.out.println("Page title: "+driver.getTitle());

        }

    }

    @AfterSuite
    public void tearDown()
    {
        if(!(driver == null))
        {
            driver.quit();
        }
    }




}

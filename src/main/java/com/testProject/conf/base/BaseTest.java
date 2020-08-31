package com.testProject.conf.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @Parameters({"isClean"})
    @BeforeSuite(alwaysRun=true)
    public void setUpSuite(@Optional("false") String isClean){
        if (isClean.equals("true")) { Utils.deleteLogFile(); } //delete file with emails if parameter is true
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx) {

        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        DriverFactory factory = new DriverFactory(browser, log);
        driver = factory.createDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .pageLoadTimeout(30, TimeUnit.SECONDS)
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

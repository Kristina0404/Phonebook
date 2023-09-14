package org.ait.phonebook;

import org.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

   // @AfterMethod ()
    @AfterSuite
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod
    public void startTest (Method m,Object[] p){
        // метод m даёт возможность увидеть название тестируемого метода
        logger.info("Start test" + m.getName()+ " with data: " + Arrays.asList(p));
    }
    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: "+ result.getMethod().getMethodName() + 
                    " Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.error("*******************************");
    }

}
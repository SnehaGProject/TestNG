package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.configReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class baseClass {

    public static WebDriver driver;
    public configReader prop;


    //for extent reports
    public ExtentReports extent ;
    public ExtentTest test;

    // for extent Reports
    @BeforeSuite
    public void setupReport(){
         ExtentSparkReporter spark  =new ExtentSparkReporter("Reports/extentReport.html") ;
         extent=new ExtentReports();
         extent.attachReporter(spark);

    }

    @BeforeTest
    public void setUp() {
         prop = new configReader();
    }

    @BeforeClass
    public void setup() {
//        String browser = prop.getProperty("browser");
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        test = extent.createTest(method.getName());
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(configReader.getProperty("url"));
    }






    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed");
            String screenshotPath=takeScreenshot(result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        }else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped");
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @AfterTest
    public void afterTest() {}


    @AfterMethod
    public void teardown(){
        if(driver !=null){
            driver.quit();
            System.out.println("closed browser");
        }
    }

    @AfterSuite
    public void teardownReport(){
        extent.flush();
    }


    private String takeScreenshot(String testName ) throws IOException {
        TakesScreenshot ts=((TakesScreenshot)driver);
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        String destFile="screenshot/"+testName+".png";

        FileUtils.copyFile(srcFile,new File(destFile));
        System.out.println("Screenshot saved successfully of test :"+testName+"as it failed");

        driver.quit();
        return destFile;

    }


}

package listeners;

import base.baseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import static base.baseClass.driver;

public class testListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started:  " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed:  " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed:  " + result.getName());
//        try {
//            takeScreenshot(result.getName());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped:  " + result.getName());
    }


}

package independentTestingSuite.support.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import independentTestingSuite.support.GetScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestListener extends ExtentITestListenerAdapter {
    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        super.onFinish(iTestContext);
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        ExtentTest failedTestNode = ExtentTestManager.getTest().createNode("Error Log");
        failedTestNode.fail(iTestResult.getThrowable());
        failedTestNode.fail("Screenshot",
                        GetScreenshot.getScreenCaptureForReport("Failed Test " + System.currentTimeMillis()));
    }

    @Override
    public synchronized void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        super.onTestFailedButWithinSuccessPercentage(iTestResult);
    }
}

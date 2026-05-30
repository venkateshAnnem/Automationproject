package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaeClassPage.java.BaseClass;

public class ExtentReports implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private com.aventstack.extentreports.ExtentReports extent;

    // Thread-safe test instance
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private String reportName;

    @Override
    public void onStart(ITestContext context) {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Date());

        reportName = "Test-Report-" + timestamp + ".html";

        String reportPath = System.getProperty("user.dir")
                + File.separator + "reports" + File.separator + reportName;

        sparkReporter = new ExtentSparkReporter(reportPath);

        sparkReporter.config().setDocumentTitle("Swag Labs Report");
        sparkReporter.config().setReportName("Swag Labs Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = context.getCurrentXmlTest().getParameter("os");
        String browser = context.getCurrentXmlTest().getParameter("browser");

        extent.setSystemInfo("Operating System", os != null ? os : "Unknown");
        extent.setSystemInfo("Browser", browser != null ? browser : "Unknown");

        List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
        if (!groups.isEmpty()) {
            extent.setSystemInfo("Groups", groups.toString());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(Status.PASS,
                result.getName() + " executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL,
                result.getName() + " got failed");

        test.get().log(Status.FAIL,
                result.getThrowable());

        try {
            if (BaseClass.driver != null) {
                String path = BaseClass.captureScreen(result.getName());
                test.get().addScreenCaptureFromPath(path);
            }
        } catch (Exception e) {
            test.get().log(Status.WARNING,
                    "Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log(Status.SKIP,
                result.getName() + " got skipped");

        if (result.getThrowable() != null) {
            test.get().log(Status.INFO, result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        String pathOfExtentReport = System.getProperty("user.dir")
                + File.separator + "reports"
                + File.separator + reportName;

        try {
            Desktop.getDesktop().browse(new File(pathOfExtentReport).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
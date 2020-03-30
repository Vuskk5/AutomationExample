package kfirPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewStyle;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static String reportPath = System.getProperty("user.dir")+ "\\TestReport";
    private static String screenShotsPath = reportPath + "\\Screenshots";

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    private static void createInstance() {
        String fileName = getReportFileLocation();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName, ViewStyle.DEFAULT);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle(fileName);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTimeStampFormat("hh:mm:ss a | dd.MM.yyyy");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Select the extent report file location based on platform
    private static String getReportFileLocation() {
        createPath(reportPath);
        System.out.println("ExtentReport Path: " + reportPath + "\n");
        return reportPath;
    }

    public static String getScreenShotsPath() {
        createPath(screenShotsPath);
        return screenShotsPath;
    }

    // Create the report path if it does not exist
    private static void createPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
//                System.out.println("Directory: " + path + " is created!" );
            } else {
//                System.out.println("Failed to create directory: " + path);
            }
        } else {
//            System.out.println("Directory already exists: " + path);
        }
    }
}

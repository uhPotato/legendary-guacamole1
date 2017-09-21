package Utils;

/**
 * Created by idorovskikh on 2/6/17.
 */
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utils.BaseTest.driver;

public class ScreenshotUtility implements ITestListener {
    // This method will execute before starting of Test suite.
//this method takes the directory name as a parameter
    private static boolean deleteDir(File dir) {
        //check if it is a directory
        if (dir.isDirectory()) {
            //creates an array of strings with files and directories names
            String[] children = dir.list();
            // makes sure it is not empty
            assert children != null;
            //goes through the loop and deletes files and directories
            for (String aChildren : children) {
                boolean success = deleteDir(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }
        // delete directory
        // -r
        return dir.delete();
    }

    public void onStart(ITestContext tr) {
        deleteDir(new File("screenshots"));
    }

    // This method will execute, Once the Test suite is finished.
    public void onFinish(ITestContext tr) {

    }

    // This method will execute only when the test is pass.
    public void onTestSuccess(ITestResult tr) {
        captureScreenShot(tr, "pass");
    }

    // This method will execute only on the event of fail test.
    public void onTestFailure(ITestResult tr) {
        captureScreenShot(tr, "fail");
    }

    // This method will execute before the main test start (@Test)
    public void onTestStart(ITestResult tr) {

    }

    // This method will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult tr) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
    }

    // Function to capture screenshot.
    private void captureScreenShot(ITestResult result, String status) {
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
        // To capture screenshot.
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        // Create simpleDateFormat for screenshot's file name
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // If status = fail then set folder name "screenshots/Failures"
        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        }
        // If status = pass then set folder name "screenshots/Success"
        // If test case passes paste screenshot to folder name "screenshots/Success" - Kristina, Anton
        else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }

        // To create folder to store screenshots
        // Folders "screenshots/Success" and "screenshots/Failures" are created - Kristina, Anton
        new File(destDir).mkdirs();
        // Set file name with combination of test class name + date time.
        // Giving a name with pass or fail, datestamp and png format - Kristina, Anton
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";

        try {
            // Store file at destination folder location
            // Save created file in the selected folder - Kristina, Anton
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


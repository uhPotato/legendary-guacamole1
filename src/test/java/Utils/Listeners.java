package Utils;

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

/**
 * Created by borisgurtovyy on 10/12/17.
 */
public class Listeners implements ITestListener{


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            captureScreenShot(iTestResult, "pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            captureScreenShot(iTestResult, "fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
            deleteDir(new File("screenshots"));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void captureScreenShot(ITestResult result, String status) throws IOException {
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();

        // To capture a screenshot
        File scrFile = driver.getScreenshotAs(OutputType.FILE);

        // this is only pattern of date
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        // if status was fail
        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        }
        // if status was pass
        else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }

        new File(destDir).mkdir();

        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";


        FileUtils.copyFile(scrFile, new File(destDir + "/" +destFile));

    }

    private static boolean deleteDir(File dir){
        // check if it is a directory

        if ( dir.isDirectory()) {
            // creates an array of strings with files and directories names
            String[] children = dir.list();

            // make sure it is not empty
            assert children != null;

            // go through all files and dirs and delete them
            for( String aChildren : children){
                boolean success = deleteDir(new File(dir, aChildren));
                if(!success){
                    return false;
                }
            }
        }
        return dir.delete();
    }

}

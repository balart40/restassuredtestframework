package applications.hogwartsschool.tests;

import applications.hogwartsschool.request.RequestFactory;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import org.balartinc.utils.ConfigUtil;
import org.balartinc.utils.ExtentReportUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseTest {
    String configFileName;

    String currentWorkingDirectory;

    Properties configProperties;
    RequestFactory requestFactory;

    String htmlReportFileName;

    ExtentReportUtils extentReport;

    @BeforeSuite
    public void preSetup() throws Exception {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/src/test/resources/config/config.properties";
        configProperties = ConfigUtil.readConfigProperties(configFileName);
        htmlReportFileName = currentWorkingDirectory + "/src/test/resources/reports/htmlReport.html";
        extentReport = new ExtentReportUtils(htmlReportFileName);
    }

    @BeforeClass
    public void setup() {
        extentReport.createTestCase("Setup - Load config");
        RestAssured.baseURI = configProperties.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(configProperties.getProperty("portNumber"));
        requestFactory = new RequestFactory();
        extentReport.addLog(Status.INFO, "BaseUrl: " + configProperties.getProperty("baseUrl"));
        extentReport.addLog(Status.INFO,"Port: "
                + Integer.parseInt(configProperties.getProperty("portNumber")));
    }

    @AfterClass
    public void cleanUp(){
        RestAssured.reset();
        extentReport.closeReports();
    }

    @AfterMethod
    public void postTestCheck(ITestResult testResult) {
        String testName = testResult.getName();
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            extentReport.addLog(Status.PASS, "All Test step Passed");
        } else if(testResult.getStatus() == ITestResult.FAILURE) {
            extentReport.addLog(Status.FAIL, "One or more test step failed");
        } else {
            extentReport.addLog(Status.SKIP, "One or more test step skipped");
        }
    }

}

package applications.hogwartsschool;

import applications.hogwartsschool.request.RequestFactory;
import io.restassured.RestAssured;
import org.balartinc.utils.ConfigUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseTest {
    String configFileName;

    String currentWorkingDirectory;

    Properties configProperties;
    RequestFactory requestFactory;

    @BeforeSuite
    public void preSetup() throws Exception {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/src/test/resources/config/config.properties";
        configProperties = ConfigUtil.readConfigProperties(configFileName);
    }

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = configProperties.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(configProperties.getProperty("portNumber"));
        requestFactory = new RequestFactory();
    }

    @AfterClass
    public void cleanUp(){
        RestAssured.reset();
    }

}

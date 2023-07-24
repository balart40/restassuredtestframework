package applications.hogwartsschool;

import applications.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class GetTests extends BaseTest {

    @Test
    void test_getStudentsSuccessful() {
        log.info("Starting Test...");

        Response response = RestAssured.get(url);

        log.info(response.getBody().asString());
    }
}

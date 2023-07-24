package applications.hogwartsschool;

import applications.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static applications.contants.StatusCode.OK_200;
import static io.restassured.RestAssured.given;

@Slf4j
public class GetTests extends BaseTest {

    @Test
    void test_getStudentsSuccessful() {
        log.info("Starting Test...");

        given()
                .get(url)
        .then()
                .log().body()
                .statusCode(OK_200);

        log.info("Test finished successfully...");
    }
}

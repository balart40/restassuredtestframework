package applications.hogwartsschool.tests;

import applications.hogwartsschool.StudentPojo;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static applications.constants.StatusCode.OK_200;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Slf4j
public class StudentTests extends BaseTest {

    @Test
    void test_getStudentsSuccessful() {
        log.info("Starting Test: test_getStudentsSuccessful...");

        given()
                .get("http://localhost:8080/api/v1/student")
        .then()
                .log().body()
                .statusCode(OK_200);

        log.info("Test finished successfully...");
    }

    @Test
    void test_getStudentByIdSuccessfulById() {
        log.info("Starting Test: test_getStudentByIdSuccessfulById...");
        Response response = requestFactory.getStudentById(1L);
        response.then()
                .log().body()
                .statusCode(OK_200)
                .assertThat()
                .body("name", equalTo("Harry Potter"))
                .body("email", equalTo("harrypotter@hotmail.com"))
                .body("house", equalTo("Gryffindor"));
        log.info("Test finished successfully...");
    }

}

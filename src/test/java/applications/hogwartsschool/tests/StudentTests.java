package applications.hogwartsschool.tests;

import applications.hogwartsschool.BaseTest;
import applications.hogwartsschool.StudentPojo;
import applications.hogwartsschool.request.RequestFactory;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static applications.constants.StatusCode.OK_200;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@Slf4j
public class StudentTests extends BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUri;
        RestAssured.port = port;
        requestFactory = new RequestFactory();
    }

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
    void  test_getStudentByIdSuccessful() {
        /*
        {
            "id": 1,
                "name": "Harry Potter",
                "email": "harrypotter@hotmail.com",
                "house": "Gryffindor",
                "dob": "2000-01-15",
                "age": 23
        }*/
        final Long studentId = 1L;
        final StudentPojo expectedStudentPojo = new StudentPojo(
                1L,
                "Harry Potter",
                "harrypotter@hotmail.com",
                "Gryffindor",
                LocalDate.of(2000,01,15),
                23);
        given()
                .get("/api/v1/student/1")
        .then()
                .log().body()
                .statusCode(OK_200)
                .assertThat()
                .body("name", equalTo("Harry Potter"));
    }
}

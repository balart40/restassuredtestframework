package applications.hogwartsschool;

import applications.hogwartsschool.request.RequestFactory;

import static io.restassured.RestAssured.given;

public class BaseTest {

    public RequestFactory requestFactory;

    public final static String baseUri = "http://localhost:8080";
    public final static int port = 8080;

}

package applications.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient {

    public Response sendGetRequest(String url) {
        return given()
                .when()
                .get(url);
    }

    public Response sendDeleteRequest(String url) {
        return given()
                .when()
                .delete(url);
    }

    public Response sendPostRequest(String url, Object requestPayload) {
        return given().contentType(ContentType.JSON)
                .when()
                .body(requestPayload)
                .post(url);
    }

    public Response sendPutRequest(String url, Object requestPayload) {
        return given().contentType(ContentType.JSON)
                .when()
                .body(requestPayload)
                .put(url);
    }

    public Response sendPatchRequest(String url, Object requestPayload) {
        return given().contentType(ContentType.JSON)
                .when()
                .body(requestPayload)
                .patch(url);
    }

}

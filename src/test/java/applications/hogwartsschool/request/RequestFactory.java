package applications.hogwartsschool.request;

import applications.client.RestClient;
import io.restassured.response.Response;

public class RequestFactory {

    RestClient restClient;

    public RequestFactory() {
        restClient = new RestClient();
    }

    public Response getAllStudents() {
        return restClient.sendGetRequest("/api/v1/student");
    }

    public Response getStudentById(Long studentId) {
        String url = String.format("/api/v1/student/%s", studentId);
        return restClient.sendGetRequest(url);
    }

}

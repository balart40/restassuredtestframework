package applications.hogwartsschool.request;

import applications.client.RestClient;
import io.restassured.response.Response;

public class RequestFactory {

    RestClient restClient;

    public RequestFactory(){
        restClient = new RestClient();
    }

    public Response getAllStudents() {
        return restClient.sendGetRequest("/api/v1/student");
    }

}

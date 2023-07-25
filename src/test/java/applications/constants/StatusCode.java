package applications.constants;

public class StatusCode {
    // SUCCESS 2XX
    public static final int OK_200 = 200;
    public static final int CREATED_201 = 201;
    // ERROR 4XX 5XX
    public static final int BAD_REQUEST_400 = 400;
    public static final int UNAUTHORIZED_401 = 401;
    public static final int FORBIDDEN_403 = 403;
    public static final int NOT_FOUND_404 = 404;
    public static final int INTERNAL_ERROR_500 = 500;
    public static final int GATEWAY_TIMEOUT_503 = 503;
}

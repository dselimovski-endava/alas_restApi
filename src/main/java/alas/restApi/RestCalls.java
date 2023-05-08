package alas.restApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import alas.models.UserRequest;

public class RestCalls {

    private static final String bearerToken = "9c9f5b6c578ff68f9ca30d84bc8a29195bde7fb63918494ad4ed7dff1a03921d";

    public static Response postUserRequest(String url, UserRequest userRequest) {
        RequestSpecification requestSpecification = RestAssured.given()
                .headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .body(userRequest);
        Response response = requestSpecification.post(url);
        return response;
    }

    public static Response putUserRequest(String url, UserRequest userRequest) {
        RequestSpecification requestSpecification = RestAssured.given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .body(userRequest);
        Response response = requestSpecification.put(url);
        return response;
    }

    public static Response getUserRequest(String url) {
        RequestSpecification requestSpecification = RestAssured.given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON);
        Response response = requestSpecification.get(url);
        return response;
    }


    public static Response deleteUserRequest(String url) {
        RequestSpecification requestSpecification = RestAssured.given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON);
        Response response = requestSpecification.delete(url);
        return response;
    }

}

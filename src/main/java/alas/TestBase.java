package alas;

import alas.config.Paths;
import io.restassured.response.Response;
import alas.models.UserRequest;
import alas.models.UserResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import alas.restApi.RestCalls;

public class TestBase extends RestCalls {

    protected UserRequest createUserRequest(String name, String email, String gender, String status) {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(name);
        userRequest.setEmail(email);
        userRequest.setGender(gender);
        userRequest.setStatus(status);
        return userRequest;
    }

    protected UserRequest validUserRequest() {
        UserRequest userRequest = createUserRequest("TestUser" + RandomStringUtils.randomAlphanumeric(5)
                , "testuser" + RandomStringUtils.randomAlphanumeric(3) + "@little.io"
                , "male"
                , "active");
        return userRequest;
    }

    protected UserResponse expectedResponse(String name, String email, String gender, String status) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(name);
        userResponse.setEmail(email);
        userResponse.setGender(gender);
        userResponse.setStatus(status);
        return userResponse;
    }

    protected void checkUserResponse(UserResponse actualUserResponse, UserResponse expectedUserResponse) {
        Assert.assertNotNull(actualUserResponse.getId(), "ID is null!!!");
        Assert.assertEquals(actualUserResponse.getName(), expectedUserResponse.getName(), "Name is NOT matching!!!");
        Assert.assertEquals(actualUserResponse.getEmail(), expectedUserResponse.getEmail(), "Email is NOT matching!!!");
        Assert.assertEquals(actualUserResponse.getGender(), expectedUserResponse.getGender(), "Gender is NOT matching!!!");
        Assert.assertEquals(actualUserResponse.getStatus(), expectedUserResponse.getStatus(), "Status is NOT matching!!!");
    }

    // Creating Users
    protected Response createUser(UserRequest userRequest, int httpStatus) {
        Response response = postUserRequest(Paths.usersUrl, userRequest);
        Assert.assertEquals(response.statusCode(), httpStatus);
        return response;
    }

    protected UserResponse successfullyCreateUser() {
        Response response = createUser(validUserRequest(), 201);
        return response.as(UserResponse.class);
    }

    // Updating Users
    protected Response updateUser(Long id, UserRequest userRequest, int httpStatus) {
        String url = Paths.usersUrl + id;
        Response response = putUserRequest(url, userRequest);
        Assert.assertEquals(response.statusCode(), httpStatus);
        return response;
    }

    protected UserResponse successfullyUpdateUser(Long id) {
        Response response = updateUser(id, validUserRequest(), 200);
        return response.as(UserResponse.class);
    }

    // Getting Users
    protected Response getUser(Long id, int httpStatus) {
        String url = Paths.usersUrl + id;
        Response response = getUserRequest(url);
        Assert.assertEquals(response.statusCode(), httpStatus);
        return response;
    }

    protected UserResponse successfullyGetUser(Long id) {
        Response response = getUser(id, 200);
        return response.as(UserResponse.class);
    }

    // Delete Users
    protected Response deleteUser(Long id, int httpStatus) {
        String url = Paths.usersUrl + id;
        Response response = deleteUserRequest(url);
        Assert.assertEquals(response.statusCode(), httpStatus);
        return response;
    }

    protected void successfullyDeleteUser(Long id) {
       deleteUser(id, 204);
    }

}

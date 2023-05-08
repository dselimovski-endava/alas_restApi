package users;

import alas.TestBase;
import alas.models.UserRequest;
import alas.models.UserResponse;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class CreateNewUser extends TestBase {

    @Test
    public void testCreateNewUser() {
        successfullyCreateUser();
    }

    @Test
    public void testCreateCustomUser() {
        String sEmail = "testuser" + RandomStringUtils.randomAlphanumeric(3) + "@little.io";

        UserRequest userRequest = createUserRequest("Test", sEmail, "male", "active");
        UserResponse userResponse = expectedResponse("Test", sEmail, "male", "active");
        Response response = createUser(userRequest, 201);
        checkUserResponse(response.as(UserResponse.class), userResponse);
    }
}

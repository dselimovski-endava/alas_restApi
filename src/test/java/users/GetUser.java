package users;

import alas.TestBase;
import alas.models.UserResponse;
import org.testng.annotations.Test;

public class GetUser extends TestBase {

    @Test
    public void testGetUser() {
        UserResponse userResponse = successfullyCreateUser();
        UserResponse userResponse1 = successfullyGetUser(userResponse.getId());
        checkUserResponse(userResponse1, userResponse);
    }

}

package users;

import alas.TestBase;
import alas.models.UserResponse;
import org.testng.annotations.Test;

public class UpdateUser extends TestBase {

    @Test
    public void testUpdateUser() {
        UserResponse userResponse = successfullyCreateUser();
        successfullyUpdateUser(userResponse.getId());
    }

}

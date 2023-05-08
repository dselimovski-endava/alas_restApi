package users;

import alas.TestBase;
import alas.models.UserResponse;
import org.testng.annotations.Test;

public class DeleteUser extends TestBase {

    @Test
    public void testDeleteUser() {
        UserResponse userResponse = successfullyCreateUser();
        successfullyDeleteUser(userResponse.getId());
        getUser(userResponse.getId(), 404);
    }
}

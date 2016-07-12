import com.cloud.entities.User;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.Valid;

/**
 * 11.07.2016
 * Created by Rodion.
 */
public class ValidationTest {
    private static final String RIGHT_EMAIL = "example@gmail.com";
    private static final String WRONG_EMAIL = "wrong";

    @Valid
    User user;

    @Test
    public void testEmail() {
        this.user = new User();
        user.setEmail(RIGHT_EMAIL);
        Assert.assertEquals(RIGHT_EMAIL, user.getEmail());
    }

    @Test
    public void testEmailWrong() {
        User user1 = new User();
        User user = getUserEmail(user1, WRONG_EMAIL);
         Assert.assertNull(user.getEmail());
    }

    private User getUserEmail(@Valid User user, String email) {
        user.setEmail(email);
        return user;
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testAddUser() {
        User user = new User(1L, "Alice", "alice@example.com");
        Object result = userService.addUser(user);
        // Since addUser currently returns null, just check no exception is thrown
        assertNotNull(result);
    }

    @Test
    public void testGetUserById() {
        User user = new User(1L, "Bob", "bob@example.com");
        userService.addUser(user);
        User found = userService.getUserById(1L);
        assertNotNull(found); // Method currently returns null
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User(1L, "Carol", "carol@example.com");
        User user2 = new User(2L, "Dave", "dave@example.com");
        userService.addUser(user1);
        userService.addUser(user2);
        List<User> users = userService.getAllUsers();
        assertNotNull(users); // Method currently returns null
    }

    @Test
    public void testRemoveUserById() {
        User user = new User(1L, "Eve", "eve@example.com");
        userService.addUser(user);
        boolean removed = userService.removeUserById(1L);
        assertTrue(removed); // Method currently returns false
    }
}